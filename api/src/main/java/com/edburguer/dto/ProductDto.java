package com.edburguer.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ProductDto {
    private Long id;

    private String name;

    private String imageUrl;

    private Float price;

    private List<Long> ingredientsId = new ArrayList<>();

    private Long productCategoryId;
}
