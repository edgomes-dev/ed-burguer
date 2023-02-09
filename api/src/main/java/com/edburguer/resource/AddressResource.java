package com.edburguer.resource;

import com.edburguer.dto.AddressDto;
import com.edburguer.entity.Address;
import com.edburguer.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
public class AddressResource {
    @Autowired
    private AddressService addressService;

    @PostMapping
    public ResponseEntity<Address> create(@RequestBody AddressDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(addressService.create(dto));
    }
}
