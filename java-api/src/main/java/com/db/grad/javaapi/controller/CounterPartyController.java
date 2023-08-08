package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.dto.BondDto;
import com.db.grad.javaapi.dto.BookDto;
import com.db.grad.javaapi.dto.CounterPartyDto;
import com.db.grad.javaapi.dto.TradeDto;
import com.db.grad.javaapi.model.Bond;
import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.model.CounterParty;
import com.db.grad.javaapi.model.Trade;
import com.db.grad.javaapi.service.BondService;
import com.db.grad.javaapi.service.CounterPartyService;
import com.db.grad.javaapi.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class CounterPartyController {

    @Autowired
    CounterPartyService counterPartyService;

    @Autowired
    TradeService tradeService;

    @Autowired
    BondService bondService;


    @GetMapping("/counterparties")
    public List<CounterPartyDto> getCounterParties() {
        List<CounterPartyDto> list = new ArrayList<>();
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        List<CounterParty> clients = counterPartyService.getUserCounterParties(username);

        for (CounterParty counterParty : clients) {
            List<Trade> trades= tradeService.getClientTrades(counterParty, username);
            List<TradeDto> tradeDtoList = new ArrayList<>();
            for (Trade trade: trades) {
                Bond bond = trade.getBond();
                tradeDtoList.add(new TradeDto(trade.getId(), trade.getTradeType(), trade.getQuantity(), trade.getCurrency(),
                        trade.getTradeStatus(), trade.getUnitPrice(), trade.getTradeDate(), trade.getTradeSettlementDate(),
                        null, new BondDto(bond.getIsin(), bond.getCusip(), bond.getBondCurrency(), bond.getCouponPercent(),
                        bond.getFaceValue(), bond.getIssuerName(), bond.getStatus(), bond.getType(), bond.getMaturityDate(), Collections.emptyList())));
            }
            double position = counterPartyService.getPosition(counterParty, username);
            list.add(new CounterPartyDto(counterParty.getId(), counterParty.getHolderName(), position, tradeDtoList));
        }

        return list;
    }
}
