package com.edburguer.mapper;

import com.edburguer.dto.OptionDto;
import com.edburguer.entity.Ingredient;
import com.edburguer.entity.Option;
import com.edburguer.entity.ProductCategory;

import java.util.List;

public class OptionMapper {
    public static Option fromDtoToEntity(OptionDto dto, List<Ingredient> ingredientList) {
        return  Option.builder()
                .id(dto.getId())
                .name(dto.getName())
                .maximumAmount(dto.getMaximumAmount())
                .required(dto.getRequired())
                .ingredients(ingredientList)
                .build();
    }
}
