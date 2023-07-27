package com.edburguer.service.impl;

import com.edburguer.dto.ProductDto;
import com.edburguer.entity.Ingredient;
import com.edburguer.entity.Product;
import com.edburguer.entity.ProductCategory;
import com.edburguer.exception.NotFoundException;
import com.edburguer.mapper.ProductMapper;
import com.edburguer.repository.ProductCategoryRepository;
import com.edburguer.repository.ProductRepository;
import com.edburguer.service.FirebaseService;
import com.edburguer.service.IngredientService;
import com.edburguer.service.ProductCategoryService;
import com.edburguer.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductCategoryRepository productCategoryRepository;

    @Override
    @Transactional
    public Product create(ProductDto dto) {
        Optional<ProductCategory> productCategory = productCategoryRepository.findById(dto.getProductCategoryId());
        if(productCategory.isEmpty()) throw new NotFoundException("Categoria de produtos não encontrado");

        Product entity = ProductMapper.fromDtoToEntity(dto, productCategory.get());

        return productRepository.save(entity);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isEmpty()) throw new NotFoundException("ID inválido");

        return optionalProduct.get();
    }

    @Override
    @Transactional
    public Product update(ProductDto dto) {
        Product entity = this.findById(dto.getId());

        entity.setName(dto.getName());
        entity.setPrice(dto.getPrice());

        return productRepository.save(entity);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Product entity = this.findById(id);

        productRepository.delete(entity);
    }
}
