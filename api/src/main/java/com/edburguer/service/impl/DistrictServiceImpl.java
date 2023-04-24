package com.edburguer.service.impl;

import com.edburguer.dto.DistrictDto;
import com.edburguer.entity.District;
import com.edburguer.exception.BadRequestException;
import com.edburguer.exception.NotFoundException;
import com.edburguer.mapper.DistrictMapper;
import com.edburguer.repository.DistrictRepository;
import com.edburguer.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DistrictServiceImpl implements DistrictService {
    @Autowired
    private DistrictRepository districtRepository;

    @Override
    public DistrictDto create(DistrictDto dto) {
        if(Objects.nonNull(dto.getId())) throw  new BadRequestException("id deve ser nulo");

        District district = districtRepository.save(DistrictMapper.fromDtoToEntity(dto));

        return DistrictMapper.fromEntityToDto(district);
    }

    @Override
    public List<DistrictDto> findAll() {
        List<DistrictDto> response = districtRepository.findAll().stream().map(district -> DistrictMapper.fromEntityToDto(district)).toList();

        return  response;
    }

    @Override
    public DistrictDto findById(Long id) {
        Optional<District> district = districtRepository.findById(id);

        if(district.isEmpty()) throw new NotFoundException("esse ID é inválido");

        DistrictDto districtDto = DistrictMapper.fromEntityToDto(district.get());
        return districtDto;
    }

    @Override
    public DistrictDto update(DistrictDto dto) {
        DistrictDto districtDto = this.findById(dto.getId());

        districtDto.setName(dto.getName());
        districtDto.setDeliveryPrice(dto.getDeliveryPrice());

        return DistrictMapper.fromEntityToDto(districtRepository.save(DistrictMapper.fromDtoToEntity(districtDto)));
    }
}

