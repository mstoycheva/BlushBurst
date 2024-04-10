package com.dzi.project.controllers;

import com.dzi.project.models.Season;
import com.dzi.project.services.ProductService;
import com.dzi.project.services.SeasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/")
public class UISeasonController {
    @Autowired
    private final SeasonService seasonService;
    private final ProductService productService;

    public UISeasonController(SeasonService seasonService, ProductService productService) {
        this.productService = productService;
        this.seasonService = seasonService;
    }

    @GetMapping(value = "/")
    public String homeView(Model model) {
        model.addAttribute("seasons", seasonService.getSeasons());
        model.addAttribute("products", productService.getProducts());
        return "index";
    }

    @GetMapping(value = "/season")
    public String seasonView(Model model) {
        List<Season> seasons = seasonService.getSeasons();
        model.addAttribute("seasons", seasons);
        return "admin/seasons";
    }
}
