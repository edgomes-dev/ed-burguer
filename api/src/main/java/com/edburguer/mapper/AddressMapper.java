package com.edburguer.mapper;

import com.edburguer.dto.AddressDto;
import com.edburguer.entity.Address;
import com.edburguer.entity.District;
import com.edburguer.entity.User;

public class AddressMapper {
    public static Address fromDtoToEntity(AddressDto dto, District district) {
        return Address.builder()
                .id(dto.getId())
                .name(dto.getName())
                .street(dto.getStreet())
                .number(dto.getNumber())
                .complement(dto.getComplement())
                .district(district)
                .build();
    }
}