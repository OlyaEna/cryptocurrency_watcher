package com.watcher.service;

import com.watcher.dto.CurrencyApiResponseDto;

import java.util.List;

public interface CurrencyApiService {
    List<CurrencyApiResponseDto> getWatcherApiResponse();
}
