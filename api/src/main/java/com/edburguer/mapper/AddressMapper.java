package com.edburguer.mapper;

import com.edburguer.dto.AddressDtoRequest;
import com.edburguer.dto.AddressDtoResponse;
import com.edburguer.entity.Address;
import com.edburguer.entity.District;
import com.edburguer.entity.User;

public class AddressMapper {
    public static Address fromDtoRequestToEntity(AddressDtoRequest dto, District district, User user) {
        return Address.builder()
                .id(dto.getId())
                .name(dto.getName())
                .street(dto.getStreet())
                .number(dto.getNumber())
                .complement(dto.getComplement())
                .district(district)
                .user(user)
                .build();
    }

    public static AddressDtoResponse fromEntityToDtoResponse(Address address) {
        return AddressDtoResponse.builder()
                .id(address.getId())
                .name(address.getName())
                .street(address.getStreet())
                .number(address.getNumber())
                .complement(address.getComplement())
                .district(address.getDistrict())
                .user(address.getUser())
                .build();
    }

    public static Address fromDtoResponseToEntity(AddressDtoResponse address, District district, User user) {
        return Address.builder()
                .id(address.getId())
                .name(address.getName())
                .street(address.getStreet())
                .number(address.getNumber())
                .complement(address.getComplement())
                .district(district)
                .user(user)
                .build();
    }
}