package com.edburguer.service;

import com.edburguer.dto.OptionDto;
import com.edburguer.dto.ProductOrdersDto;
import com.edburguer.dto.initDb.ProductOrdersInitDbDto;
import com.edburguer.entity.Option;
import com.edburguer.entity.Orders;
import com.edburguer.entity.ProductOrders;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProductOrdersService {
    void create(ProductOrdersDto dto);

    @Transactional
    void create(ProductOrdersInitDbDto dto, Orders orders);

    List<ProductOrders> findAll();

    ProductOrders findById(Long id);

    ProductOrders update(ProductOrdersDto dto);

    void delete(Long id);
}
