package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.dto.CounterPartyDto;
import com.db.grad.javaapi.dto.TradeDto;
import com.db.grad.javaapi.model.Trade;
import com.db.grad.javaapi.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TradeController {

    @Autowired
    TradeService tradeService;

    @GetMapping("/trades")
    public List<TradeDto> getTrades() {
        List<TradeDto> list = new ArrayList<>();

        for (Trade trade : tradeService.getAllTrades())
            list.add(new TradeDto(trade.getId(), trade.getTradeType(), trade.getQuantity(), trade.getCurrency(),
                    trade.getTradeStatus(), trade.getUnitPrice(), trade.getTradeDate(), trade.getTradeSettlementDate(),
                    null, null));

        return list;
    }
}

