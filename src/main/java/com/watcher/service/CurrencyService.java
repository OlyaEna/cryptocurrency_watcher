package com.watcher.service;

import com.watcher.dto.currency.CurrencyActualDto;
import com.watcher.dto.currency.CurrencyListDto;

import java.util.List;

public interface CurrencyService {
    void saveCurrencyToDB();
    List<CurrencyListDto> getAllCurrencies();
    CurrencyActualDto findCurrentCurrency(String symbol);

}
