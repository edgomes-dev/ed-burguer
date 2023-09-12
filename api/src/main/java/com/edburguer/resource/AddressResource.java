package com.edburguer.resource;

import com.edburguer.dto.AddressDto;
import com.edburguer.entity.Address;
import com.edburguer.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressResource {
    @Autowired
    private AddressService addressService;

    @PostMapping
    public ResponseEntity<Address> create(@RequestBody AddressDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(addressService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<Address>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(addressService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> findById(@PathVariable("id") Long id) {
        return  ResponseEntity.status(HttpStatus.OK).body(addressService.findById(id));
    }

    @PutMapping
    public ResponseEntity<Address> update(@RequestBody AddressDto addressDto) {
        return ResponseEntity.status(HttpStatus.OK).body(addressService.update(addressDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
