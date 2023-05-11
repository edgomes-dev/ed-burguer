package com.edburguer.resource;

import com.edburguer.dto.DistrictDto;
import com.edburguer.entity.District;
import com.edburguer.exception.NotFoundException;
import com.edburguer.service.DistrictService;
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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class DistrictResourceTest {
    @MockBean
    private DistrictService service;


    @Autowired
    private  MockMvc mockMvc;

    @Test
    @DisplayName("Criar com sucesso um district")
    void testPostCreateDistrict() throws Exception {
        DistrictDto districtToPost = new DistrictDto(null, "Test", 3.0);
        DistrictDto districtToReturn = new DistrictDto(1L, "Test", 3.0);
        Mockito.doReturn(districtToReturn).when(service).create(any());

        mockMvc.perform(MockMvcRequestBuilders.post("/district")
                .content(asJsonString(districtToPost))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", Is.is(1)));
    }

    @Test
    @DisplayName("Retornar os districts com sucesso")
    void testGetAllDistricts() throws Exception {
        List<District> list = new ArrayList<>();

        District district = new District();
        district.setId(1L);
        district.setName("Test");
        district.setDeliveryPrice(3.0);

        District district1 = new District();
        district1.setId(2L);
        district1.setName("Test One");
        district1.setDeliveryPrice(4.0);

        list.add(district);
        list.add(district1);

        Mockito.doReturn(list).when(service).findAll();

        mockMvc.perform(MockMvcRequestBuilders.get("/district"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", Is.is(1)))
                .andExpect(jsonPath("$[0].name", Is.is("Test")))
                .andExpect(jsonPath("$[0].deliveryPrice", Is.is(3.0)))
                .andExpect(jsonPath("$[1].id", Is.is(2)))
                .andExpect(jsonPath("$[1].name", Is.is("Test One")))
                .andExpect(jsonPath("$[1].deliveryPrice", Is.is(4.0)));
    }

    @Test
    @DisplayName("Retornar um district com sucesso quando o ID for válido")
    void testGetDistrictById() throws Exception {
        DistrictDto districtDto = new DistrictDto();
        districtDto.setId(1L);
        districtDto.setName("Test");
        districtDto.setDeliveryPrice(3.0);

        Mockito.doReturn(districtDto).when(service).findById(1L);

        mockMvc.perform(MockMvcRequestBuilders.get("/district/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", Is.is(1)))
                .andExpect(jsonPath("$.name", Is.is("Test")))
                .andExpect(jsonPath("$.deliveryPrice", Is.is(3.0)));
    }

    @Test
    @DisplayName("Retornar um NotFound quando o ID for inválido")
    void testGetDistrictByIdFail() throws Exception {
        Mockito.doThrow(NotFoundException.class).when(service).findById(1L);

        mockMvc.perform(MockMvcRequestBuilders.get("/district/{id}", 1L))
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
