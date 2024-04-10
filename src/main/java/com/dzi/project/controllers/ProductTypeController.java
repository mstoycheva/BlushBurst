package com.dzi.project.controllers;

import com.dzi.project.models.Product;
import com.dzi.project.models.ProductType;
import com.dzi.project.services.ProductService;
import com.dzi.project.services.ProductTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductTypeController {
    private final ProductTypeService productTypeService;

    public ProductTypeController(ProductTypeService productTypeService) {
        this.productTypeService = productTypeService;
    }


    @DeleteMapping(value = "/productType/{id}")
    public void deleteProductType(@PathVariable Integer id) {
        productTypeService.deleteProductType(id);
    }
}
