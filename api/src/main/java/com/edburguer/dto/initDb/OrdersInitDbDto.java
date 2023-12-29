package com.edburguer.dto.initDb;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrdersInitDbDto {
    private Long userId;
    private Long addressId;
    private Integer status;
    private Integer payment;
    private Integer receiveType;
    private String cpf;
    private Double price;
    private List<ProductOrdersInitDbDto> productOrders;
}
