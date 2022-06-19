package com.developer.service.impl;


import com.developer.entity.Sales;
import com.developer.repository.SalesRepository;
import com.developer.service.SalesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesServiceImpl implements SalesServices {

    @Autowired
    private SalesRepository salesRepository;

    @Override
    public List<Sales> getAllSales() {
        return  salesRepository.findAll();
    }

    @Override
    public Sales getSales(Long id) {
        return salesRepository.findById(id).get();
    }

    @Override
    public Sales addSales(Sales sales) {
        return salesRepository.save(sales);
    }

    @Override
    public Sales updateSales(Sales sales, Long id) {
        Sales tempSales = salesRepository.findById(id).get();
        if (null != tempSales) {
            sales.setId(id);
            return salesRepository.save(sales);
        }
        return null;
    }

    @Override
    public void deleteSales(Long id) {
        salesRepository.deleteById(id);

    }
}
