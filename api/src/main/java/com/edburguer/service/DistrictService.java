package com.edburguer.service;

import com.edburguer.dto.DistrictDto;
import com.edburguer.entity.District;
public interface DistrictService {
    District create(DistrictDto dto);
}
