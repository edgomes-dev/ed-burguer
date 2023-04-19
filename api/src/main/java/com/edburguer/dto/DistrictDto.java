package com.edburguer.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DistrictDto {
    private Long id;

    @NotBlank(message = "valor não pode ser nulo ou vazio")
    @Size(min = 6, message = "valor mínimo igual à 6 caracteres")
    private String name;

    @NotNull
    private Double deliveryPrice;
}