package com.dzi.project.controllers;

import com.dzi.project.models.Product;
import com.dzi.project.models.User;
import com.dzi.project.services.ProductService;
import com.dzi.project.services.UserService;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchController {

    private final ProductService productService;

    public SearchController(ProductService productService) {
        this.productService = productService;
    }

//    @GetMapping(value = "/allproducts")
//    public List<Product> getAllProducts() {
//        return productService.getProducts();
//    }

}
