package com.edburguer.service;

import com.edburguer.dto.DistrictDto;
import com.edburguer.entity.District;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DistrictService {
    District create(DistrictDto dto);

    List<District> findAll();

    District findById(Long id);

    District update(DistrictDto dto);

    void delete(Long id);
}
