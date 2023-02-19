package com.edburguer.mapper;

import com.edburguer.dto.ProductCategoryDto;
import com.edburguer.entity.ProductCategory;

public class ProductCategoryMapper {
    public static ProductCategory fromDtoToEntity(ProductCategoryDto dto) {
        return ProductCategory.builder()
                .name(dto.getName())
                .imageUrl(dto.getImageUrl())
                .build();
    }
}
