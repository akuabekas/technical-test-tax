package com.test.code.service;

import java.util.List;

import com.test.code.model.TaxRelief;
import com.test.code.payload.Soal3Request;
import com.test.code.repository.TaxReliefRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaxService {

    @Autowired
    TaxReliefRepository taxReliefRepository;
     
    public Double anualTaxableIncome(Integer gajiPerTahun) {
        
        Integer sisaGajiPerTahun = 0;
        Double countTax = 0.0;

        if (gajiPerTahun <= 50000000) {
            countTax = gajiPerTahun * 0.05;
            sisaGajiPerTahun = 0;
        } else {
            sisaGajiPerTahun = gajiPerTahun - 50000000;
            countTax = 50000000 * 0.05;
        }

        if (sisaGajiPerTahun == 0) {
            return countTax;
        }

        if (gajiPerTahun <= 250000000) {
            countTax = countTax + (sisaGajiPerTahun * 0.15);
            sisaGajiPerTahun = 0;
        } else {
            sisaGajiPerTahun = sisaGajiPerTahun - 200000000;
            countTax = countTax + (200000000 * 0.15);
        }

        if (sisaGajiPerTahun == 0) {
            return countTax;
        }

        if (gajiPerTahun >= 250000000 && gajiPerTahun <= 500000000) {
            countTax = countTax + (sisaGajiPerTahun * 0.25);
            sisaGajiPerTahun = 0;
        } else {
            sisaGajiPerTahun = sisaGajiPerTahun - 250000000;
            countTax = countTax + (250000000 * 0.25);
        }

        if (sisaGajiPerTahun == 0) {
            return countTax;
        }

        if (gajiPerTahun >= 500000000) {
            countTax = countTax + (sisaGajiPerTahun * 0.3);
        }

        return countTax;
    }

    public Double taxRelief(Soal3Request payload) {
        
        List<TaxRelief> list = taxReliefRepository.findAll();
        Integer gajiPerTahun = 0;

        for (TaxRelief taxRelief : list) {
            if (payload.getStatus().equalsIgnoreCase(taxRelief.getCode())) {
                gajiPerTahun = (payload.getGaji() * 12) - taxRelief.getValue();

            }
        }
        
        return anualTaxableIncome(gajiPerTahun);
    }
}