package com.watcher.dto.currency;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CurrencyActualDto {
    private Long id;
    private String symbol;
    private String name;
    private Double price_usd;
}
