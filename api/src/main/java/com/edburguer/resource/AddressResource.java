package com.edburguer.resource;

import com.edburguer.dto.AddressDtoRequest;
import com.edburguer.dto.AddressDtoResponse;
import com.edburguer.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/address")
public class AddressResource {
    @Autowired
    private AddressService addressService;

    @PostMapping
    public ResponseEntity<AddressDtoResponse> create(@RequestBody AddressDtoRequest dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(addressService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<AddressDtoResponse>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(addressService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressDtoResponse> findById(@PathVariable("id") Long id) {
        AddressDtoResponse response = addressService.findById(id);

        return  ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping
    public ResponseEntity<AddressDtoResponse> update(@RequestBody AddressDtoRequest addressDto) {
        return ResponseEntity.status(HttpStatus.OK).body(addressService.update(addressDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
