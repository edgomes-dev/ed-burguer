package com.edburguer.service;

import com.edburguer.dto.ProductDto;
import com.edburguer.entity.Product;

import java.util.List;

public interface ProductService {
    Product create(ProductDto productDto);

    List<Product> findAll();

    Product findById(Long id);

    Product update(ProductDto productDto);

    void delete(Long id);
}
