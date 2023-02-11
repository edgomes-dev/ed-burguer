package com.edburguer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {
    private Long id;

    private String name;

    private String street;

    private String number;

    private String complement;

    private Long districtId;

    private Long userId;
}
