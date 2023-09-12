package com.edburguer.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tb_option")
public class Option {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @Column(name = "maximum_amount")
    @NotNull
    private Integer maximumAmount;

    private Boolean required;

    @Column(name = "options_required")
    private String optionsRequired;

    @ManyToMany()
    @JoinTable(
            name = "tb_options_ingredients",
            joinColumns = @JoinColumn(name = "option_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id", referencedColumnName = "id")
    )
    private List<Ingredient> ingredients = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "product_category_id")
    @JsonBackReference
    private ProductCategory category;

    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    public void addIngredient(List<Ingredient> ingredientsList) {
        ingredients.addAll(ingredientsList);
    }

    public void removeIngredient(Ingredient ingredient) {
        ingredients.remove(ingredient);
    }
}
