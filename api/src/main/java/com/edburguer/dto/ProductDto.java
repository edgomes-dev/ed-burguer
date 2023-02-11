package com.edburguer.dto;

import com.edburguer.entity.ProductCategory;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ProductDto {
    private Long id;

    private String name;

    private String imageUrl;

    private Float price;

    List<IngredientDto> ingredients = new ArrayList<>();

    private Long productCategoryId;
}
