package com.edburguer.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tb_product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "image_url")
    private String imageUrl;

    private Double price;

    /*@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "tb_ingredients_products",
            joinColumns = @JoinColumn(name = "product_fk", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_fk", referencedColumnName = "id")
    )
    private List<Ingredient> ingredients;*/

    @ManyToOne
    @JoinColumn(name = "product_category_id")
    private ProductCategory productCategory;
}