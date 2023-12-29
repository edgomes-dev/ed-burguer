package com.edburguer.service.impl;

import com.edburguer.dto.AddressDto;
import com.edburguer.entity.Address;
import com.edburguer.entity.District;
import com.edburguer.entity.User;
import com.edburguer.exception.BadRequestException;
import com.edburguer.exception.NotFoundException;
import com.edburguer.mapper.AddressMapper;
import com.edburguer.repository.AddressRepository;
import com.edburguer.repository.DistrictRepository;
import com.edburguer.repository.UserRepository;
import com.edburguer.service.AddressService;
import com.edburguer.service.DistrictService;
import com.edburguer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private DistrictService districtService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DistrictRepository districtRepository;

    @Transactional
    @Override
    public Address create(AddressDto dto) {
        if(Objects.nonNull(dto.getId())) throw new BadRequestException("id deve ser nulo");

        User user = userService.findById(dto.getUserId());

        Optional<District> district = districtRepository.findById(dto.getDistrictId());
        if(district.isEmpty()) throw  new NotFoundException("Distrito não encontrado");

        Address entity = addressRepository.save(AddressMapper.fromDtoToEntity(dto, district.get()));

        user.addAddress(entity);
        userRepository.save(user);

        return entity;
    }

    @Override
    public List<Address> findAll() {
        return  addressRepository.findAll();
    }

    @Override
    public Address findById(Long id) {
        Optional<Address> address = addressRepository.findById(id);

        if(address.isEmpty()) throw  new BadRequestException("Endereço não encontrado");

        return address.get();
    }

    @Override
    public Address update(AddressDto dto) {
        Optional<Address> entity = addressRepository.findById(dto.getId());

        if(entity.isEmpty()) throw new NotFoundException("Endereço não encontrato");

        Optional<District> district = districtRepository.findById(dto.getDistrictId());
        if(district.isEmpty()) throw new NotFoundException("Distrito não encontrado");

        entity.get().setName(dto.getName());
        entity.get().setComplement(dto.getComplement());
        entity.get().setNumber(dto.getNumber());
        entity.get().setStreet(dto.getStreet());
        entity.get().setDistrict(district.get());

        return addressRepository.save(entity.get());
    }

    @Override
    public void delete(Long id) {
        Optional<Address> address = addressRepository.findById(id);

        if(address.isEmpty()) throw new NotFoundException("address não encontrado");

        addressRepository.delete(address.get());
    }
}
