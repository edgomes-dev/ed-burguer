package com.edburguer.service;

import com.edburguer.dto.ProductDto;
import com.edburguer.entity.Product;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {
    void create();

    List<Product> findAll();

    Product findById(Long id);

    Product update(ProductDto productDto);

    void delete(Long id);
}
