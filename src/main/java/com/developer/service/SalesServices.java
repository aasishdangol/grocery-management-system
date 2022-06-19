package com.developer.service;

import com.developer.entity.Sales;
import org.springframework.stereotype.Service;

import java.util.List;


public interface SalesServices {
    public List<Sales> getAllSales();

    public Sales getSales(Long id);

    public Sales addSales(Sales sales);

    public Sales updateSales(Sales sales,Long id);

    public void deleteSales(Long id);
}

