package com.edburguer.mapper;

import com.edburguer.dto.ProductDto;
import com.edburguer.entity.Product;

public class ProductMapper {
    public static Product fromDtoToEntity(ProductDto dto) {
        return Product.builder()
                .name(dto.getName())
                .imageUrl(dto.getImageUrl())
                .price(dto.getPrice())
                .build();
    }
}