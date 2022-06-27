package com.developer.config;

import com.developer.entity.Product;
import com.developer.entity.Sales;
import com.developer.entity.SalesDetails;
import com.developer.service.ProductServices;
import com.developer.service.SalesDetailsServices;
import com.developer.service.SalesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class TestClass {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    ProductServices productServices;

    @Autowired
    SalesServices salesServices;

    @Autowired
    SalesDetailsServices salesDetailsServices;

//    @PostConstruct
    public void test(){
        List<SalesDetails> salesDetailsList = new ArrayList<>();

        List<Product> productList = productServices.getAllProduct();
        Sales sales = salesServices.getSales((long) 40);
        productList.forEach(product -> {

            SalesDetails salesDetails = new SalesDetails();
            salesDetails.setProduct(product);
            salesDetails.setSales(sales);
            salesDetails.setQuantity("10");
            salesDetails.setAmount(product.getPrice());

            salesDetailsList.add(salesDetails);
        });


        salesDetailsServices.saveSalesDetailsList(salesDetailsList);

//        List<SalesDetails> salesDetails = salesDetailsServices.getSalesDetailsList((long) 35);
//        Sales sales = salesServices.getSales((long) 35);




        System.out.println(passwordEncoder.encode("Secret@1234"));

    }
}
