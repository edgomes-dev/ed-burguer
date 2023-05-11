package com.edburguer.resource;

import com.edburguer.dto.AddressDtoRequest;
import com.edburguer.dto.AddressDtoResponse;
import com.edburguer.entity.Address;
import com.edburguer.entity.District;
import com.edburguer.entity.User;
import com.edburguer.service.AddressService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Optional;

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

    static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
