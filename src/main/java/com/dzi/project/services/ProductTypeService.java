package com.dzi.project.services;

import com.dzi.project.models.ProductType;
import com.dzi.project.repositories.ProductTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductTypeService {
    private final ProductTypeRepository productTypeRepository;

    public ProductTypeService(ProductTypeRepository productTypeRepository) {
        this.productTypeRepository = productTypeRepository;
    }

    public List<ProductType> getProductTypes() {
        return productTypeRepository.findAll();
    }

    public ProductType getProductType(Integer id) {
        Optional<ProductType> productType = productTypeRepository.findById(id);
        return productType.orElse(null);
    }

    public ProductType createProductType(ProductType productType) {
        return productTypeRepository.save(productType);
    }

    public void editProductType(ProductType productType) {
        productTypeRepository.save(productType);
    }

    public void deleteProductType(Integer id) {
        productTypeRepository.deleteById(id);
    }

}
