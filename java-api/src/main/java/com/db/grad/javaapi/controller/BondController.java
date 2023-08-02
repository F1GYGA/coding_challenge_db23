package com.db.grad.javaapi.controller;


import com.db.grad.javaapi.model.Bond;
import com.db.grad.javaapi.service.BondService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class BondController {

    @Autowired
    BondService bondService;

    @GetMapping("/bonds")
    public List<String> getBonds() {
        return bondService.getAllBonds().stream().map(Bond::toString).collect(Collectors.toList());
    }
}

