package com.edburguer.mapper;

import com.edburguer.dto.OrderOptionsDto;
import com.edburguer.dto.initDb.OrderOptionsInitDbDto;
import com.edburguer.entity.Ingredient;
import com.edburguer.entity.OrderOptions;
import com.edburguer.entity.ProductOrders;

import java.util.List;

public class OrderOptionsMapper {
    public static OrderOptions fromDtoToEntity(OrderOptionsDto dto, List<Ingredient> list) {
        return OrderOptions.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .ingredients(list)
                .build();
    }

    public static OrderOptions fromDtoToEntity(OrderOptionsInitDbDto dto, List<Ingredient> list) {
        return OrderOptions.builder()
                .title(dto.getTitle())
                .ingredients(list)
                .build();
    }
}
