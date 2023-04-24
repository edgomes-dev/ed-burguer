package com.edburguer.service;

import com.edburguer.dto.DistrictDto;
import com.edburguer.entity.District;

import java.util.List;

public interface DistrictService {
    DistrictDto create(DistrictDto dto);

    List<DistrictDto> findAll();

    DistrictDto findById(Long id);

    DistrictDto update(DistrictDto dto);
}
