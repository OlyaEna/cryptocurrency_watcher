package com.watcher.service.impl;

import com.watcher.dto.CurrencyActualDto;
import com.watcher.dto.CurrencyApiResponseDto;
import com.watcher.dto.CurrencyListDto;
import com.watcher.model.entity.Currency;
import com.watcher.model.repository.CurrencyRepository;
import com.watcher.service.CurrencyApiService;
import com.watcher.service.CurrencyService;
import com.watcher.service.mapper.CurrencyActualMapper;
import com.watcher.service.mapper.CurrencyListDtoMapper;
import com.watcher.service.mapper.CurrencyResponseMapper;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@EnableScheduling
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
        }
    }

    @Override
    public List<CurrencyListDto> getAllCurrencies() {
        List<Currency> currencies = currencyRepository.getAllCurrencies();
        return currencyDtoMapper.listToDto(currencies);
    }



    @Override
    public CurrencyActualDto findACurrentCurrency(Long id) {
//        Currency currency = currencyRepository.findCurrentCurrency(id);
//        return currencyActualMapper.toDto(currency);
        return null;
    }

}
