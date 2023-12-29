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
public class OrderOptionsInitDbDto {
    private String title;
    private List<Long> ingredients;
}
