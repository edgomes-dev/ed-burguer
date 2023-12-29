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
public class OptionDto {
    private Long id;

    private String name;

    private Integer maximumAmount;

    private Boolean required;

    private Long productCategory;

    private List<Long> ingredients;
}
