package com.edburguer.service.impl;

import com.edburguer.dto.OrdersDto;
import com.edburguer.dto.initDb.OrdersInitDbDto;
import com.edburguer.entity.Address;
import com.edburguer.entity.Orders;
import com.edburguer.entity.User;
import com.edburguer.mapper.OrdersMapper;
import com.edburguer.repository.OrdersRepository;
import com.edburguer.service.AddressService;
import com.edburguer.service.OrdersService;
import com.edburguer.service.ProductOrdersService;
import com.edburguer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private ProductOrdersService productOrdersService;

    @Transactional
    @Override
    public Orders create(OrdersDto dto) {
        User user = userService.findById(dto.getUserId());
        Address address = addressService.findById(dto.getAddressId());

        Orders orders = ordersRepository.save(OrdersMapper.fromDtoToEntity(dto, user, address));
        dto.getProducts().forEach(element -> {
            element.setOrders(orders);
            productOrdersService.create(element);
        });

        return orders;
    }

    @Transactional
    @Override
    public Orders create(OrdersInitDbDto dto) {
        User user = userService.findById(dto.getUserId());
        Address address = addressService.findById(dto.getAddressId());

        Orders orders = ordersRepository.save(OrdersMapper.fromDtoToEntity(dto, user, address));
        dto.getProductOrders().forEach(element -> {
            productOrdersService.create(element, orders);
        });

        return orders;
    }


    @Override
    public List<Orders> findAll() {
        List<Orders> list = ordersRepository.findAll();

        return list;
    }

    @Override
    public Orders findById(Long id) {
        return null;
    }

    @Override
    public Orders update(OrdersDto dto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}