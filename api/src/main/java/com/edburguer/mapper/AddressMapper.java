package com.edburguer.mapper;

import com.edburguer.dto.AddressDto;
import com.edburguer.entity.Address;
import com.edburguer.entity.District;

public class AddressMapper {
    public static Address fromDtoToEntity(AddressDto dto, District district) {
        return Address.builder()
                .id(dto.getId())
                .street(dto.getStreet())
                .number(dto.getNumber())
                .complement(dto.getComplement())
                .district(district)
                .user(dto.getUser())
                .build();
    }
}