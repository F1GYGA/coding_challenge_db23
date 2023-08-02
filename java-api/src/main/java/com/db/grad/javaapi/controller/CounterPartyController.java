package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.model.CounterParty;
import com.db.grad.javaapi.service.CounterPartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CounterPartyController {

    @Autowired
    CounterPartyService counterPartyService;

    @GetMapping("/counterparties")
    public List<String> getCounterParties() {
        return counterPartyService.getAllCounterParties().stream().map(CounterParty::toString).collect(Collectors.toList());
    }
}
