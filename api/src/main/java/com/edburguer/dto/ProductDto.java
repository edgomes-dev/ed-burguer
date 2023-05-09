package com.edburguer.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Data
public class ProductDto {
    private Long id;

    private String name;

    private MultipartFile file;

    private Double price;

    private List<Long> ingredientsId = new ArrayList<>();

    private Long productCategoryId;
}
