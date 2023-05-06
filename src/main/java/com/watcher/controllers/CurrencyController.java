package com.watcher.controllers;

import com.watcher.dto.CurrencyActualDto;
import com.watcher.dto.CurrencyListDto;
import com.watcher.model.entity.Currency;
import com.watcher.model.repository.CurrencyRepository;
import com.watcher.service.CurrencyService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@AllArgsConstructor
@RestController
public class CurrencyController {
    private final CurrencyService currencyService;
    private final CurrencyRepository currencyRepository;

    /**
     * Просмотр списка доступных криптовалют
     */

    @GetMapping(path = "/all")
    public List<CurrencyListDto> getAllCurrencies() {
        return currencyService.getAllCurrencies();
    }

    /**
     * Просмотр актуальной цены для указаной криптовалюты
     */

//    @GetMapping(path = "/current/{id}")
//    public CurrencyActualDto findCurrentCurrency(@PathVariable Long id){
//        return currencyService.findACurrentCurrency(id);
//    }

    @GetMapping(path = "/current/{id}")
    public List<Currency> findCurrentCurrency(@PathVariable Long id){
        return currencyRepository.findCurrentCurrency(id);
    }


    @GetMapping(path = "/current")
    public Currency findCurrentCurrency(){
        return currencyRepository.findCurrency();
    }
}
