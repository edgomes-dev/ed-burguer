package com.edburguer.resource;

import com.edburguer.dto.IngredientDto;
import com.edburguer.entity.Ingredient;
import com.edburguer.exception.NotFoundException;
import com.edburguer.service.IngredientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.Optional;

import static org.hamcrest.Matchers.any;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class IngredientResourceTest {
    @MockBean
    private IngredientService ingredientService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Criar com sucesso um Ingredient")
    public void testPostCreateIngredient() throws Exception {
        IngredientDto ingredientDto = new IngredientDto(null, "Milho e ervilha", 2.0);
        Ingredient ingredientExpected = new Ingredient(1L, "Milho verde", 2.0, null);
        Mockito.doReturn(ingredientExpected).when(ingredientService).create(ingredientDto);

        mockMvc.perform(MockMvcRequestBuilders.post("/ingredient")
                .content(asJsonString(ingredientDto))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", Is.is(1)));
    }

    @Test
    @DisplayName("Retornar todos os ingredients com sucesso")
    public void testGetALLIngredients() throws Exception {
        Ingredient ingredient = new Ingredient(1L, "Milho", 2.0, null);
        Ingredient ingredient1 = new Ingredient(2L, "Ervilha", 4.0, null);
        Mockito.doReturn(Arrays.asList(ingredient, ingredient1)).when(ingredientService).findAll();

        mockMvc.perform(MockMvcRequestBuilders.get("/ingredient"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", Is.is(1)))
                .andExpect(jsonPath("$[0].name", Is.is("Milho")))
                .andExpect(jsonPath("$[1].id", Is.is(2)))
                .andExpect(jsonPath("$[1].name", Is.is("Ervilha")));
    }

    @Test
    @DisplayName("Retornar um ingredient com sucesso quando o id for válido")
    public void testGetFindByIdSucessWhenIdExists() throws Exception {
        Ingredient ingredient = new Ingredient(1L, "Milho e ervilha", 2.0, null);
        Mockito.doReturn(ingredient).when(ingredientService).findById(1L);

        mockMvc.perform(MockMvcRequestBuilders.get("/ingredient/1"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", Is.is(1)))
                .andExpect(jsonPath("$.name", Is.is("Milho e ervilha")));
    }

    @Test
    @DisplayName("Retornar NotFoundException quando o id for válido")
    public void testGetFindByIdFailureWhenIdNotExists() throws Exception {
        Mockito.doThrow(NotFoundException.class).when(ingredientService).findById(10L);

        mockMvc.perform(MockMvcRequestBuilders.get("/ingredient/10"))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("Atualizar com sucesso um Ingredient")
    public void testPutUpdateIngredientSucess_when_idExists() throws Exception {
        IngredientDto ingredientDto = new IngredientDto(1L, "Milho e ervilha", 2.0);
        Ingredient ingredientActual = new Ingredient(1L, "Milho verde", 2.0, null);
        Ingredient ingredientExpected = new Ingredient(1L, "Milho e ervilha", 4.0, null);

        Mockito.doReturn(ingredientActual).when(ingredientService).findById(1L);
        Mockito.doReturn(ingredientExpected).when(ingredientService).update(ingredientDto);

        mockMvc.perform(MockMvcRequestBuilders.put("/ingredient")
                        .content(asJsonString(ingredientDto))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", Is.is(1)));
    }

    @Test
    @DisplayName("NotFoundException um Ingredient quando o id for inválido")
    public void testPutUpdateIngredientFailure_when_idNotExists() throws Exception {
        IngredientDto ingredientDto = new IngredientDto(1L, "Milho e ervilha", 2.0);

        Mockito.doThrow(NotFoundException.class).when(ingredientService).update(ingredientDto);

        mockMvc.perform(MockMvcRequestBuilders.put("/ingredient")
                        .content(asJsonString(ingredientDto))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
