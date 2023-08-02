package com.edburguer.resource;

import com.edburguer.dto.ProductCategoryDto;
import com.edburguer.entity.ProductCategory;
import com.edburguer.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/product-category")
public class ProductCategoryResource {
    @Autowired
    ProductCategoryService productCategoryService;
    @PostMapping
    public ResponseEntity<ProductCategory> create(@ModelAttribute ProductCategoryDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productCategoryService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<ProductCategory>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(productCategoryService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductCategory> findById(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(productCategoryService.findById(id));
    }

    @PutMapping
    public ResponseEntity<ProductCategory> update(@RequestBody ProductCategoryDto dto) {
        return  ResponseEntity.status(HttpStatus.OK).body(productCategoryService.update(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        productCategoryService.delete(id);

        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
