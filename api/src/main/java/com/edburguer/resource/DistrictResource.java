package com.edburguer.resource;

import com.edburguer.dto.DistrictDto;
import com.edburguer.entity.District;
import com.edburguer.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/district")
public class DistrictResource {
    @Autowired
    private DistrictService districtService;

    @PostMapping
    public ResponseEntity<District> create(@Valid @RequestBody DistrictDto dto) {
        return  ResponseEntity.status(HttpStatus.CREATED).body(districtService.create(dto));
    }
}
