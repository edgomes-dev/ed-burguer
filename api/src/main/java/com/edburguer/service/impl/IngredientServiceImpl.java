package com.edburguer.service.impl;

import com.edburguer.dto.IngredientDto;
import com.edburguer.entity.Ingredient;
import com.edburguer.exception.NotFoundException;
import com.edburguer.mapper.IngredientMapper;
import com.edburguer.repository.IngredientRepository;
import com.edburguer.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class
IngredientServiceImpl implements IngredientService {
    @Autowired
    IngredientRepository ingredientRepository;
    @Override
    public Ingredient create(IngredientDto ingredientDto) {
        return ingredientRepository.save(IngredientMapper.fromDtoToEntity(ingredientDto));
    }

    @Override
    public List<Ingredient> findAll() {
        return ingredientRepository.findAll();
    }

    @Override
    public Ingredient findById(Long id) {
        Optional<Ingredient> response = ingredientRepository.findById(id);

        if(response.isEmpty()) throw new NotFoundException("Ingredient não encontrado");

        return response.get();
    }

    @Override
    public Ingredient update(IngredientDto ingredientDto) {
        Optional<Ingredient> ingredient = ingredientRepository.findById(ingredientDto.getId());

        if(ingredient.isEmpty()) throw new NotFoundException("Ingredient não encontrado");

        ingredient.get().setName(ingredientDto.getName());
        ingredient.get().setPrice(ingredientDto.getPrice());

        return ingredientRepository.save(ingredient.get());
    }
}
