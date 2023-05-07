package com.watcher.service.mapper;

import com.watcher.dto.currency.CurrencyActualDto;
import com.watcher.model.entity.Currency;
import com.watcher.model.repository.CurrencyRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.util.List;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Data
public class CurrencyActualMapper {
    private ModelMapper modelMapper;
    private final CurrencyRepository currencyRepository;

    public CurrencyActualDto toDto(Currency entity) {
        return Objects.isNull(entity) ? null : modelMapper.map(entity, CurrencyActualDto.class);
    }
}
