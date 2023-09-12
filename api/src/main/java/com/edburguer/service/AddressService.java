package com.edburguer.service;

import com.edburguer.dto.AddressDto;
import com.edburguer.entity.Address;

import java.util.List;

public interface AddressService {
    Address create(AddressDto dto);

    List<Address> findAll();

    Address findById(Long id);

    Address update(AddressDto dto);

    void delete(Long id);
}
