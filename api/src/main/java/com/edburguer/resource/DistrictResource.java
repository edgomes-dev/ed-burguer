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

@RestController
@RequestMapping("/district")
public class DistrictResource {
    @Autowired
    private DistrictService districtService;

    @PostMapping
    public ResponseEntity<District> create(@Valid @RequestBody DistrictDto dto) {
        return  ResponseEntity.status(HttpStatus.CREATED).body(districtService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<District>> findAll() {
        return  ResponseEntity.status(HttpStatus.OK).body(districtService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<District> findById(@PathVariable("id") Long id) {
        return  ResponseEntity.status(HttpStatus.OK).body(districtService.findById(id));
    }

    @PutMapping
    public ResponseEntity<District> update(@Valid @RequestBody DistrictDto dto) {
        return  ResponseEntity.status(HttpStatus.OK).body(districtService.update(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        districtService.delete(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}