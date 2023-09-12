package com.edburguer.resource;

import com.edburguer.dto.OptionDto;
import com.edburguer.entity.Option;
import com.edburguer.service.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/option")
public class OptionResource {
    @Autowired
    private OptionService service;

    @PostMapping
    public ResponseEntity<Option> create(@RequestBody OptionDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<Option>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Option> findById(@PathVariable("id") Long id) {
        return  ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }

    @PutMapping
    public ResponseEntity<Option> update(@RequestBody OptionDto dto) {
        return ResponseEntity.status(HttpStatus.OK).body(service.update(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        service.delete(id);

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
