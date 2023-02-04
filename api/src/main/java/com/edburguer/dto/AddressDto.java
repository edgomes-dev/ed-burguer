package com.edburguer.dto;

import com.edburguer.entity.District;
import com.edburguer.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {
    private Long id;

    private String street;

    private Long number;

    private String complement;

    private District district;

    private User user;
}
