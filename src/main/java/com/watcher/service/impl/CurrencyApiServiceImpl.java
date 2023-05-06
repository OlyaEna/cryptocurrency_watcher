package com.watcher.service.impl;

import com.watcher.dto.CurrencyApiResponseDto;
import com.watcher.service.CurrencyApiService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CurrencyApiServiceImpl implements CurrencyApiService {

    private @Value("${coinlore.API.WATCHER.URI}") String API_URI;

    public List<CurrencyApiResponseDto> getWatcherApiResponse() {
        RestTemplate restTemplate = new RestTemplate();
        ParameterizedTypeReference<List<CurrencyApiResponseDto>> type = new ParameterizedTypeReference<List<CurrencyApiResponseDto>>() {};
        List<CurrencyApiResponseDto> currencyApiResponseDtos = restTemplate.exchange(API_URI, HttpMethod.GET, null, type).getBody();
        return currencyApiResponseDtos;
    }


}