package com.developer.controller;

import com.developer.dao.ProductDto;
import com.developer.entity.Product;
import com.developer.entity.Sales;
import com.developer.entity.SalesDetails;
import com.developer.service.ProductServices;
import com.developer.service.SalesDetailsServices;
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

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;


@Controller
@RequestMapping("/sales")
public class SalesController {

    @Autowired
    private SalesServices salesServices;

    @Autowired
    SalesDetailsServices salesDetailsServices;

    @Autowired
    private ProductServices productServices;
    private static final Logger LOGGER = LoggerFactory.getLogger(SalesController.class);

    @Autowired
    ObjectMapper objectMapper;

    @GetMapping("/create")
    @PreAuthorize("hasAuthority('GET_SALES')")
    public String salesAddForm(Model model){
        List<Product> productList = productServices.getAllProduct();
        List<ProductDto> productDtoList = new ArrayList<>();
        Sales sales = new Sales();
        sales.setProductList(productList);
        sales.setProductDtoList(productDtoList);
        model.addAttribute("salesTitle",  "Sales Add");
        model.addAttribute("sales", sales);
        return "sales/sales_addupateform";
    }

    @GetMapping("/list")
    @PreAuthorize("hasAuthority('LIST_SALES')")
    public String saleslist(Model model) throws JsonProcessingException {
        model.addAttribute("salesList", salesServices.getAllSales());
        return "sales/sales_list";
    }

    @PostMapping("/createorupdate")
    @PreAuthorize("hasAuthority('CREATE_SALES')")
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
            Sales sales1 = salesServices.addSales(sales);

            List<SalesDetails> salesDetailsList = new ArrayList<>();

            sales.getProductDtoList().stream()
                    .filter(productDto -> productDto.getId() != null)
                    .forEach(productDto -> {
                                Product product = productServices.getProduct(productDto.getId());

                                SalesDetails salesDetails = new SalesDetails();
                                salesDetails.setProduct(product);
                                salesDetails.setSales(sales1);
                                salesDetails.setAmount(product.getPrice());
                                salesDetails.setQuantity(productDto.getQuantity());

                                salesDetailsList.add(salesDetails);
                                if (productDto.getQuantity() > product.getQuantity()){
                                    System.out.println("Out of stock");
                                }else {
                                    product.setQuantity(product.getQuantity() - productDto.getQuantity());
                                    productServices.updateProduct(product,productDto.getId());
                                }
                            });
            salesDetailsServices.saveSalesDetailsList(salesDetailsList);


        }
        return "redirect:/sales/list";
    }


    @GetMapping("/update/{id}")
    @PreAuthorize("hasAuthority('UPDATE_SALES')")
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
    @PreAuthorize("hasAuthority('DELETE_SALES')")
    public String deleteSales(@PathVariable Long id) {
        salesServices.deleteSales(id);
        return "redirect:/sales/list";
    }

}
