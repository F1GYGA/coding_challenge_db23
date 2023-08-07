package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.model.CounterParty;
import com.db.grad.javaapi.model.Trade;
import com.db.grad.javaapi.model.User;
import com.db.grad.javaapi.repository.TradeRepository;
import com.db.grad.javaapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TradeService {

    @Autowired
    private TradeRepository tradeRepo;

    @Autowired
    private UserRepository userRepo;

    public List<Trade> getAllTrades() {
        return tradeRepo.findAll();
    }

    public List<Trade> getClientTrades(CounterParty client, String username) {
        User user = userRepo.findByUserName(username).orElseThrow(() ->
                new UsernameNotFoundException("User not found with username: " + username));
        List<Book> books = new ArrayList<>(user.getUserBooks());
        return books.stream()
                .map(Book::getTrades)
                .flatMap(Collection::stream)
                .filter(trade -> trade.getCounterparty() == client)
                .distinct()
                .collect(Collectors.toList());
    }

}
