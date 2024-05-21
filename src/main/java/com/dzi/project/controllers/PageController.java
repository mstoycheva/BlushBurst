package com.dzi.project.controllers;

import com.dzi.project.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PageController {
    @Autowired
    private final ProductService productService;
    private final CompanyService companyService;
    private final SeasonService seasonService;
    private final IngredientService ingredientService;
    private final ProductTypeService productTypeService;

    public PageController(ProductService productService, CompanyService companyService, SeasonService seasonService, IngredientService ingredientService, ProductTypeService productTypeService) {
        this.productService = productService;
        this.companyService = companyService;
        this.seasonService = seasonService;
        this.ingredientService = ingredientService;
        this.productTypeService = productTypeService;
    }


    @GetMapping("/product-details/{id}")
    public String getProductDet(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.getProduct(id));
        model.addAttribute("companies", companyService.getCompanies());
        model.addAttribute("seasons", seasonService.getSeasons());
        model.addAttribute("ingredients", ingredientService.getIngredients());
        model.addAttribute("types", productTypeService.getProductTypes());
        return "product-details";
    }

    @GetMapping(value = "/season-details/{seasonId}")
    public String getSeasonDetails(@PathVariable int seasonId, Model model) {
        model.addAttribute("seasons", seasonService.getSeason(seasonId));
        model.addAttribute("products", productService.getProducts());
        return "season-details";
    }

    @GetMapping(value = "/product-type-details/{id}")
    public String typeView(@PathVariable int id,Model model) {
        model.addAttribute("types", productTypeService.getProductType(id));
        model.addAttribute("products", productService.getProducts());
        return "product-type-details";
    }

    @GetMapping(value = "/company-details/{id}")
    public String companyView(@PathVariable int id,Model model) {
        model.addAttribute("companies", companyService.getCompany(id));
        model.addAttribute("products", productService.getProducts());
        return "company-details";
    }
}