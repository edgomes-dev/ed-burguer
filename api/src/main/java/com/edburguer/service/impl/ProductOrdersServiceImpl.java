package com.edburguer.service.impl;

import com.edburguer.dto.ProductOrdersDto;
import com.edburguer.dto.initDb.ProductOrdersInitDbDto;
import com.edburguer.entity.Orders;
import com.edburguer.entity.Product;
import com.edburguer.entity.ProductOrders;
import com.edburguer.mapper.ProductOrdersMapper;
import com.edburguer.repository.OrdersRepository;
import com.edburguer.repository.ProductOrdersRepository;
import com.edburguer.service.OrderOptionsService;
import com.edburguer.service.ProductOrdersService;
import com.edburguer.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class ProductOrdersServiceImpl implements ProductOrdersService {
    @Autowired
    private ProductOrdersRepository repository;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderOptionsService orderOptionsService;

    @Autowired
    private OrdersRepository ordersRepository;

    @Transactional
    @Override
    public void create(ProductOrdersDto dto) {
        Product product = productService.findById(dto.getProductId());

        ProductOrders entity = repository.save(ProductOrdersMapper.fromDtoToEntity(dto, product));
        if(Objects.nonNull(dto.getOrderOptions())) {
            dto.getOrderOptions().forEach(element -> {
                element.setProductOrders(entity);
                element.setOrders(dto.getOrders());
                orderOptionsService.create(element);
            });
        } else {
            Orders orders = dto.getOrders();
            orders.addProductOrders(entity);

            ordersRepository.save(orders);
        }
    }

    @Transactional
    @Override
    public void create(ProductOrdersInitDbDto dto, Orders orders) {
        Product product = productService.findById(dto.getProductId());

        if(Objects.nonNull(dto.getOrderOptions())) {
            dto.getOrderOptions().forEach(element -> {
                orderOptionsService.create(element, dto, product, orders);
            });
        } else {
            ProductOrders entity = repository.save(ProductOrdersMapper.fromDtoToEntity(dto, product));
            orders.addProductOrders(entity);

            ordersRepository.save(orders);
        }
    }

    @Override
    public List<ProductOrders> findAll() {
        return null;
    }

    @Override
    public ProductOrders findById(Long id) {
        return null;
    }

    @Override
    public ProductOrders update(ProductOrdersDto dto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
