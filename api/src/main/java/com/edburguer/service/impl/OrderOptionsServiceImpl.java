package com.edburguer.service.impl;

import com.edburguer.dto.OrderOptionsDto;
import com.edburguer.dto.initDb.OrderOptionsInitDbDto;
import com.edburguer.dto.initDb.ProductOrdersInitDbDto;
import com.edburguer.entity.*;
import com.edburguer.mapper.OrderOptionsMapper;
import com.edburguer.mapper.ProductOrdersMapper;
import com.edburguer.repository.OrderOptionsRepository;
import com.edburguer.repository.OrdersRepository;
import com.edburguer.repository.ProductOrdersRepository;
import com.edburguer.service.IngredientService;
import com.edburguer.service.OrderOptionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderOptionsServiceImpl implements OrderOptionsService {
    @Autowired
    private OrderOptionsRepository repository;

    @Autowired
    private IngredientService ingredientService;

    @Autowired
    private ProductOrdersRepository productOrdersRepository;

    @Autowired
    private OrdersRepository ordersRepository;

    @Transactional
    @Override
    public void create(OrderOptionsDto dto) {
        List<Ingredient> list = dto.getIngredients().stream().map(id -> ingredientService.findById(id)).toList();

        OrderOptions entity = repository.save(OrderOptionsMapper.fromDtoToEntity(dto, list));

        ProductOrders productOrders = dto.getProductOrders();
        productOrders.addOrderOptions(entity);
        Orders orders = dto.getOrders();
        orders.addProductOrders(productOrders);

        ordersRepository.save(orders);
    }

    @Transactional
    @Override
    public void create(OrderOptionsInitDbDto dto, ProductOrdersInitDbDto productOrdersDto, Product product, Orders orders) {
        List<Ingredient> list = dto.getIngredients().stream().map(id -> ingredientService.findById(id)).toList();

        OrderOptions entity = repository.save(OrderOptionsMapper.fromDtoToEntity(dto, list));

        ProductOrders productOrders = productOrdersRepository.save(ProductOrdersMapper.fromDtoToEntity(productOrdersDto, product));

        productOrders.addOrderOptions(entity);
        orders.addProductOrders(productOrders);

        ordersRepository.save(orders);
    }

    @Override
    public List<OrderOptions> findAll() {
        return null;
    }

    @Override
    public OrderOptions findById(Long id) {
        return null;
    }

    @Override
    public OrderOptions update(OrderOptionsDto dto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
