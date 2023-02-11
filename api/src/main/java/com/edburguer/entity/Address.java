package com.edburguer.entity;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tb_address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String street;

    private String number;

    private String complement;

    @ManyToOne()
    @JoinColumn(name = "district_id")
    private District district;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;
}
