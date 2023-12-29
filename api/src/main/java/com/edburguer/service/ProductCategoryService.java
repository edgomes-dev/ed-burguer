package com.edburguer.service;

import com.edburguer.dto.ProductCategoryDto;
import com.edburguer.dto.initDb.ProductCategoryInitDbDto;
import com.edburguer.entity.ProductCategory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductCategoryService {
    ProductCategory create(ProductCategoryDto productCategoryDto);

    @Transactional
    ProductCategory create(ProductCategoryInitDbDto dto);

    List<ProductCategory> findAll();

    ProductCategory findById(Long id);

    ProductCategory update(ProductCategoryDto productCategoryDto);

    void delete(Long id);
}
