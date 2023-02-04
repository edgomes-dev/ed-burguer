package com.edburguer.mapper;

import com.edburguer.dto.AddressDto;
import com.edburguer.entity.Address;
import com.edburguer.entity.District;
import com.edburguer.entity.User;
import org.springframework.http.ResponseEntity;

public class AddressMapper {
    public static Address fromDtoToEntity(AddressDto dto) {
        return Address.builder()
                .id(dto.getId())
                .street(dto.getStreet())
                .complement(dto.getComplement())
                .district(dto.getDistrict())
                .user(dto.getUser())
                .build();
    }
}