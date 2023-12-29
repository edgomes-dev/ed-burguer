package com.edburguer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDtoInitDB {
    private Long id;
    private String name;
    private String imageUrl;
    private String description;
    private Double price;
    private Long productCategoryId;
    private List<Long> ingredients;
}
