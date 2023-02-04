package com.edburguer.service;

import com.edburguer.dto.AddressDto;
import com.edburguer.entity.Address;

public interface AddressService {
    Address create(AddressDto dto);
}
