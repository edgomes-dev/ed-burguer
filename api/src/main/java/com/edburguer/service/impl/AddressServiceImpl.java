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
    private DistrictRepository districtRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public Address create(AddressDto dto) {
        if(Objects.nonNull(dto.getId())) throw new BadRequestException("id deve ser nulo");

        var districtOpt = districtRepository.findById(dto.getDistrictId());

        if(districtOpt.isEmpty()) throw  new NotFoundException("Distrito não encontrado");

        var userOpt = userRepository.findById(dto.getUserId());

        if(userOpt.isEmpty()) throw new NotFoundException("User não encontrado");

        District district = districtOpt.get();
        User user = userOpt.get();

        Address addressEntity = AddressMapper.fromDtoToEntity(dto, district, user);

        return addressRepository.save(addressEntity);
    }

    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address findById(Long id) {
        Optional<Address> address = addressRepository.findById(id);

        if(address.isEmpty()) throw  new BadRequestException("Endereço não encontrado");

        return address.get();
    }

    @Override
    public Address update(AddressDto dto) {
        return null;
    }

    @Override
    public void delete(Long id) {
        Optional<Address> address = addressRepository.findById(id);

        if(address.isEmpty()) throw new NotFoundException("address não encontrado");

        addressRepository.delete(address.get());
    }
}
