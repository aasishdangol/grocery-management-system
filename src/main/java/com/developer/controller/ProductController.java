package com.developer.controller;

import com.developer.dao.ProductDto;
import com.developer.entity.Product;
import com.developer.entity.Role;
import com.developer.entity.Sales;
import com.developer.entity.User;
import com.developer.service.CategoryServices;
import com.developer.service.ProductServices;
import com.developer.service.RoleServices;
import com.developer.service.SalesServices;
import com.developer.util.ConstantValue;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductServices productServices;

    @Autowired
    private CategoryServices categoryServices;

    @Autowired
    private SalesServices salesServices;
    List<Sales> salesList;
    private Product product;

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    ObjectMapper objectMapper;

    @ResponseBody
    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable Long id){
        ProductDto productDto = new ProductDto();

        product = productServices.getProduct(id);

        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setQuantity(product.getQuantity());
        productDto.setSellingPrice(product.getPrice());

        return productDto;
    }

    @GetMapping("/create")
    @PreAuthorize("hasAuthority('GET_PRODUCT')")
    public String productAddForm(Model model){
        Product product = new Product();
        salesList = salesServices.getAllSales();
        product.setSalesList(salesList);
        model.addAttribute("productTitle",  "Product Update");
        model.addAttribute("product", product);
        model.addAttribute("categories", categoryServices.getAllCategory());
        return "product/prod_addupdateform";
    }

    @GetMapping("/list")
    @PreAuthorize("hasAuthority('LIST_PRODUCT')")
    public String productlist(Model model) throws JsonProcessingException {
        model.addAttribute("productList", productServices.getAllProduct());
        return "product/prod_list";
    }

    @PostMapping("/createorupdate")
        @PreAuthorize("hasAuthority('CREATE_PRODUCT')")
    public String createProduct(Model model, Product product){
        salesList = new ArrayList<>();
        product.getSalesList().forEach(sales -> {
            if (sales.getSelected()){
                this.salesList.add(sales);
            }
        });
//        product.setSalesDetail(new HashSet<>(salesList));

        if (product.getId() != null){
            Product prod = productServices.getProduct(product.getId());
            product.setProductCode(prod.getProductCode());
//            prod.setName(product.getName());
//            prod.setCategory(product.getCategory());
//            prod.setPrice(product.getPrice());
//            prod.setQuantity(product.getQuantity());
//            prod.setDescription(product.getDescription());
            productServices.updateProduct(product, product.getId());
        }else {
            product.setProductCode(ConstantValue.generateProductId());
            product.setStatus("Active");
            productServices.addProduct(product);
        }

        return "redirect:/product/list";
    }

    @GetMapping("/update/{id}")
    @PreAuthorize("hasAuthority('UPDATE_PRODUCT')")
    public String updateProductForm(@PathVariable Long id, Model model){
        salesList =salesServices.getAllSales();
        product = productServices.getProduct(id);
        product.setSalesList(salesList);

      /*  product.getSalesDetail().forEach(salesDetail ->{
            product.getSalesList().forEach(sales -> {
                if (salesDetail.getId().equals(sales.getId())){
                    sales.setSelected(true);
                }
            });
        });*/
        model.addAttribute("product", product);
        model.addAttribute("categories", categoryServices.getAllCategory());
        model.addAttribute("productTitle",  "Product Update");
        return "product/prod_addupdateform";
    }
    @GetMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('DELETE_PRODUCT')")
    public String deleteProduct(@PathVariable Long id) {
        productServices.deleteProduct(id);
        return "redirect:/product/list";
    }
}
