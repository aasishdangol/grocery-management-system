package com.developer.controller;

import com.developer.entity.Product;
import com.developer.entity.Sales;
import com.developer.service.ProductServices;
import com.developer.service.SalesServices;
import com.developer.util.ConstantValue;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;


@Controller
@RequestMapping("/sales")
public class SalesController {

    @Autowired
    private SalesServices salesServices;

    @Autowired
    private ProductServices productServices;
    private static final Logger LOGGER = LoggerFactory.getLogger(SalesController.class);

    @Autowired
    ObjectMapper objectMapper;

    @GetMapping("/create")
    public String salesAddForm(Model model){
        List<Product> productList = productServices.getAllProduct();
        Sales sales = new Sales();
        sales.setProductList(productList);
        model.addAttribute("salesTitle",  "Sales Add");
        model.addAttribute("sales", sales);
        return "sales/sales_addupateform";
    }

    @GetMapping("/list")
    public String saleslist(Model model) throws JsonProcessingException {
        model.addAttribute("salesList", salesServices.getAllSales());
        return "sales/sales_list";
    }

    @PostMapping("/createorupdate")
    public String createSales(Model model, Sales sales){
        if (sales.getId() != null){
            Sales sale= salesServices.getSales(sales.getId());
                sale.setDate(sales.getDate());
                sale.setPaymentBy(sales.getPaymentBy());
                sale.setDiscount(sales.getDiscount());
             salesServices.updateSales(sale, sales.getId());
        }else {
            sales.setSalesCode(ConstantValue.generateSalesId());
            sales.setDate(LocalDateTime.now().toString());
            salesServices.addSales(sales);
        }
        return "redirect:/sales/list";
    }


    @GetMapping("/update/{id}")
    public String updateSalesForm(@PathVariable Long id, Model model){
        List<Product> productList = productServices.getAllProduct();
        Sales sales = new Sales();
        sales = salesServices.getSales(id);
        sales.setProductList(productList);
        model.addAttribute("sales", sales);
        model.addAttribute("salesTitle",  "Sales Update");
        return "sales/sales_addupateform";
    }
    @GetMapping("/delete/{id}")
    public String deleteSales(@PathVariable Long id) {
        salesServices.deleteSales(id);
        return "redirect:/sales/list";
    }

}
