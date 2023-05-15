package com.edburguer.service;

import com.edburguer.dto.ProductCategoryDto;
import com.edburguer.entity.ProductCategory;
import com.edburguer.exception.NotFoundException;
import com.edburguer.repository.ProductCategoryRepository;
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
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
public class ProductCategoryServiceTest {
    @Autowired
    ProductCategoryService service;

    @MockBean
    ProductCategoryRepository repository;

    @Test
    @DisplayName("POST Create")
    public void should_createProductCategorySucess() {
        // arrange
        ProductCategoryDto productCategoryDto = new ProductCategoryDto(null, "Salgados", "/test");
        ProductCategory productCategory = new ProductCategory(1L, "Salgados", "/test");
        Mockito.doReturn(productCategory).when(repository).save(any());

        // action
        ProductCategory productCategoryReturn = service.create(productCategoryDto);

        // assertions
        Assertions.assertNotNull(productCategoryReturn);
        Assertions.assertEquals(productCategory, productCategoryReturn);
    }

    @Test
    @DisplayName("GET find all products")
    public void should_findAllProductCategory() {
        // arrange
        ProductCategory productCategory = new ProductCategory(1L, "Salgados", "/test");
        ProductCategory productCategoryTwo = new ProductCategory(2L, "Bebidas", "/images");
        Mockito.doReturn(Arrays.asList(productCategory, productCategoryTwo)).when(repository).findAll();

        // action
        List<ProductCategory> list = service.findAll();

        // assertions
        Assertions.assertEquals(2, list.size());
    }

    @Test
    @DisplayName("GET findByID")
    public void should_findByIdProductCategorySucess_when_idExits() {
        // arrange
        ProductCategory productCategory = new ProductCategory(1L, "Salgados", "/test");
        Mockito.doReturn(Optional.of(productCategory)).when(repository).findById(1L);

        // action
        ProductCategory productCategoryReturn = service.findById(1L);

        // assertions
        Assertions.assertEquals(productCategory, productCategoryReturn);
    }

    @Test
    @DisplayName("GET findByID Failure")
    public void should_findByIdProductCategoryFailure_when_idNotExits() {
        // arrange
        Mockito.doThrow(NotFoundException.class).when(repository).findById(1L);

        // action
        Executable executable = new Executable() {
            @Override
            public void execute() throws Throwable {
                ProductCategory productCategory = service.findById(1L);
            }
        };

        // assertions
        Assertions.assertThrows(NotFoundException.class, executable);
    }

    @Test
    @DisplayName("PUT update product category")
    public void should_updateProductCategorySucess_when_idExists() {
        // arrange
        ProductCategoryDto productCategoryDto = new ProductCategoryDto(1L, "Bebidas", "/bebidas");
        ProductCategory productCategoryExpected = new ProductCategory(1L, "Bebidas", "/bebidas");
        ProductCategory productCategoryExists = new ProductCategory(1L, "Salgados", "/test");
        Mockito.doReturn(Optional.of(productCategoryExists)).when(repository).findById(1L);
        Mockito.doReturn(productCategoryExpected).when(repository).save(any());

        // action
        ProductCategory productCategoryReturn = service.update(productCategoryDto);

        // assertions
        Assertions.assertNotNull(productCategoryReturn);
        Assertions.assertEquals(productCategoryExpected, productCategoryReturn);
    }

    @Test
    @DisplayName("PUT failure update product category")
    public void should_updateProductCategoryFailure_when_idNotExists() {
        // arrange
        ProductCategoryDto productCategoryDto = new ProductCategoryDto(1L, "Bebidas", "/bebidas");

        // action
        Executable executable = new Executable() {
            @Override
            public void execute() throws Throwable {
                ProductCategory productCategoryReturn = service.update(productCategoryDto);
            }
        };

        // assertions
        Assertions.assertThrows(NotFoundException.class, executable);
    }
}
