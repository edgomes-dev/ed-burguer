package com.edburguer.service;

import com.edburguer.dto.OrdersDto;
import com.edburguer.dto.ProductOrdersDto;
import com.edburguer.dto.initDb.OrdersInitDbDto;
import com.edburguer.entity.Orders;
import com.edburguer.entity.ProductOrders;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface OrdersService {
    Orders create(OrdersDto dto);

    @Transactional
    Orders create(OrdersInitDbDto dto);

    List<Orders> findAll();

    Orders findById(Long id);

    Orders update(OrdersDto dto);

    void delete(Long id);
}
