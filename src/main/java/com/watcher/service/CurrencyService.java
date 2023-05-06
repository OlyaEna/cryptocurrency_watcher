package com.watcher.service;

import com.watcher.dto.CurrencyActualDto;
import com.watcher.dto.CurrencyListDto;
import com.watcher.model.entity.Currency;

import java.util.List;

public interface CurrencyService {
    void saveCurrencyToDB();
    List<CurrencyListDto> getAllCurrencies();
    CurrencyActualDto findACurrentCurrency(Long id);

}
