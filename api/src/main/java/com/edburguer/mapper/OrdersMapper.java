package com.edburguer.mapper;

import com.edburguer.dto.OrdersDto;
import com.edburguer.dto.initDb.OrdersInitDbDto;
import com.edburguer.entity.Address;
import com.edburguer.entity.Orders;
import com.edburguer.entity.User;
import com.edburguer.service.AddressService;
import com.edburguer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class OrdersMapper {

    public static Orders fromDtoToEntity(OrdersDto dto, User user, Address address) {
        return Orders.builder()
                .id(dto.getId())
                .user(user)
                .addresses(address)
                .status(1)
                .payment(dto.getPayment())
                .receiveType(dto.getReceiveType())
                .cpf(dto.getCpf())
                .price(dto.getPrice())
                .build();
    }

    public static Orders fromDtoToEntity(OrdersInitDbDto dto, User user, Address address) {
        return Orders.builder()
                .user(user)
                .addresses(address)
                .status(dto.getStatus())
                .payment(dto.getPayment())
                .receiveType(dto.getReceiveType())
                .cpf(dto.getCpf())
                .price(dto.getPrice())
                .build();
    }
}
