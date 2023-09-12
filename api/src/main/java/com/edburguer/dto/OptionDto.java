package com.edburguer.dto;

import lombok.Data;

import java.util.List;

@Data
public class OptionDto {
    private Long id;

    private String name;

    private Integer maximumAmount;

    private Boolean required;

    private String optionsRequired;

    private List<Long> ingredients;
}
