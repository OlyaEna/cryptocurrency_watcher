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

    public Currency toEntity(CurrencyActualDto dto) {
        return Objects.isNull(dto) ? null : modelMapper.map(dto, Currency.class);
    }

    public CurrencyActualDto toDto(Currency entity) {
        return Objects.isNull(entity) ? null : modelMapper.map(entity, CurrencyActualDto.class);
    }

    public List<CurrencyActualDto> listToDto(List<Currency> entity) {
        return Objects.isNull(entity) ? null : modelMapper.map(entity, new TypeToken<List<CurrencyActualDto>>() {
        }.getType());
    }
}
