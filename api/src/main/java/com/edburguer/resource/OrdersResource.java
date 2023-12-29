package com.edburguer.resource;

import com.edburguer.dto.OrdersDto;
import com.edburguer.entity.Orders;
import com.edburguer.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersResource {
    @Autowired
    private OrdersService service;

    @PostMapping
    public ResponseEntity<Orders> create(@RequestBody OrdersDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<Orders>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }
}
