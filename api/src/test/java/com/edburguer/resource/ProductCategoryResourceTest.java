package com.edburguer.resource;

import com.edburguer.dto.ProductCategoryDto;
import com.edburguer.entity.ProductCategory;
import com.edburguer.exception.NotFoundException;
import com.edburguer.service.ProductCategoryService;
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

import java.util.Arrays;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductCategoryResourceTest {
    @MockBean
    private ProductCategoryService service;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Create Product Category")
    public void testPostCreateProductCategory() throws Exception {
        ProductCategoryDto productCategoryDto = new ProductCategoryDto(null, "Salgados");
        ProductCategory productCategoryExpected = new ProductCategory(1L, "Salgados", "/salgados");
        Mockito.doReturn(productCategoryExpected).when(service).create(productCategoryDto);

        mockMvc.perform(MockMvcRequestBuilders.post("/product-categories")
                .content(asJsonString(productCategoryDto))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", Is.is(1)))
                .andExpect(jsonPath("$.name", Is.is("Salgados")));
    }

    @Test
    @DisplayName("FindAll Product Category")
    public void testGetAllProductsCategory() throws Exception {
        ProductCategory productCategory = new ProductCategory(1L, "Salgados", "/salgados");
        ProductCategory productCategoryTwo = new ProductCategory(2L, "Bebidas", "/bebidas");
        Mockito.doReturn(Arrays.asList(productCategory, productCategoryTwo)).when(service).findAll();

        mockMvc.perform(MockMvcRequestBuilders.get("/product-categories"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", Is.is(1)))
                .andExpect(jsonPath("$[0].name", Is.is("Salgados")))
                .andExpect(jsonPath("$[1].id", Is.is(2)))
                .andExpect(jsonPath("$[1].name", Is.is("Bebidas")));
    }

    @Test
    @DisplayName("Get FindById Sucess")
    public  void testGetFindByIdSucess() throws Exception {
        ProductCategory productCategory = new ProductCategory(1L, "Salgados", "/salgados");
        Mockito.doReturn(productCategory).when(service).findById(1L);

        mockMvc.perform(MockMvcRequestBuilders.get("/product-categories/1"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", Is.is(1)))
                .andExpect(jsonPath("$.name", Is.is("Salgados")))
                .andExpect(jsonPath("$.imageUrl", Is.is("/salgados")));
    }

    @Test
    @DisplayName("Get FindById Failure")
    public void testGetFindByIdFailure_when_idNotExists() throws Exception {
        Mockito.doThrow(NotFoundException.class).when(service).findById(1L);

        mockMvc. perform(MockMvcRequestBuilders.get("/product-categories/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("Update Sucess")
    public void testPutSucessProductCategory() throws Exception {
        ProductCategoryDto productCategoryDto = new ProductCategoryDto(1L, "Salgados");
        ProductCategory productCategoryExpected = new ProductCategory(1L, "Salgados", "/salgados");
        ProductCategory productCategoryExists = new ProductCategory(1L, "Salgado", "/salgado");
        Mockito.doReturn(productCategoryExists).when(service).findById(1L);
        Mockito.doReturn(productCategoryExpected).when(service).update(productCategoryDto);

        mockMvc.perform(MockMvcRequestBuilders.put("/product-categories")
                .content(asJsonString(productCategoryDto))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name", Is.is("Salgados")));
    }

    @Test
    @DisplayName("Updated Failure")
    public void testPutFailureProductCategory_when_idNotExists() throws Exception {
        ProductCategoryDto productCategoryDto = new ProductCategoryDto(1L, "Salgados");
        Mockito.doThrow(NotFoundException.class).when(service).update(productCategoryDto);

        mockMvc.perform(MockMvcRequestBuilders.put("/product-categories")
                .content(asJsonString(productCategoryDto))
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
