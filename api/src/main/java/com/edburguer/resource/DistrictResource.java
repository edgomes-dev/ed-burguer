package com.edburguer.resource;

import com.edburguer.dto.DistrictDto;
import com.edburguer.entity.District;
import com.edburguer.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/district")
public class DistrictResource {
    @Autowired
    private DistrictService districtService;

    @PostMapping
    public ResponseEntity<DistrictDto> create(@RequestBody DistrictDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(districtService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<DistrictDto>> findAll() {
        return  ResponseEntity.status(HttpStatus.OK).body(districtService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DistrictDto> findById(@PathVariable("id") Long id) {
        DistrictDto response = districtService.findById(id);

        if(Objects.isNull(response)) ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return  ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping
    public ResponseEntity<DistrictDto> update(@Valid @RequestBody DistrictDto dto) {
        return  ResponseEntity.status(HttpStatus.OK).body(districtService.update(dto));
    }
}