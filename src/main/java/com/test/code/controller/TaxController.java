package com.test.code.controller;

import com.test.code.common.ConstantCommon;
import com.test.code.payload.Soal2Request;
import com.test.code.payload.Soal3Request;
import com.test.code.service.TaxService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaxController {

    @Autowired
    TaxService taxService;

    @RequestMapping(value = "/api/soal-2", method = RequestMethod.GET)
    public String soalNomor2(@RequestBody Soal2Request payload) {
        try {

            if (payload.getGaji() == null) {
                return "Gaji Tidak Boleh 0";
            }

            Integer gajiPerTahun = payload.getGaji() * 12;
            Double countTax = taxService.anualTaxableIncome(gajiPerTahun);

            return ConstantCommon.formatCurrencyIndonesia(countTax.intValue());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "error";
    }

    @RequestMapping(value = "/api/soal-3", method = RequestMethod.GET)
    public String soalNomor3(@RequestBody Soal3Request payload) {
        try {
            if (payload.getGaji() == null) {
                return "Gaji Tidak Boleh 0";
            }
    
            Double countTax = taxService.taxRelief(payload);
    
            return ConstantCommon.formatCurrencyIndonesia(countTax.intValue());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "error";
    }
    
}