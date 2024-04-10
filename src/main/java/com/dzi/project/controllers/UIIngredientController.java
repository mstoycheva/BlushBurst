package com.dzi.project.controllers;

import com.dzi.project.models.Ingredient;
import com.dzi.project.services.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping(value = "/")
public class UIIngredientController {
    @Autowired
    private final IngredientService ingredientService;

    public UIIngredientController(IngredientService ingredientService) {

        this.ingredientService = ingredientService;
    }
    @GetMapping(value = "/ingredients")
    public String ingredientView(Model model) {
        List<Ingredient> ingredients = ingredientService.getIngredients();
        model.addAttribute("ingredients", ingredients);
        return "admin/ingredients";
    }

    @GetMapping("ingredients/create-ingredient")
    public String createIngredient(Model model) {
        model.addAttribute("ingredient", new Ingredient());
        return "admin/create-ingredient";
    }

    @PostMapping(path = "/ingredients", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public RedirectView submitForm(Ingredient ingredient) {
        ingredientService.createIngredient(ingredient);
        return new RedirectView("/ingredients");
    }

    @GetMapping(value = "/ingredients/edit-ingredient/{id}")
    public String editIngredient(@PathVariable int id, Model model) {
        Ingredient editIngredient = ingredientService.getIngredient(id);
        model.addAttribute("ingredient", editIngredient);
        return "admin/edit-ingredient";
    }

    @PostMapping(value = "/ingredients/edit-ingredient")
    public RedirectView editSubmitUser(@ModelAttribute(value = "ingredient") Ingredient ingredient) {
        ingredientService.editIngredient(ingredient);
        return new RedirectView("/ingredients");
    }
}
