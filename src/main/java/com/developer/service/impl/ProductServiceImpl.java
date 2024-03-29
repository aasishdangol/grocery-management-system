package com.developer.service.impl;

import com.developer.entity.Product;
import com.developer.repository.ProductRepository;
import com.developer.service.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductServices {

    @Autowired
    private ProductRepository productRepository;


    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product, Long id) {
        Product tempProduct = productRepository.findById(id).get();
        if (null != tempProduct) {
            product.setId(id);
            return productRepository.save(product);
        }
        return null;
    }


    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);

    }
}
