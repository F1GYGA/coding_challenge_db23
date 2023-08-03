package com.db.grad.javaapi.controller;


import com.db.grad.javaapi.dto.BondDto;
import com.db.grad.javaapi.model.Bond;
import com.db.grad.javaapi.service.BondService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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
}

