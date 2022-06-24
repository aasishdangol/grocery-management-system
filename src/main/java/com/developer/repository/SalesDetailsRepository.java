package com.developer.repository;


import com.developer.entity.SalesDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesDetailsRepository extends JpaRepository<SalesDetails,Long> {

    List<SalesDetails> findBySalesId(Long sales);
}
