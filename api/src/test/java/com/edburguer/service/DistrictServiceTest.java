package com.edburguer.service;

import com.edburguer.dto.DistrictDto;
import com.edburguer.entity.District;
import com.edburguer.exception.BadRequestException;
import com.edburguer.exception.NotFoundException;
import com.edburguer.mapper.DistrictMapper;
import com.edburguer.repository.DistrictRepository;
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
import java.util.Objects;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
public class DistrictServiceTest {
    @Autowired
    private DistrictService service;

    @MockBean
    private DistrictRepository repository;

    @Test
    @DisplayName("Deve salvar o distrito com sucesso")
    public void should_createDistrictSucess() {
        // arrange
        DistrictDto districtDto = new DistrictDto();
        districtDto.setName("Test One");
        districtDto.setDeliveryPrice(3.0);

        District district = DistrictMapper.fromDtoToEntity(districtDto);

        Mockito.doReturn(district).when(repository).save(any());

        // action
        DistrictDto returnDistrict = service.create(districtDto);

        // assertions
        Assertions.assertNotNull(returnDistrict, "The saved district should not be null");
        Assertions.assertEquals("Test One", returnDistrict.getName(), "The name is correct");
    }

    @Test
    @DisplayName("Deve retornar todos os distritos com sucesso")
    public void should_findAllDistrictSucess() {
        // arrange
        District district = new District();
        district.setId(1L);
        district.setName("Test One");
        district.setDeliveryPrice(3.0);

        District district2 = new District();
        district.setId(2L);
        district.setName("Test Two");
        district.setDeliveryPrice(5.0);
        Mockito.doReturn(Arrays.asList(district, district2)).when(repository).findAll();

        // action
        List<DistrictDto> returnDistrict = service.findAll();

        // assertions
        Assertions.assertEquals(2, returnDistrict.size(), "findAll should return 2 widgets");
    }

    @Test
    @DisplayName("Deve retornar um distrito quando o ID for válido")
    public void should_findByIdDistrictSucess_when_IdExists() {
        // arrange
        Long idExists = 1L;
        District district = new District();
        district.setId(1L);
        district.setName("Teste");
        district.setDeliveryPrice(3.0);

        DistrictDto districtDto = DistrictMapper.fromEntityToDto(district);

        Mockito.doReturn(Optional.of(district)).when(repository).findById(idExists);

        // action
        Optional<DistrictDto> returnDistrict = Optional.ofNullable(service.findById(idExists));

        // assertions
        Assertions.assertTrue(returnDistrict.isPresent(), "District was not found");
        Assertions.assertEquals(returnDistrict.get(), districtDto, "The district returned was not the same as the mock");
    }

    @Test
    @DisplayName("Deve retornar um erro se o ID for inválido")
    public void should_findByIdDistrictError_when_IdFalseOrNull() {
        // arrange
        Long idInvalid = 100L;
        Mockito.doReturn(Optional.empty()).when(repository).findById(idInvalid);

        // action
        Executable executable = new Executable() {
            @Override
            public void execute() throws Throwable {
                DistrictDto returnDistrict = service.findById(idInvalid);
            }
        };

        // assertions
        Assertions.assertThrows(NotFoundException.class, executable);
    }

    @Test
    @DisplayName("Deve atualizar com sucesso quando o ID for válido")
    public void should_updateDistrictSucess_when_IdExists() {
        // arrange
        DistrictDto districtDto = new DistrictDto();
        districtDto.setId(1L);
        districtDto.setName("Test");
        districtDto.setDeliveryPrice(3.0);

        District district = DistrictMapper.fromDtoToEntity(districtDto);

        Mockito.doReturn(district).when(repository).save(any());
        Mockito.doReturn(Optional.of(district)).when(repository).findById(districtDto.getId());

        // action
        DistrictDto returnDistrict = service.update(districtDto);

        // assertions
        Assertions.assertEquals(returnDistrict, districtDto);
    }

    @Test
    @DisplayName("Deve retronar um BadRequest quando o ID for inválido")
    public void should_updateDistrictFaill_when_IdNotExists() {
        // arrange
        DistrictDto districtDto = new DistrictDto();
        districtDto.setId(1L);
        districtDto.setName("Test");
        districtDto.setDeliveryPrice(3.0);

        // action
        Executable executable = new Executable() {
            @Override
            public void execute() throws Throwable {
                DistrictDto returnDistrict = service.update(districtDto);
            }
        };

        // assertions
        Assertions.assertThrows(NotFoundException.class, executable);
    }
}
