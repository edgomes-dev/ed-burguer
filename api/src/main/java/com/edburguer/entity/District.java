package com.edburguer.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tb_district")
public class District implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Column(name = "delivery_price")
    private Float deliveryPrice;

    @OneToMany(mappedBy = "district", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Address> address = new ArrayList<>();
}
