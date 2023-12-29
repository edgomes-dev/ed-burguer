package com.edburguer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressDto {
    private Long id;

    private String name;

    private String street;

    private String number;

    private String complement;

    private Long districtId;

    private Long userId;
}
