package com.developer.service.impl;


import com.developer.entity.Sales;
import com.developer.entity.SalesDetails;
import com.developer.repository.SalesDetailsRepository;
import com.developer.repository.SalesRepository;
import com.developer.service.SalesDetailsServices;
import com.developer.service.SalesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesDetailsServiceImpl implements SalesDetailsServices {

    @Autowired
    private SalesDetailsRepository salesDetailsRepository;

    @Override
    public List<SalesDetails> getAllSalesDetails() {
        return  salesDetailsRepository.findAll();
    }

    @Override
    public SalesDetails getSalesDetails(Long id) {
        return salesDetailsRepository.findById(id).get();
    }

    @Override
    public SalesDetails addSalesDetails(SalesDetails salesDetails) {
        return salesDetailsRepository.save(salesDetails);
    }

    @Override
    public SalesDetails updateSalesDetails(SalesDetails salesDetails, Long id) {
        SalesDetails tempSalesDetails = salesDetailsRepository.findById(id).get();
        if (null != tempSalesDetails) {
            salesDetails.setId(id);
            return salesDetailsRepository.save(salesDetails);
        }
        return null;
    }

    @Override
    public void deleteSalesDetails(Long id) {
        salesDetailsRepository.deleteById(id);

    }

    @Override
    public List<SalesDetails> saveSalesDetailsList(List<SalesDetails> salesDetailsList) {
        return salesDetailsRepository.saveAll(salesDetailsList);
    }

    @Override
    public List<SalesDetails> getSalesDetailsList(Long id) {
        return salesDetailsRepository.findBySalesId(id);
    }
}
