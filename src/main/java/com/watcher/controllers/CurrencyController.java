package com.watcher.controllers;

import com.watcher.dto.currency.CurrencyActualDto;
import com.watcher.dto.currency.CurrencyListDto;
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

    /**
     * Просмотр списка доступных криптовалют
     */

    @GetMapping(path = "/all")
    public List<CurrencyListDto> getAllCurrencies() {
        return currencyService.getAllCurrencies();
    }

    /**
     * Просмотр актуальной цены для указаной криптовалюты
     * по коду криптовалюты (символ)
     */

    @GetMapping(path = "/current/{symbol}")
    public CurrencyActualDto findCurrentCurrency(@PathVariable String symbol){
        return currencyService.findCurrentCurrency(symbol);
    }


}
