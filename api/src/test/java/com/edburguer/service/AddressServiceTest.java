package com.edburguer.service;

import com.edburguer.dto.AddressDtoRequest;
import com.edburguer.dto.AddressDtoResponse;
import com.edburguer.entity.Address;
import com.edburguer.entity.District;
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
        AddressDtoRequest addressDtoRequest = new AddressDtoRequest(null, "Trabalho", "Rua da Moeda", "18A", "Perto do posto de combustivel", 1L, 1L);
        District district = new District(1L, "Boa Viagem", 10.00);
        User user = new User(1L, "Ed Gomes", "ed@gmail.com", "senha123", false);
        Address address = new Address(1L, "Trabalho", "Rua da Moeda", "18A", "Perto do posto de combustivel", district, user);
        AddressDtoResponse addressDtoResponseExpected = new AddressDtoResponse(1L, "Trabalho", "Rua da Moeda", "18A", "Perto do posto de combustivel", district, user);

        Mockito.doReturn(Optional.of(district)).when(districtRepository).findById(1L);
        Mockito.doReturn(Optional.of(user)).when(userRepository).findById(1L);
        Mockito.doReturn(address).when(addressRepository).save(any());

        // action
        AddressDtoResponse addressDtoResponseReturn = addressService.create(addressDtoRequest);

        // assertions
        Assertions.assertNotNull(addressDtoResponseReturn);
        Assertions.assertEquals(addressDtoResponseReturn, addressDtoResponseExpected);
    }

    @Test
    @DisplayName("GET find all")
    public void should_findAllAddressSucess() {
        // arrange
        District district = new District(1L, "Pau Amarelo", 3.0);
        User user = new User(1L, "Ed", "ed@gmail.com", "senha123", true);
        Address address = new Address(1L, "Casa", "Rua Paulo de Souza", "18A", "casa 10", district, user);
        Address address2 = new Address(2L, "Trabalho", "Rua Abigail Primeiro", "17", "", district, user);
        Mockito.doReturn(Arrays.asList(address, address2)).when(addressRepository).findAll();

        //action
        List<AddressDtoResponse> returnList = addressService.findAll();

        // assertions
        Assertions.assertEquals(2, returnList.size());
    }

    @Test
    @DisplayName("GET findById")
    public void should_findByIdAddressSucess_when_idExists() {
        // arrange
        District district = new District(1L, "Pau Amarelo", 3.0);
        User user = new User(1L, "Ed", "ed@gmail.com", "senha123", true);
        Address address = new Address(1L, "Casa", "Rua Paulo de Souza", "18A", "casa 10", district, user);
        Mockito.doReturn(Optional.of(address)).when(addressRepository).findById(1L);

        // action
        AddressDtoResponse addressDtoResponseReturn = addressService.findById(1L);

        // assertions
        Assertions.assertEquals(AddressMapper.fromEntityToDtoResponse(address), addressDtoResponseReturn);
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
                AddressDtoResponse address = addressService.findById(1L);
            }
        };

        // assertions
        Assertions.assertThrows(NotFoundException.class, executable);
    }

    @Test
    @DisplayName("Update Address")
    public void should_updateAddressSucess() {
        // arrange
        AddressDtoRequest addressDtoRequest = new AddressDtoRequest(1L, "Casa da namorada", "Rua da Moeda", "18B", "Perto do posto de combustivel", 2L, 1L);

        District districtExists = new District(1L, "Vasco da Gama", 3.0);
        User userExists = new User(1L, "Ed", "ed@gmail.com", "senha123", false);
        Address addressExists = new Address(1L, "Casa", "Rua da Moeda", "18A", "casa 10", districtExists, userExists);
        AddressDtoResponse addressDtoResponseExists = new AddressDtoResponse(1L, "Casa da namorada", "Rua da Moeda", "18B", "Perto do posto de combustivel", districtExists, userExists);

        District districtExpected = new District(2L, "Casa Amarela", 5.0);
        Address addressExpected = new Address(1L, "Casa da namorada", "Rua da Moeda", "18B", "Perto do posto de combustivel", districtExpected, userExists);
        AddressDtoResponse addressDtoResponseExpected = new AddressDtoResponse(1L, "Casa da namorada", "Rua da Moeda", "18B", "Perto do posto de combustivel", districtExpected, userExists);

        Mockito.doReturn(Optional.of(addressExists)).when(addressRepository).findById(1L);
        Mockito.doReturn(Optional.of(districtExpected)).when(districtRepository).findById(2L);
        Mockito.doReturn(Optional.of(userExists)).when(userRepository).findById(1L);
        Mockito.doReturn(addressExpected).when(addressRepository).save(any());

        // action
        AddressDtoResponse addressTest = addressService.update(addressDtoRequest);

        // assertions
        Assertions.assertNotNull(addressTest);
        Assertions.assertEquals(addressDtoResponseExpected, addressTest);
    }

    @Test
    @DisplayName("PUT Erro ao atualizar o address")
    public void should_updateAddressFailure_when_IdNotExists() {
        // arrange
        AddressDtoRequest addressDtoRequest = new AddressDtoRequest(1L, "Casa da namorada", "Rua da Moeda", "18B", "Perto do posto de combustivel", 2L, 1L);

        // action
        Executable executable = new Executable() {
            @Override
            public void execute() throws Throwable {
                AddressDtoResponse returnAddres = addressService.update(addressDtoRequest);
            }
        };

        // assertions
        Assertions.assertThrows(NotFoundException.class, executable);
    }
}
