package com.dzi.project.models;

import jakarta.persistence.*;

@Entity
@Table(name = "product_types")
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "type_name")
    private String productTypeName;

    public ProductType(Integer id, String productTypeName) {
        this.id = id;
        this.productTypeName = productTypeName;
    }

    public ProductType() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return productTypeName;
    }

    public void setName(String productTypeName) {
        this.productTypeName = productTypeName;
    }
}
