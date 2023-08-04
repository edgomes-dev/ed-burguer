package com.edburguer.mapper;

import com.edburguer.dto.IngredientDto;
import com.edburguer.entity.Ingredient;

public class IngredientMapper {
    public static Ingredient fromDtoToEntity(IngredientDto dto) {
        return Ingredient.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .price(dto.getPrice())
                .repetitions(dto.getRepetitions())
                .build();
    }
}
