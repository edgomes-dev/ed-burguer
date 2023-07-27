package com.edburguer.mapper;

import com.edburguer.dto.ProductDto;
import com.edburguer.entity.Ingredient;
import com.edburguer.entity.Product;
import com.edburguer.entity.ProductCategory;
import com.edburguer.service.FirebaseService;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class ProductMapper {
    public static Product fromDtoToEntity(ProductDto dto, ProductCategory  productCategory) {
        return Product.builder()
                .name(dto.getName())
                .imageUrl("")
                .price(dto.getPrice())
                .productCategory(productCategory)
                .build();
    }
}