package com.watcher.service;

import com.watcher.dto.currency.CurrencyApiResponseDto;

import java.util.List;

public interface CurrencyApiService {
    List<CurrencyApiResponseDto> getWatcherApiResponse();
}
