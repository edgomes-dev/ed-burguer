package com.edburguer.service.impl;

import com.edburguer.dto.AddressDtoRequest;
import com.edburguer.dto.AddressDtoResponse;
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
import org.modelmapper.ModelMapper;
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
    public AddressDtoResponse create(AddressDtoRequest dto) {
        if(Objects.nonNull(dto.getId())) throw new BadRequestException("id deve ser nulo");

        Optional<District> districtFindById = districtRepository.findById(dto.getDistrictId());

        if(districtFindById.isEmpty()) throw  new NotFoundException("Distrito não encontrado");

        Optional<User> userFindById = userRepository.findById(dto.getUserId());

        if(userFindById.isEmpty()) throw new NotFoundException("User não encontrado");

        Address addressResponse = addressRepository.save(AddressMapper.fromDtoRequestToEntity(dto, districtFindById.get(), userFindById.get()));

        return AddressMapper.fromEntityToDtoResponse(addressResponse);
    }

    @Override
    public List<AddressDtoResponse> findAll() {
        List<AddressDtoResponse> response = addressRepository.findAll().stream().map(address -> AddressMapper.fromEntityToDtoResponse(address)).toList();

        return response;
    }

    @Override
    public AddressDtoResponse findById(Long id) {
        Optional<Address> address = addressRepository.findById(id);

        if(address.isEmpty()) throw  new BadRequestException("Endereço não encontrado");

        return AddressMapper.fromEntityToDtoResponse(address.get());
    }

    @Override
    public AddressDtoResponse update(AddressDtoRequest dto) {
        Optional<Address> entity = addressRepository.findById(dto.getId());

        if(entity.isEmpty()) throw new NotFoundException("Endereço não encontrato");

        Optional<District> district = districtRepository.findById(dto.getDistrictId());
        if(district.isEmpty()) throw new NotFoundException("Distrito não encontrado");

        Optional<User> user = userRepository.findById(dto.getUserId());
        if(user.isEmpty()) throw new NotFoundException("User não encontrado");

        entity.get().setName(dto.getName());
        entity.get().setComplement(dto.getComplement());
        entity.get().setNumber(dto.getNumber());
        entity.get().setStreet(dto.getStreet());
        entity.get().setDistrict(district.get());

        return AddressMapper.fromEntityToDtoResponse(addressRepository.save(entity.get()));
    }

    @Override
    public void delete(Long id) {
        Optional<Address> address = addressRepository.findById(id);

        if(address.isEmpty()) throw new NotFoundException("address não encontrado");

        addressRepository.delete(address.get());
    }
}
