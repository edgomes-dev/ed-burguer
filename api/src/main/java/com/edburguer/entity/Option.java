package com.edburguer.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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

    private String name;

    @Column(name = "maximum_amount")
    private Integer maximumAmount;

    private Boolean required;

    private Boolean repetitious;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "tb_options_ingredients",
            joinColumns = @JoinColumn(name = "option_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id", referencedColumnName = "id")
    )
    private List<Ingredient> ingredients = new ArrayList<>();

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
