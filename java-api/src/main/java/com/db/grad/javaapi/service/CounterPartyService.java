package com.db.grad.javaapi.service;

import com.db.grad.javaapi.enums.TradeType;
import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.model.CounterParty;
import com.db.grad.javaapi.model.Trade;
import com.db.grad.javaapi.model.User;
import com.db.grad.javaapi.repository.CounterPartyRepository;
import com.db.grad.javaapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CounterPartyService {

    private float GBPUSD = 1.27F;

    @Autowired
    private CounterPartyRepository counterPartyRepo;

    @Autowired
    private UserRepository userRepo;

    public List<CounterParty> getAllCounterParties() {
        return counterPartyRepo.findAll();
    }

    public List<CounterParty> getUserCounterParties(String username) {
        User user = userRepo.findByUserName(username).orElseThrow(() ->
                new UsernameNotFoundException("User not found with username: " + username));
        List<Book> books = new ArrayList<>(user.getUserBooks());
        return books.stream()
                .map(Book::getTrades)
                .flatMap(Collection::stream)
                .map(Trade::getCounterparty)
                .distinct()
                .sorted(Comparator.comparing(CounterParty::getHolderName))
                .collect(Collectors.toList());
    }

    public double getPosition(CounterParty client, String username) {
        User user = userRepo.findByUserName(username).orElseThrow(() ->
                new UsernameNotFoundException("User not found with username: " + username));
        List<Book> books = new ArrayList<>(user.getUserBooks());
        List<Trade> trades = books.stream()
                .map(Book::getTrades)
                .flatMap(Collection::stream)
                .distinct()
                .filter(trade -> trade.getCounterparty() == client)
                .collect(Collectors.toList());
        double position = 0;
        for (Trade trade : trades) {
            double value = (1d * trade.getQuantity()) * trade.getUnitPrice();
            if (Objects.equals(trade.getCurrency(), "GBP")) {
                value *= GBPUSD;
            }
            if (trade.getTradeType() == TradeType.buy) {
                position += value;
            } else {
                position -= value;
            }
        }
        return position;
    }

}
