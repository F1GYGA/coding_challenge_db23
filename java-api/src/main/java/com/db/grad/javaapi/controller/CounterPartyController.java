package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.dto.CounterPartyDto;
import com.db.grad.javaapi.model.CounterParty;
import com.db.grad.javaapi.service.CounterPartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class CounterPartyController {

    @Autowired
    CounterPartyService counterPartyService;

    @GetMapping("/counterparties")
    public List<CounterPartyDto> getCounterParties() {
        List<CounterPartyDto> list = new ArrayList<>();

        for (CounterParty counterParty : counterPartyService.getAllCounterParties()) {
            list.add(new CounterPartyDto(counterParty.getId(), counterParty.getHolderName()));
        }

        return list;
    }
}
