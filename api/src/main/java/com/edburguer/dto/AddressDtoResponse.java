package com.edburguer.dto;

import com.edburguer.entity.District;
import com.edburguer.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressDtoResponse {
    private Long id;

    private String name;

    private String street;

    private String number;

    private String complement;

    private District district;

    private User user;
}
