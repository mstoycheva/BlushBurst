package com.dzi.project.controllers;

import com.dzi.project.models.Product;
import com.dzi.project.services.ProductService;
import com.dzi.project.services.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping(value = "/")
public class UIProductController {
    @Autowired
    private final ProductService productService;
    private final ProductTypeService productTypeService;

    public UIProductController(ProductService productService, ProductTypeService productTypeService) {

        this.productService = productService;
        this.productTypeService = productTypeService;
    }
    @GetMapping(value = "/products")
    public String productsView(Model model) {
        List<Product> products = productService.getProducts();
        model.addAttribute("products", products);
        return "admin/products";
    }

    @GetMapping(value = "/product")
    public String productView(Model model) {
        model.addAttribute("products", productService.getProducts());
        model.addAttribute("types", productTypeService.getProductTypes());
        return "product";
    }

    @GetMapping("products/create-product")
    public String createProduct(Model model) {
        model.addAttribute("product",new Product());
        return "admin/create-product";
    }

    @PostMapping(path = "/products", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public RedirectView submitProduct(Product product) {
        productService.createProduct(product);
        return new RedirectView("/products");
    }

    @GetMapping(value = "/products/edit-product/{id}")
    public String editProduct(@PathVariable int id, Model model) {
        Product edit = productService.getProduct(id);
        model.addAttribute("product", edit);
        return "admin/edit-product";
    }
    @PostMapping(value = "/products/edit-product")
    public RedirectView editSubmitProduct(@ModelAttribute(value = "product") Product product) {
        productService.editProduct(product);
        return new RedirectView("/products");
    }
}
