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
    public static Product fromDtoToEntity(ProductDto dto, List<Ingredient> ingredients, ProductCategory  productCategory, String file) {
        return Product.builder()
                .name(dto.getName())
                .imageUrl(file)
                .price(dto.getPrice())
                .ingredients(ingredients)
                .productCategory(productCategory)
                .build();
    }
}
