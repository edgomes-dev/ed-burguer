package com.edburguer.service.impl;

import com.edburguer.dto.DistrictDto;
import com.edburguer.entity.District;
import com.edburguer.exception.BadRequestException;
import com.edburguer.mapper.DistrictMapper;
import com.edburguer.repository.DistrictRepository;
import com.edburguer.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class DistrictServiceImpl implements DistrictService {
    @Autowired
    private DistrictRepository districtRepository;

    @Override
    public District create(DistrictDto dto) {
        if(Objects.nonNull(dto.getId())) throw  new BadRequestException("id deve ser nulo");

        District district = DistrictMapper.fromDtoToEntity(dto);

        return districtRepository.save(district);
    }
}
