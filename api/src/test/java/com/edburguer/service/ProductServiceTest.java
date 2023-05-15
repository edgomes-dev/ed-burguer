package com.edburguer.service;

import com.edburguer.dto.ProductDto;
import com.edburguer.repository.ProductRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class ProductServiceTest {
    @Autowired
    ProductService productService;

    @MockBean
    ProductRepository productRepository;

    @Test
    @DisplayName("Criar um produto com sucesso")
    public void should_createProductSucess() {
        ProductDto productRequest = new ProductDto();
    }

    @Test
    @DisplayName("Retornar todos os produtos com sucesso")
    public void should_findAllProductsSucess() {}

    @Test
    @DisplayName("Retornar um produto com sucesso quando o ID for válido")
    public void should_findByIdSucess_when_idExists() {}

    @Test
    @DisplayName("Retornar um NotFoundException quando o ID for inválido")
    public void should_findByIdFaolure_when_idNotExists() {}

    @Test
    @DisplayName("Atualizar com sucesso quando o ID for válido")
    public void should_updateProductSucess_when_idExits() {}

    @Test
    @DisplayName("NotFoundException quando o ID for válido")
    public void should_updateProductFailure_when_idNotExits() {}
}
