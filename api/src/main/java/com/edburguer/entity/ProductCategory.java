package com.edburguer.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tb_product_category")
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @Column(name = "image_url")
    @NotNull
    private String imageUrl;

    @OneToMany(mappedBy = "category")
    @JsonManagedReference
    private List<Option> options = new ArrayList<>();

    @OneToMany(mappedBy = "productCategory")
    @JsonManagedReference
    private List<Product> products = new ArrayList<>();

    public void addOption(Option option) {
        this.options.add(option);
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public ProductCategory(Long id, String name, String imageUrl) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
    }
}
