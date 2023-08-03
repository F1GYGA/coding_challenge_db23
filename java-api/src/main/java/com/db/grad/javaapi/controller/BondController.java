package com.db.grad.javaapi.controller;


import com.db.grad.javaapi.dto.BondDto;
import com.db.grad.javaapi.exception.ResourceNotFoundException;
import com.db.grad.javaapi.model.Bond;
import com.db.grad.javaapi.service.BondService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.DateFormatter;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
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


    @GetMapping("/bonds/maturity/{date}")
    public List<BondDto> getMaturityBonds(@PathVariable(value = "date") String date) {
        List<BondDto> result = new ArrayList<>();

        for (Bond bond : bondService.getAllBonds()) {
            String maturityDate = String.valueOf(bond.getMaturityDate());

            LocalDate date1 = LocalDate.parse(date);
            LocalDate date2 = LocalDate.parse(maturityDate);

            long daysBetween = abs(date1.toEpochDay() - date2.toEpochDay());
            if (daysBetween <= 5)
                result.add(new BondDto(bond.getIsin(), bond.getCusip(), bond.getBondCurrency(), bond.getCouponPercent(),
                        bond.getFaceValue(), bond.getIssuerName(), bond.getStatus(), bond.getType(), bond.getMaturityDate()));
        }

        return result;
    }

}

