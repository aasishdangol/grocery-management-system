package com.developer.controller;

import com.developer.dao.ProductDto;
import com.developer.dao.SalesDetailsDao;
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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/salesdetails")
public class SalesDetailsController {

    @Autowired
    private SalesDetailsServices salesDetailsServices;


    private static final Logger LOGGER = LoggerFactory.getLogger(SalesDetailsController.class);

    @Autowired
    ObjectMapper objectMapper;

    @GetMapping("/{salesid}")
    public String salesDetailsGet(Model model, @PathVariable Long salesid){
        List<SalesDetails> salesDetailsList = salesDetailsServices.getSalesDetailsList(salesid);
        SalesDetailsDao salesDetailsDao = new SalesDetailsDao();
        if (salesDetailsList.size() > 0){
            List<ProductDto> productDtoList = new ArrayList<>();
            salesDetailsList.forEach(salesDetails -> {
                ProductDto productDto = new ProductDto();
                Sales sales = salesDetails.getSales();
                Product product =salesDetails.getProduct();
                if (salesDetailsDao.getSalesId() == null && sales != null){
                    salesDetailsDao.setSalesId(sales.getId());
                    salesDetailsDao.setSalesCode(sales.getSalesCode());
                    salesDetailsDao.setDiscount(sales.getDiscount());
                    salesDetailsDao.setDate(sales.getDate());
                    salesDetailsDao.setPaymentBy(sales.getPaymentBy());

                }
                productDto.setId(product.getId());
                productDto.setProductCode(product.getProductCode());
                productDto.setName(product.getName());
                productDto.setQuantity(salesDetails.getQuantity());
                productDto.setSellingPrice(salesDetails.getAmount());

                productDtoList.add(productDto);
            });
            salesDetailsDao.setProduct(productDtoList);
        }

        model.addAttribute("salesDetails",  salesDetailsDao);
        return "/sales/sales_details";
    }


}
