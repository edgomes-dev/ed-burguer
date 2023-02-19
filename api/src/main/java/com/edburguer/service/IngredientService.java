package com.edburguer.service;

import com.edburguer.dto.IngredientDto;
import com.edburguer.entity.Ingredient;

import java.util.List;

public interface IngredientService {
    Ingredient create(IngredientDto ingredientDto);

    List<Ingredient> findAll();

    Ingredient findById(Long id);

    Ingredient update(IngredientDto ingredientDto);

    void delete(Long id);
}
