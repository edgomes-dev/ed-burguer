package com.edburguer.mapper;

import com.edburguer.dto.IngredientDto;
import com.edburguer.entity.Ingredient;

public class IngredientMapper {
    public static Ingredient fromDtoToEntity(IngredientDto dto) {
        return Ingredient.builder()
                .name(dto.getName())
                .price(dto.getPrice())
                .build();
    }
}
