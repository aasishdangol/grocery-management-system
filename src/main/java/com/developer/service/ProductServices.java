package com.developer.service;

import com.developer.entity.Product;

import java.util.List;

public interface ProductServices {
    public List<Product> getAllProduct();

    public Product getProduct(Long id);

    public Product addProduct(Product product);

    public Product updateProduct(Product product,Long id);

    public void deleteProduct(Long id);
}
