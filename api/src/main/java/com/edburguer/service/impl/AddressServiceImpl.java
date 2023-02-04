package com.edburguer.service.impl;

import com.edburguer.dto.AddressDto;
import com.edburguer.dto.DistrictDto;
import com.edburguer.entity.Address;
import com.edburguer.entity.District;
import com.edburguer.exception.BadRequestException;
import com.edburguer.repository.AddressRepository;
import com.edburguer.service.AddressService;
import com.edburguer.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address create(AddressDto dto) {
        if(Objects.nonNull(dto.getId())) throw new BadRequestException("id deve ser nulo");



        return null;
    }
}
