package com.developer.service;

import com.developer.entity.SalesDetails;

import java.util.List;


public interface SalesDetailsServices {
    public List<SalesDetails> getAllSalesDetails();

    public SalesDetails getSalesDetails(Long id);

    public SalesDetails addSalesDetails(SalesDetails salesDetails);

    public SalesDetails updateSalesDetails(SalesDetails salesDetails,Long id);

    public void deleteSalesDetails(Long id);

    public List<SalesDetails> saveSalesDetailsList(List<SalesDetails> salesDetailsList);
    public List<SalesDetails> getSalesDetailsList(Long id);
}

