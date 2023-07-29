package com.edburguer.resource;

import com.edburguer.dto.ProductDto;
import com.edburguer.entity.Product;
import com.edburguer.exception.BadRequestException;
import com.edburguer.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductResource {
    @Autowired
    ProductService productService;
    @PostMapping
    public ResponseEntity<Product> create() {
        productService.create();

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(productService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.findById(id));
    }

    @PutMapping
    public ResponseEntity<Product> update(@RequestBody ProductDto dto) {
        return  ResponseEntity.status(HttpStatus.OK).body(productService.update(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        productService.delete(id);

        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
