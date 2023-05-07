package com.watcher.service.mapper;

import com.watcher.dto.currency.CurrencyApiResponseDto;
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
public class CurrencyResponseMapper {
    private ModelMapper modelMapper;
    private final CurrencyRepository currencyRepository;

    public Currency toEntity(CurrencyApiResponseDto dto) {
        return Objects.isNull(dto) ? null : modelMapper.map(dto, Currency.class);
    }

    public CurrencyApiResponseDto toDto(Currency entity) {
        return Objects.isNull(entity) ? null : modelMapper.map(entity, CurrencyApiResponseDto.class);
    }

    public List<CurrencyApiResponseDto> listToDto(List<Currency> entity) {
        return Objects.isNull(entity) ? null : modelMapper.map(entity, new TypeToken<List<CurrencyApiResponseDto>>() {
        }.getType());
    }
}
