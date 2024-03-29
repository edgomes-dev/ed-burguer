package com.edburguer.service;

import com.edburguer.dto.ProductDto;
import com.edburguer.dto.ProductDtoInitDB;
import com.edburguer.entity.Product;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {
    Product create(ProductDto productDto);

    Product create(ProductDtoInitDB dto);

    List<Product> findAll();

    Product findById(Long id);

    Product update(ProductDto productDto);

    void delete(Long id);
}
