package com.dzi.project.controllers;
import com.dzi.project.services.ProductTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/")
public class UIProductTypeController {
    private final ProductTypeService productTypeService;

    public UIProductTypeController(ProductTypeService productTypeService) {

        this.productTypeService = productTypeService;
    }

}
