package com.edburguer.resource;

import com.edburguer.dto.IngredientDto;
import com.edburguer.dto.ProductCategoryDto;
import com.edburguer.entity.Ingredient;
import com.edburguer.entity.ProductCategory;
import com.edburguer.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingredient")
public class IngredientResource {
    @Autowired
    IngredientService ingredientService;
    @PostMapping
    public ResponseEntity<Ingredient> create(@RequestBody IngredientDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ingredientService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<Ingredient>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(ingredientService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ingredient> findById(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(ingredientService.findById(id));
    }

    @PutMapping
    public ResponseEntity<Ingredient> update(@RequestBody IngredientDto dto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ingredientService.update(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        ingredientService.delete(id);

        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
