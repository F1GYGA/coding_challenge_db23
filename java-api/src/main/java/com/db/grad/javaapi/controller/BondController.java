package com.db.grad.javaapi.controller;


import com.db.grad.javaapi.dto.BondDto;
import com.db.grad.javaapi.model.Bond;
import com.db.grad.javaapi.service.BondService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

@RestController
public class BondController {

    @Autowired
    BondService bondService;

    @GetMapping("/bonds")
    public List<BondDto> getBonds() {
        List<BondDto> list = new ArrayList<>();

        for (Bond bond : bondService.getAllBonds()) {
            list.add(new BondDto(bond.getIsin(), bond.getCusip(), bond.getBondCurrency(), bond.getCouponPercent(),
                    bond.getFaceValue(), bond.getIssuerName(), bond.getStatus(), bond.getType(), bond.getMaturityDate()));
        }

        return list;
    }


    @GetMapping("/bonds/maturity")
    public List<BondDto> getMaturityBonds(@RequestParam String date) {
        List<BondDto> result = new ArrayList<>();

        for (Bond bond : bondService.getMaturityBonds(date))
            result.add(new BondDto(bond.getIsin(), bond.getCusip(), bond.getBondCurrency(), bond.getCouponPercent(),
                    bond.getFaceValue(), bond.getIssuerName(), bond.getStatus(), bond.getType(), bond.getMaturityDate()));

        return result;
    }

}

