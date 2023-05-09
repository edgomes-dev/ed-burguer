package com.edburguer.service;

import com.edburguer.dto.IngredientDto;
import com.edburguer.entity.Ingredient;
import com.edburguer.exception.NotFoundException;
import com.edburguer.repository.IngredientRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
public class IngredientServiceTest {
    @Autowired
    IngredientService ingredientService;

    @MockBean
    IngredientRepository ingredientRepository;

    @Test
    @DisplayName("POST create ingredient")
    public void should_createIngredientSucess() {
        // arrange
        IngredientDto ingredientDto = new IngredientDto();
        ingredientDto.setName("Milho e ervilha");
        ingredientDto.setPrice(2.0);
        Ingredient ingredient = new Ingredient();
        ingredient.setId(1L);
        ingredient.setName("Milho e ervilha");
        ingredient.setPrice(2.0);

        Mockito.doReturn(ingredient).when(ingredientRepository).save(any());

        // action
        Ingredient ingredientTest = ingredientService.create(ingredientDto);

        // assertions
        Assertions.assertNotNull(ingredientTest);
    }

    @Test
    @DisplayName("GET find all ingredients")
    public void should_findAllIngredientsSucess() {
        // arrange
        Ingredient ingredient = new Ingredient();
        ingredient.setId(1L);
        ingredient.setName("Milho e ervilha");
        ingredient.setPrice(2.0);
        Ingredient ingredient1 = new Ingredient();
        ingredient1.setId(2L);
        ingredient1.setName("Milho assado");
        ingredient1.setPrice(4.0);

        Mockito.doReturn(Arrays.asList(ingredient, ingredient1)).when(ingredientRepository).findAll();
        // action
        List<Ingredient> list = ingredientService.findAll();

        // assertions
        Assertions.assertEquals(2, list.size());
    }

    @Test
    @DisplayName("GET retornar um ingredient quando o ID for válido")
    public void should_findByIdIngredientsSucess_when_idExists() {
        // arrange
        Ingredient ingredientExpected = new Ingredient();
        ingredientExpected.setId(1L);
        ingredientExpected.setName("Milho e ervilha");
        ingredientExpected.setPrice(2.0);

        Mockito.doReturn(Optional.of(ingredientExpected)).when(ingredientRepository).findById(1L);

        // action
        Optional<Ingredient> ingredientReturn = Optional.ofNullable(ingredientService.findById(1L));

        // assertions
        Assertions.assertEquals(ingredientReturn.get(), ingredientExpected);
    }

    @Test
    @DisplayName("GET retornar um exception quando o ID for inválido")
    public void should_findByIdIngredientsError_when_idNotExists() {
        // arrange
        Mockito.doThrow(NotFoundException.class).when(ingredientRepository).findById(1L);

        // action
        Executable executable = new Executable() {
            @Override
            public void execute() throws Throwable {
                Ingredient ingredientExecute = ingredientService.findById(1L);
            }
        };

        // assertions
        Assertions.assertThrows(NotFoundException.class, executable);
    }

    @Test
    @DisplayName("PUT atualizar o ingredient com sucesso quando o id for válido")
    public void should_updateIngredientsSucess_when_idExists() {
        // arrange
        IngredientDto ingredientDto = new IngredientDto(1L, "Milho verde", 3.0);

        Ingredient ingredientExists = new Ingredient();
        ingredientExists.setId(1L);
        ingredientExists.setName("Milho e ervilha");
        ingredientExists.setPrice(4.0);

        Ingredient ingredientExpected = new Ingredient();
        ingredientExpected.setId(1L);
        ingredientExpected.setName("Milho verde");
        ingredientExpected.setPrice(3.0);

        Mockito.doReturn(Optional.of(ingredientExists)).when(ingredientRepository).findById(1L);
        Mockito.doReturn(ingredientExpected).when(ingredientRepository).save(any());

        // action
        Ingredient ingredientReturn = ingredientService.update(ingredientDto);

        // assertions
        Assertions.assertTrue(Objects.nonNull(ingredientReturn));
    }

    @Test
    @DisplayName("PUT error ao tentar atualizar um ingredient com ID inválido")
    public void should_updateIngredientsFailure_when_idNotExists() {
        // arrange
        IngredientDto ingredientDto = new IngredientDto(1L, "Milho verde", 3.0);
        Mockito.doThrow(NotFoundException.class).when(ingredientRepository).findById(1L);

        // action
        Executable executable = new Executable() {
            @Override
            public void execute() throws Throwable {
                Ingredient ingredientExecute = ingredientService.update(ingredientDto);
            }
        };

        // assertions
        Assertions.assertThrows(NotFoundException.class, executable);
    }
}
