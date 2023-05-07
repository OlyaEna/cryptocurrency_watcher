package com.watcher.service.mapper;

import com.watcher.dto.currency.CurrencyListDto;
import com.watcher.model.entity.Currency;
import com.watcher.model.repository.CurrencyRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
@AllArgsConstructor
@Data
public class CurrencyListDtoMapper {
    private ModelMapper modelMapper;
    private final CurrencyRepository currencyRepository;

    public Currency toEntity(CurrencyListDto dto) {
        return Objects.isNull(dto) ? null : modelMapper.map(dto, Currency.class);
    }

    public CurrencyListDto toDto(Currency entity) {
        return Objects.isNull(entity) ? null : modelMapper.map(entity, CurrencyListDto.class);
    }

    public List<CurrencyListDto> listToDto(List<Currency> entity) {
        return Objects.isNull(entity) ? null : modelMapper.map(entity, new TypeToken<List<CurrencyListDto>>() {
        }.getType());
    }
}
