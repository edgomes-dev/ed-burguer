package com.edburguer.resource;

import com.edburguer.dto.DistrictDto;
import com.edburguer.entity.District;
import com.edburguer.mapper.DistrictMapper;
import com.edburguer.service.DistrictService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(DistrictResource.class)
public class DistrictResourceTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    DistrictService service;

    @Test
    @DisplayName("Criar com sucesso um distrito")
    public void shouldCreateDistrictSucess() throws Exception {
        // arrange
        DistrictDto districtDto = new DistrictDto();
        districtDto.setName("Test");
        districtDto.setDeliveryPrice(3.0);

        //Mockito.when(service.create(districtDto)).thenReturn(DistrictMapper.fromDtoToEntity(districtDto));

        // action
        mockMvc.perform(MockMvcRequestBuilders.post("/district")
                .content(asJsonString(districtDto)))
                .andExpect(status().isCreated())
                .andDo(print());

        // assertions
        //String resultDistrict = result.getResponse().getContentAsString();
        //Assertions.assertNotNull(resultDistrict);
        //Assertions.assertEquals(resultDistrict, resultDistrict);
    }

    @Test
    @DisplayName("Retornar com sucesso todos os distritos")
    public void shouldReturnAllDistrictsSucess() throws Exception {
        // arrange
        List<District> list = new ArrayList<>();
        District district1 = new District();
        district1.setId(1L);
        district1.setName("Test One");
        district1.setDeliveryPrice(3.0);

        District district2 = new District();
        district2.setId(2L);
        district2.setName("Test Two");
        district2.setDeliveryPrice(5.0);

        list.add(district1);
        list.add(district2);

        Mockito.when(service.findAll()).thenReturn(list);



        // action and assertions
        mockMvc.perform(MockMvcRequestBuilders.get("/district"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(2)))
                .andExpect(jsonPath("$[0].name", Matchers.is("Test One"))
                );

    }

    @Test
    @DisplayName("Retornar com sucesso um distrito por id")
    public void shouldReturnFindByIdSucess() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/district")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.district").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.district[*].id").isNotEmpty());
    }

    @Test
    @DisplayName("Atualizar com sucesso um distrito")
    public void shouldUpdateDistrictSucess() throws Exception {
        // arrange
        List<District> list = new ArrayList<>();
        District district1 = new District();
        district1.setId(1L);
        district1.setName("Test One");
        district1.setDeliveryPrice(3.0);

        District district2 = new District();
        district2.setId(2L);
        district2.setName("Test Two");
        district2.setDeliveryPrice(5.0);

        list.add(district1);
        list.add(district2);

        DistrictDto districtDto = new DistrictDto();
        districtDto.setId(1L);
        districtDto.setName("Test One New");
        districtDto.setDeliveryPrice(3.5);

        Mockito.when(service.update(districtDto)).thenReturn(DistrictMapper.fromDtoToEntity(districtDto));

        // action and assertions
        mockMvc.perform(MockMvcRequestBuilders.get("/district")
                        .accept(MediaType.APPLICATION_JSON)
                        .content(String.valueOf(districtDto))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Test One New"));
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw  new RuntimeException(e);
        }
    }
}

/*

// arrange
        List<District> list = new ArrayList<>();
        District district1 = new District();
        district1.setId(1L);
        district1.setName("Test One");
        district1.setDeliveryPrice(3.0);

        District district2 = new District();
        district2.setId(2L);
        district2.setName("Test Two");
        district2.setDeliveryPrice(5.0);

        list.add(district1);
        list.add(district2);

        Long id = 1L;

        Mockito.when(service.findById(id)).thenReturn(list.get(id.intValue() - 1));



        // action and assertions
        mockMvc.perform(MockMvcRequestBuilders.get("/district/{id}", 1)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1));

 */
