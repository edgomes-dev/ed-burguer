package com.edburguer.service;

import com.edburguer.dto.AddressDtoRequest;
import com.edburguer.dto.AddressDtoResponse;
import com.edburguer.entity.Address;
import com.edburguer.entity.District;
import com.edburguer.entity.User;
import com.edburguer.repository.AddressRepository;
import com.edburguer.repository.DistrictRepository;
import com.edburguer.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

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
        AddressDtoRequest addressRequest = new AddressDtoRequest(null, "Casa", "Rua Paulo de Souza", "18A", "casa 10", 1L, 1L);
        District district = new District(1L, "Pau Amarelo", 3.0);
        User user = new User(1L, "Ed", "ed@gmail.com", "senha123", true);
        AddressDtoResponse addressResponse = new AddressDtoResponse(4L, "Casa", "Rua Paulo de Souza", "18A", "casa 10", district, user);

        doReturn(Optional.of(district)).when(districtRepository).findById(any());
        doReturn(Optional.of(user)).when(userRepository).findById(any());
        doReturn(addressResponse).when(addressRepository).save(any());

        // action
        AddressDtoResponse response = addressService.create(addressRequest);

        // assertions
        //Assertions.assertNotNull(response, "Address não pode ser nulo");
        Assertions.assertEquals(addressResponse, response);
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
        AddressDtoResponse address = new AddressDtoResponse(1L, "Casa", "Rua Paulo de Souza", "18A", "casa 10", district, user);
        Mockito.doReturn(Optional.of(address)).when(addressRepository).findById(1L);

        // action
        Optional<AddressDtoResponse> addressRequest = Optional.ofNullable(addressService.findById(1L));

        // assertions
        Assertions.assertEquals(addressRequest.get(), address);
    }

}
