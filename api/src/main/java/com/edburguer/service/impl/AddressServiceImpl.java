package com.edburguer.service.impl;

import com.edburguer.dto.AddressDto;
import com.edburguer.entity.Address;
import com.edburguer.entity.District;
import com.edburguer.exception.BadRequestException;
import com.edburguer.mapper.AddressMapper;
import com.edburguer.repository.AddressRepository;
import com.edburguer.service.AddressService;
import com.edburguer.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private DistrictService districtService;

    @Override
    public Address create(AddressDto dto) {
        if(Objects.nonNull(dto.getId())) throw new BadRequestException("id deve ser nulo");

        if(Objects.nonNull(dto.getDistrictId())) throw new BadRequestException("Passe o id do district");
        District district = districtService.findById(dto.getDistrictId());

        Address addressEntity = AddressMapper.fromDtoToEntity(dto, district);

        return addressRepository.save(addressEntity);
    }
}
