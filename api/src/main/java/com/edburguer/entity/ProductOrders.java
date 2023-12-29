package com.edburguer.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class ProductOrders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "product_id")
    private Product product;

    @OneToMany()
    private List<OrderOptions> orderOptions = new ArrayList<>();

    private String observation;

    private Integer quantity;

    public void addOrderOptions(OrderOptions entity) {
        if(orderOptions == null) orderOptions = new ArrayList<>();

        orderOptions.add(entity);
    }
}
