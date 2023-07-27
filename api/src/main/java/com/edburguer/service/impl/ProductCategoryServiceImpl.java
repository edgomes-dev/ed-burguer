package com.edburguer.service.impl;

import com.edburguer.dto.ProductCategoryDto;
import com.edburguer.entity.ProductCategory;
import com.edburguer.exception.BadRequestException;
import com.edburguer.exception.NotFoundException;
import com.edburguer.mapper.ProductCategoryMapper;
import com.edburguer.repository.ProductCategoryRepository;
import com.edburguer.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Autowired
    ProductCategoryRepository productCategoryRepository;

    @Override
    @Transactional
    public ProductCategory create(ProductCategoryDto productCategoryDto) {
        if(Objects.nonNull(productCategoryDto.getId())) throw new BadRequestException("ID precisa ser nulo");
        ProductCategory productCategory = ProductCategoryMapper.fromDtoToEntity(productCategoryDto);

        return productCategoryRepository.save(productCategory);
    }

    @Override
    public List<ProductCategory> findAll() {
        return productCategoryRepository.findAll();
    }

    @Override
    public ProductCategory findById(Long id) {
        Optional<ProductCategory> optional = productCategoryRepository.findById(id);

        if(optional.isEmpty()) throw new NotFoundException("ID inválido");

        return  optional.get();
    }

    @Override
    @Transactional
    public ProductCategory update(ProductCategoryDto productCategoryDto) {
        Optional<ProductCategory> entity = productCategoryRepository.findById(productCategoryDto.getId());
        if(entity.isEmpty()) throw new NotFoundException("ID não encontrado");

        entity.get().setName(productCategoryDto.getName());

        return productCategoryRepository.save(entity.get());
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if(Objects.isNull(id)) throw new NotFoundException("ID inválido");

        productCategoryRepository.deleteById(id);
    }
}
