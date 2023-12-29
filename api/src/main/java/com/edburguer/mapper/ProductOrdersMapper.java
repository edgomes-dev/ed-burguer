package com.edburguer.mapper;

import com.edburguer.dto.ProductOrdersDto;
import com.edburguer.dto.initDb.ProductOrdersInitDbDto;
import com.edburguer.entity.Orders;
import com.edburguer.entity.Product;
import com.edburguer.entity.ProductOrders;

public class ProductOrdersMapper {
    public static ProductOrders fromDtoToEntity(ProductOrdersDto dto, Product product) {
        return ProductOrders.builder()
                .id(dto.getId())
                .product(product)
                .observation(dto.getObservation())
                .quantity(dto.getQuantity())
                .build();
    }

    public static ProductOrders fromDtoToEntity(ProductOrdersInitDbDto dto, Product product) {
        return ProductOrders.builder()
                .product(product)
                .observation(dto.getObservation())
                .quantity(dto.getQuantity())
                .build();
    }
}
