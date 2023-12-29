package com.edburguer.dto;

import com.edburguer.entity.Orders;
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
public class ProductOrdersDto {
    private Long id;
    @JsonProperty("product_id")
    private Long productId;
    private String observation;
    private Integer quantity;
    private Orders orders;
    private List<OrderOptionsDto> orderOptions;
}
