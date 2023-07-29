package com.edburguer.mapper;

import com.edburguer.dto.ProductCategoryDto;
import com.edburguer.entity.Product;
import com.edburguer.entity.ProductCategory;

import java.util.ArrayList;

public class ProductCategoryMapper {
    public static ProductCategory fromDtoToEntity(ProductCategoryDto dto) {
        return ProductCategory.builder()
                .id(dto.getId())
                .name(dto.getName())
                .imageUrl(dto.getImageUrl())
                .build();
    }
}
