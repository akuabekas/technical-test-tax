package com.test.code.repository;

import com.test.code.model.TaxRelief;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxReliefRepository extends JpaRepository<TaxRelief, Long> {
    
}