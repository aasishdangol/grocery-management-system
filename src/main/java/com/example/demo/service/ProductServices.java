package com.example.demo.service;

import com.example.demo.entity.Category;
import com.example.demo.entity.Product;

import java.util.List;

public interface ProductServices {
    public List<Product> getAllProduct();

    public Product getProduct(Long id);

    public Product addProduct(Product product);

    public Product updateProduct(Product product,Long id);

    public void deleteProduct(Long id);
}
