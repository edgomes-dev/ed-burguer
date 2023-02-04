package com.edburguer.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "districts")
public class District implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "districts_id")
    private Long id;

    private String name;

    @Column(name = "delivery_price")
    private String deliveryPrice;

    @OneToMany(mappedBy = "district", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Address> address;
}
