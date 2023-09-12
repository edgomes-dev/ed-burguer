package com.edburguer.service;

import com.edburguer.dto.AddressDto;
import com.edburguer.entity.Address;
import com.edburguer.entity.District;
import com.edburguer.entity.Role;
import com.edburguer.entity.User;
import com.edburguer.exception.NotFoundException;
import com.edburguer.mapper.AddressMapper;
import com.edburguer.repository.AddressRepository;
import com.edburguer.repository.DistrictRepository;
import com.edburguer.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
public class AddressServiceTest {
    @Autowired
    AddressService addressService;

    @MockBean
    AddressRepository addressRepository;

    @MockBean
    DistrictRepository districtRepository;

    @MockBean
    UserRepository userRepository;

    @Test
    @DisplayName("Create Address")
    public void should_createAddressSucess() {
        // arrange
        AddressDto addressDto = new AddressDto(null, "Trabalho", "Rua da Moeda", "18A", "Perto do posto de combustivel", 1L);
        District district = new District(1L, "Boa Viagem", 10.00);
        Address address = new Address(1L, "Trabalho", "Rua da Moeda", "18A", "Perto do posto de combustivel", district);
        User user = new User(1L, "Ed Gomes", "ed@gmail.com", "81911112222", "senha123", Role.USER, Arrays.asList(address));

        Address entityExpected = new Address(1L, "Trabalho", "Rua da Moeda", "18A", "Perto do posto de combustivel", district);

        Mockito.doReturn(Optional.of(district)).when(districtRepository).findById(1L);
        Mockito.doReturn(address).when(addressRepository).save(any());
        Mockito.doReturn(Optional.of(user)).when(userRepository).findById(1L);

        // action
        Address entityReturn = addressService.create(addressDto);

        // assertions
        Assertions.assertNotNull(entityReturn);
        Assertions.assertEquals(entityReturn, entityExpected);
    }

    @Test
    @DisplayName("GET find all")
    public void should_findAllAddressSucess() {
        // arrange
        District district = new District(1L, "Pau Amarelo", 3.0);
        Address address = new Address(1L, "Casa", "Rua Paulo de Souza", "18A", "casa 10", district);
        Address address2 = new Address(2L, "Trabalho", "Rua Abigail Primeiro", "17", "", district);
        User user = new User(1L, "Ed", "ed@gmail.com", "81981112222","senha123", Role.USER, Arrays.asList(address, address2));
        Mockito.doReturn(Arrays.asList(address, address2)).when(addressRepository).findAll();

        //action
        List<Address> returnList = addressService.findAll();

        // assertions
        Assertions.assertEquals(2, returnList.size());
    }

    @Test
    @DisplayName("GET findById")
    public void should_findByIdAddressSucess_when_idExists() {
        // arrange
        District district = new District(1L, "Pau Amarelo", 3.0);

        Address entityExpected = new Address(1L, "Casa", "Rua Paulo de Souza", "18A", "casa 10", district);
        User user = new User(1L, "Ed", "ed@gmail.com", "81981112222", "senha123", Role.USER,Arrays.asList(entityExpected));
        Mockito.doReturn(Optional.of(entityExpected)).when(addressRepository).findById(1L);

        // action
        Address entityReturn = addressService.findById(1L);

        // assertions
        Assertions.assertEquals(entityExpected, entityReturn);
    }

    @Test
    @DisplayName("GET findById failure")
    public void should_findByIdAddressFailure_when_idNotExists() {
        // arrange
        Mockito.doThrow(NotFoundException.class).when(addressRepository).findById(1L);

        // action
        Executable executable = new Executable() {
            @Override
            public void execute() throws Throwable {
                Address address = addressService.findById(1L);
            }
        };

        // assertions
        Assertions.assertThrows(NotFoundException.class, executable);
    }

    @Test
    @DisplayName("Update Address")
    public void should_updateAddressSucess() {
        // arrange
        AddressDto addressDto = new AddressDto(1L, "Casa da namorada", "Rua da Moeda", "18B", "Perto do posto de combustivel", 1L);

        District districtExists = new District(1L, "Vasco da Gama", 3.0);
        Address addressExists = new Address(1L, "Casa", "Rua da Moeda", "18A", "casa 10", districtExists);
        User userExists = new User(1L, "Ed", "ed@gmail.com", "81981112222", "senha123", Role.USER,Arrays.asList(addressExists));

        District districtExpected = new District(2L, "Casa Amarela", 5.0);
        Address addressExpected = new Address(1L, "Casa da namorada", "Rua da Moeda", "18B", "Perto do posto de combustivel", districtExpected);

        Mockito.doReturn(Optional.of(addressExists)).when(addressRepository).findById(1L);
        Mockito.doReturn(Optional.of(districtExpected)).when(districtRepository).findById(2L);
        Mockito.doReturn(Optional.of(userExists)).when(userRepository).findById(1L);
        Mockito.doReturn(addressExpected).when(addressRepository).save(any());

        // action
        Address addressTest = addressService.update(addressDto);

        // assertions
        Assertions.assertNotNull(addressTest);
        Assertions.assertEquals(addressExpected, addressTest);
    }

    @Test
    @DisplayName("PUT Erro ao atualizar o address")
    public void should_updateAddressFailure_when_IdNotExists() {
        // arrange
        AddressDto addressDto = new AddressDto(1L, "Casa da namorada", "Rua da Moeda", "18B", "Perto do posto de combustivel", 1L);

        // action
        Executable executable = new Executable() {
            @Override
            public void execute() throws Throwable {
                Address returnAddres = addressService.update(addressDto);
            }
        };

        // assertions
        Assertions.assertThrows(NotFoundException.class, executable);
    }
}
