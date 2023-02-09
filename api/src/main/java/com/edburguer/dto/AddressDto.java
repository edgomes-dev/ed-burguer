package com.edburguer.dto;

import com.edburguer.entity.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {
    private Long id;

    private String street;

    private String number;

    private String complement;

    @JsonProperty(namespace = "district_id")
    private Long districtId;

    private User user;
}
