package com.edburguer.mapper;

import com.edburguer.dto.ProductDto;
import com.edburguer.entity.Product;
import com.edburguer.entity.User;

public class ProductMapper {
    public Product fromDtoToEntity(ProductDto dto) {
        return User.builder()
                .name(dto)
                .build();
    }
}
