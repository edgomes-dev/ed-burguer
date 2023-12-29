package com.edburguer.dto;

import com.edburguer.entity.Orders;
import com.edburguer.entity.ProductOrders;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.implementation.bind.annotation.BindingPriority;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderOptionsDto {
    private Long id;
    private String title;
    private ProductOrders productOrders;
    private List<Long> ingredients;
    private Orders orders;
}
