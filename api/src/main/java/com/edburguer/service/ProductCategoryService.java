package com.edburguer.service;

import com.edburguer.dto.ProductCategoryDto;
import com.edburguer.entity.ProductCategory;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductCategoryService {
    ProductCategory create(ProductCategoryDto productCategoryDto);

    List<ProductCategory> findAll();

    ProductCategory findById(Long id);

    ProductCategory update(ProductCategoryDto productCategoryDto);

    void delete(Long id);
}
