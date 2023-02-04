package com.edburguer.mapper;

import com.edburguer.dto.DistrictDto;
import com.edburguer.entity.District;

public class DistrictMapper {
    public  static District fromDtoToEntity(DistrictDto dto) {
        return District.builder()
                .id(dto.getId())
                .name(dto.getName())
                .deliveryPrice(dto.getDeliveryPrice())
                .build();
    }
}
