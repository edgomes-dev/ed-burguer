package com.edburguer.service;

import com.edburguer.dto.OptionDto;
import com.edburguer.dto.OrderOptionsDto;
import com.edburguer.dto.initDb.OrderOptionsInitDbDto;
import com.edburguer.dto.initDb.ProductOrdersInitDbDto;
import com.edburguer.entity.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface OrderOptionsService {
    void create(OrderOptionsDto dto);

    @Transactional
    void create(OrderOptionsInitDbDto dto, ProductOrdersInitDbDto productOrdersDto, Product product, Orders orders);

    List<OrderOptions> findAll();

    OrderOptions findById(Long id);

    OrderOptions update(OrderOptionsDto dto);

    void delete(Long id);
}
