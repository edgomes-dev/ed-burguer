package com.edburguer.resource;

import com.edburguer.dto.AddressDtoRequest;
import com.edburguer.dto.AddressDtoResponse;
import com.edburguer.entity.Address;
import com.edburguer.entity.District;
import com.edburguer.entity.User;
import com.edburguer.exception.NotFoundException;
import com.edburguer.service.AddressService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class AddressResourceTest {
    @MockBean
    private AddressService addressService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Criar com sucesso um Address")
    public void testPostCreateAddress() throws Exception {
        AddressDtoRequest addressDtoRequest = new AddressDtoRequest(null, "Trabalho", "Rua da Moeda", "18A", "Perto do posto de combustivel", 1L, 1L);
        District district = new District(1L, "Boa Viagem", 10.00);
        User user = new User(1L, "Ed Gomes", "ed@gmail.com", "senha123", false);
        AddressDtoResponse addressExpected = new AddressDtoResponse(1L, "Trabalho", "Rua da Moeda", "18A", "Perto do posto de combustivel", district, user);
        Mockito.doReturn(addressExpected).when(addressService).create(addressDtoRequest);

        mockMvc.perform(MockMvcRequestBuilders.post("/address")
                .content(asJsonString(addressDtoRequest))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", Is.is(1)))
                .andExpect(jsonPath("$.name", Is.is("Trabalho")));
    }

    @Test
    @DisplayName("Retornar todos os Address com sucesso")
    public void testGetFindAllSucess() throws Exception {
        District district = new District(1L, "Pau Amarelo", 3.0);
        User user = new User(1L, "Ed", "ed@gmail.com", "senha123", true);
        Address address = new Address(1L, "Casa", "Rua Paulo de Souza", "18A", "casa 10", district, user);
        Address address2 = new Address(2L, "Trabalho", "Rua Abigail Primeiro", "17", "", district, user);
        Mockito.doReturn(Arrays.asList(address, address2)).when(addressService).findAll();

        mockMvc.perform(MockMvcRequestBuilders.get("/address"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", Is.is(1)))
                .andExpect(jsonPath("$[0].name", Is.is("Casa")))
                .andExpect(jsonPath("$[1].id", Is.is(2)))
                .andExpect(jsonPath("$[1].name", Is.is("Trabalho")));
    }

    @Test
    @DisplayName("Retornar um address com sucesso quando o ID for correto")
    public void testGetFindByIdSucess() throws Exception {
        District district = new District(1L, "Pau Amarelo", 3.0);
        User user = new User(1L, "Ed", "ed@gmail.com", "senha123", true);
        AddressDtoResponse address = new AddressDtoResponse(1L, "Casa", "Rua Paulo de Souza", "18A", "casa 10", district, user);
        Mockito.doReturn(address).when(addressService).findById(1L);

        mockMvc.perform(MockMvcRequestBuilders.get("/address/1"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", Is.is(1)))
                .andExpect(jsonPath("$.name", Is.is("Casa")));
    }

    @Test
    @DisplayName("Retornar um NotFoundException quando o ID for correto")
    public void testGetFindByIdFailure_when_IdNotExists() throws Exception {
        Mockito.doThrow(NotFoundException.class).when(addressService).findById(1L);

        mockMvc.perform(MockMvcRequestBuilders.get("/address/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("Atualizar com sucesso um address")
    public void testPutAddress() throws Exception {
        AddressDtoRequest addressDtoRequest = new AddressDtoRequest(1L, "Casa da namorada", "Rua da Moeda", "18B", "Perto do posto de combustivel", 2L, 1L);

        District districtExists = new District(1L, "Vasco da Gama", 3.0);
        User userExists = new User(1L, "Ed", "ed@gmail.com", "senha123", false);
        Address addressExists = new Address(1L, "Casa", "Rua da Moeda", "18A", "casa 10", districtExists, userExists);
        AddressDtoResponse addressDtoResponseExists = new AddressDtoResponse(1L, "Casa da namorada", "Rua da Moeda", "18B", "Perto do posto de combustivel", districtExists, userExists);

        District districtExpected = new District(2L, "Casa Amarela", 5.0);
        Address addressExpected = new Address(1L, "Casa da namorada", "Rua da Moeda", "18B", "Perto do posto de combustivel", districtExpected, userExists);
        AddressDtoResponse addressDtoResponseExpected = new AddressDtoResponse(1L, "Casa da namorada", "Rua da Moeda", "18B", "Perto do posto de combustivel", districtExpected, userExists);

        Mockito.doReturn(addressDtoResponseExists).when(addressService).findById(1L);
        Mockito.doReturn(addressDtoResponseExpected).when(addressService).update(addressDtoRequest);

        mockMvc.perform(MockMvcRequestBuilders.put("/address")
                .content(asJsonString(addressDtoRequest))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", Is.is(1)))
                .andExpect(jsonPath("$.name", Is.is("Casa da namorada")));
    }

    @Test
    @DisplayName("NotFoundExeception ao tentar atualizar com id inválido")
    public void testPutAddressFailure_when_idNotExists() throws Exception {
        AddressDtoRequest addressDtoRequest = new AddressDtoRequest(1L, "Casa da namorada", "Rua da Moeda", "18B", "Perto do posto de combustivel", 2L, 1L);

        Mockito.doThrow(NotFoundException.class).when(addressService).update(addressDtoRequest);

        mockMvc.perform(MockMvcRequestBuilders.put("/address")
                        .content(asJsonString(addressDtoRequest))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
