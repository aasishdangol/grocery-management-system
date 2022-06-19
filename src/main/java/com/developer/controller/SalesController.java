package com.developer.controller;

import com.developer.entity.Sales;
import com.developer.service.SalesServices;
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
@RequestMapping("/sales")
public class SalesController {

    @Autowired
    private SalesServices salesServices;
    private static final Logger LOGGER = LoggerFactory.getLogger(SalesController.class);

    @Autowired
    ObjectMapper objectMapper;

    @GetMapping("/create")
    public String salesAddForm(Model model){
       Sales sales = new Sales();
        model.addAttribute("salesTitle",  "Sales Update");
        model.addAttribute("sales", sales);
        return "sales/salesaddupdateform";
    }

    @GetMapping("/list")
    public String saleslist(Model model) throws JsonProcessingException {
        model.addAttribute("salesList", salesServices.getAllSales());
        return "sales/saleslist";
    }

    @PostMapping("/createorupdate")
    public String createSles(Model model, Sales sales){
        if (sales.getId() != null){
            salesServices.updateSales(sales, sales.getId());
        }else {
            sales.setStatus("Active");
            sales.setDate(LocalDateTime.now().toString());
            salesServices.addSales(sales);
        }
        return "redirect:/sales/list";
    }


    @GetMapping("/update/{id}")
    public String updateSalesForm(@PathVariable Long id, Model model){
        Sales sales = new Sales();
        sales = salesServices.getSales(id);
        model.addAttribute("sales", sales);
        model.addAttribute("salesTitle",  "Sales Update");
        return "category/salesaddupdateform";
    }
    @GetMapping("/delete/{id}")
    public String deleteSales(@PathVariable Long id) {
        salesServices.deleteSales(id);
        return "redirect:/sales/list";
    }

}
