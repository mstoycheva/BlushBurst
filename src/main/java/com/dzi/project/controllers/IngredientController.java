package com.dzi.project.controllers;

import com.dzi.project.models.Ingredient;
import com.dzi.project.services.IngredientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/")
public class IngredientController {
    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @DeleteMapping(value = "/ingredients/{id}")
    public void deleteIngredient(@PathVariable Integer id) {
        ingredientService.deleteIngredient(id);
    }

}
