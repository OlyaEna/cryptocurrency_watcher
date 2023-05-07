package com.watcher.service.impl;

import com.watcher.dto.currency.CurrencyActualDto;
import com.watcher.dto.currency.CurrencyApiResponseDto;
import com.watcher.dto.currency.CurrencyListDto;
import com.watcher.model.entity.Currency;
import com.watcher.model.repository.CurrencyRepository;
import com.watcher.service.CurrencyApiService;
import com.watcher.service.CurrencyService;
import com.watcher.service.mapper.CurrencyActualMapper;
import com.watcher.service.mapper.CurrencyListDtoMapper;
import com.watcher.service.mapper.CurrencyResponseMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@EnableScheduling
@Slf4j
public class CurrencyServiceImpl implements CurrencyService {
    private final CurrencyRepository currencyRepository;
    private final CurrencyApiService currencyApiService;
    private final CurrencyResponseMapper currencyResponseMapper;
    private final CurrencyListDtoMapper currencyDtoMapper;
    private final CurrencyActualMapper currencyActualMapper;

    @Scheduled(cron = "${interval-in-cron}")
    @Override
    public void saveCurrencyToDB() {
        List<CurrencyApiResponseDto> currencyApiResponse = currencyApiService.getWatcherApiResponse();
        for (CurrencyApiResponseDto currency : currencyApiResponse) {
            currencyRepository.save(currencyResponseMapper.toEntity(currency));
            log.info("Currencies saved");
        }
    }

    @Override
    public List<CurrencyListDto> getAllCurrencies() {
        log.info("Get all currencies");
        List<Currency> currencies = currencyRepository.getAllCurrencies();
        return currencyDtoMapper.listToDto(currencies);
    }


    @Override
    public CurrencyActualDto findCurrentCurrency(String symbol) {
        log.info("Get currency with symbol=" + symbol);
        Currency currency = currencyRepository.findCurrentCurrency(symbol);
        return currencyActualMapper.toDto(currency);

    }

}
