package com.edburguer.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "products")
@Builder
@Entity
@Table(name = "tb_ingredient")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double price;

    @ManyToMany(mappedBy = "ingredients", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Product> products;
}
