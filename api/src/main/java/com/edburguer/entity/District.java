package com.edburguer.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tb_district")
public class District {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "delivery_price")
    private Float deliveryPrice;

//    @OneToMany(mappedBy = "district", fetch = FetchType.LAZY)
//    private Set<Address> address = new HashSet<>();
}
