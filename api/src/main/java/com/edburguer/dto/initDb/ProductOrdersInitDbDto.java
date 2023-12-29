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
public class ProductOrdersInitDbDto {
    private Long productId;
    private String observation;
    private Integer quantity;
    private List<OrderOptionsInitDbDto> orderOptions;
}
