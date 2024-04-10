package com.dzi.project.services;

import com.dzi.project.models.Product;
import com.dzi.project.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product getProduct(Integer id) {
        Optional<Product> user = productRepository.findById(id);
        return user.orElse(null);
    }

    public Product createProduct(Product user) {
        return productRepository.save(user);
    }

    public void editProduct(Product playgroundProduct) {
        productRepository.save(playgroundProduct);
    }

    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }


}
