package com.edburguer.service.impl;

import com.edburguer.dto.ProductDto;
import com.edburguer.entity.Ingredient;
import com.edburguer.entity.Product;
import com.edburguer.entity.ProductCategory;
import com.edburguer.exception.NotFoundException;
import com.edburguer.mapper.ProductMapper;
import com.edburguer.repository.ProductRepository;
import com.edburguer.service.IngredientService;
import com.edburguer.service.ProductCategoryService;
import com.edburguer.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    IngredientService ingredientService;

    @Autowired
    ProductCategoryService productCategoryService;
    @Override
    public Product create(ProductDto productDto) {
        ProductCategory productCategory = productCategoryService.findById(productDto.getProductCategoryId());

        List<Ingredient> ingredients = new ArrayList<>();
        for(Long ingredientId: productDto.getIngredientsId()) {
            Ingredient ingredient = ingredientService.findById(ingredientId);
            ingredients.add(ingredient);
        }

        System.out.println(ingredients);

        return productRepository
                .save(ProductMapper.fromDtoToEntity(productDto,ingredients ,productCategory));
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Product update(ProductDto productDto) {
        Optional<Product> entity = productRepository.findById(productDto.getId());
        if(entity.isEmpty()) throw new NotFoundException("ID não encontrado");

        return productRepository.save(entity.get());
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
