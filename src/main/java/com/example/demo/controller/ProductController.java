package com.example.demo.controller;

import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import com.example.demo.service.CategoryServices;
import com.example.demo.service.ProductServices;
import com.example.demo.util.ConstantValue;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductServices productServices;

    @Autowired
    private CategoryServices categoryServices;

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    ObjectMapper objectMapper;

    @GetMapping("/create")
    public String productAddForm(Model model){
        Product product = new Product();
        model.addAttribute("productTitle",  "Product Update");
        model.addAttribute("product", product);
        model.addAttribute("categories", categoryServices.getAllCategory());
        return "product/prod_addupdateform";
    }

    @GetMapping("/list")
    public String productlist(Model model) throws JsonProcessingException {
        model.addAttribute("productList", productServices.getAllProduct());
        return "product/prod_list";
    }
    @PostMapping("/createorupdate")
    public String createProduct(Model model, Product product){
        if (product.getId() != null){
            productServices.updateProduct(product, product.getId());
        }else {
            product.setProductId(ConstantValue.generateProductId());
            product.setStatus("Active");
            productServices.addProduct(product);
        }

        return "redirect:/product/list";
    }

    @GetMapping("/update/{id}")
    public String updateProductForm(@PathVariable Long id, Model model){
        Product product = new Product();
        product = productServices.getProduct(id);
        model.addAttribute("product", product);
        model.addAttribute("categories", categoryServices.getAllCategory());
        model.addAttribute("productTitle",  "Product Update");
        return "product/prod_addupdateform";
    }
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productServices.deleteProduct(id);
        return "redirect:/product/list";
    }
}
