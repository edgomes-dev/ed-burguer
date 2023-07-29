package com.edburguer.service.impl;

import com.edburguer.dto.ProductDto;
import com.edburguer.entity.Product;
import com.edburguer.entity.ProductCategory;
import com.edburguer.exception.NotFoundException;
import com.edburguer.repository.ProductCategoryRepository;
import com.edburguer.repository.ProductRepository;
import com.edburguer.service.ProductCategoryService;
import com.edburguer.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductCategoryRepository productCategoryRepository;

    @Autowired
    ProductCategoryService productCategoryService;

    @Override
    @Transactional
    public void create() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setName("Teste");
        productCategory.setImageUrl("/imagem");

        Product product = new Product();
        product.setName("Test");
        product.setPrice(3.0);
        product.setImageUrl("/image");

        Product productTwo = new Product();
        productTwo.setName("New Test");
        productTwo.setPrice(5.0);
        productTwo.setImageUrl("/image/two");

        productCategory.addProduct(product);
        productCategory.addProduct(productTwo);

        productCategoryRepository.save(productCategory);
    }

    @Override
    @Transactional
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
