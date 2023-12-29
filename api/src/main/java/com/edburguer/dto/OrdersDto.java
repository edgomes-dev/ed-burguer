package com.edburguer.dto;

import com.edburguer.entity.Payment;
import com.edburguer.entity.ReceiveType;
import com.edburguer.entity.Status;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrdersDto {
    private Long id;
    @JsonProperty("user_id")
    private Long userId;
    @JsonProperty("address_id")
    private Long addressId;
    private Integer payment;
    @JsonProperty("receive_type")
    private Integer receiveType;
    private String cpf;
    private Double price;
    private List<ProductOrdersDto> products;
}
