package com.edburguer.service;

import com.edburguer.dto.AddressDtoRequest;
import com.edburguer.dto.AddressDtoResponse;

import java.util.List;

public interface AddressService {
    AddressDtoResponse create(AddressDtoRequest dto);

    List<AddressDtoResponse> findAll();

    AddressDtoResponse findById(Long id);

    AddressDtoResponse update(AddressDtoRequest dto);

    void delete(Long id);
}
