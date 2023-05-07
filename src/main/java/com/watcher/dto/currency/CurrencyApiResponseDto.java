package com.watcher.dto.currency;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrencyApiResponseDto {
    private Long id;
    private String symbol;
    private String name;
    private String nameid;
    private Long rank;
    private Double percent_change_7d;
    private Double market_cap_usd;
    private Double volume24;
    private Double volume24_native;
    private Double csupply;
    private Double price_btc;
    private Double tsupply;
    private Double msupply;
    private Double price_usd;
    private Double percent_change_24h;
    private Double percent_change_1h;
}
