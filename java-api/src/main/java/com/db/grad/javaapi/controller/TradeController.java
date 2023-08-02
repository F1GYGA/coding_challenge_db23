package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.model.Trade;
import com.db.grad.javaapi.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TradeController {

    @Autowired
    TradeService tradeService;

    @GetMapping("/trades")
    public List<String> getTrades() {
        return tradeService.getAllTrades().stream().map(Trade::toString).collect(Collectors.toList());
    }
}

