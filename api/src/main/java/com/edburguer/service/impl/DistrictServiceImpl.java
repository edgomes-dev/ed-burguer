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
    public District create(DistrictDto dto) {
        if(Objects.nonNull(dto.getId())) throw  new BadRequestException("id deve ser nulo");

        District district = DistrictMapper.fromDtoToEntity(dto);

        return districtRepository.save(district);
    }

    @Override
    public List<District> findAll() {
        return districtRepository.findAll();
    }

    @Override
    public District findById(Long id) {
        Optional<District> district = districtRepository.findById(id);

        if(district.isEmpty()) throw new NotFoundException("esse ID é inválido");
        return district.get();
    }

    @Override
    public District update(DistrictDto dto) {
        Optional<District> district = districtRepository.findById(dto.getId());
        if(district.isEmpty()) throw new BadRequestException("esse id não é válido");

        district.get().setName(dto.getName());
        district.get().setDeliveryPrice(dto.getDeliveryPrice());

        return districtRepository.save(district.get());
    }

    @Override
    public void delete(Long id) {
        districtRepository.deleteById(id);
    }
}

