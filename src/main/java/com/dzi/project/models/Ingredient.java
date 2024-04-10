package com.dzi.project.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Ingredients")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ingredient_name")
    private String ingredientName;

    public Ingredient(Integer id, String ingredientName) {
        this.id = id;
        this.ingredientName = ingredientName;
    }
    public Ingredient() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String name) {
        this.ingredientName = name;
    }
}
