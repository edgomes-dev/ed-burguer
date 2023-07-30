package com.edburguer.mapper;

import com.edburguer.dto.OptionDto;
import com.edburguer.entity.Option;
import com.edburguer.entity.Product;

public class OptionMapper {
    public static Option fromDtoToEntity(OptionDto dto) {
        return Option.builder()
                .name(dto.getName())
                .maximumAmount(dto.getMaximumAmount())
                .required(dto.getRequired())
                .repetitious(dto.getRepetitious())
                .build();
    }
}
