package com.db.grad.javaapi.service;

import com.db.grad.javaapi.enums.TradeStatus;
import com.db.grad.javaapi.enums.TradeType;
import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.model.CounterParty;
import com.db.grad.javaapi.model.Trade;
import com.db.grad.javaapi.model.User;
import com.db.grad.javaapi.repository.BookRepository;
import com.db.grad.javaapi.repository.CounterPartyRepository;
import com.db.grad.javaapi.repository.TradeRepository;
import com.db.grad.javaapi.repository.UserRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
class TradeServiceTest {
    @Autowired
    private CounterPartyRepository counterPartyRepository;
    @Autowired
    private TradeService tradeService;
    @Autowired
    private BookService bookService;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TradeRepository tradeRepository;

    private Book book;
    private CounterParty client;



    @BeforeAll
    void setUp() {
        this.client = new CounterParty();
        client.setHolderName("Atta Systems");

        Trade trade = new Trade();
        trade.setTradeType(TradeType.buy);
        trade.setQuantity(100);
        trade.setCurrency("USD");
        trade.setUnitPrice(1000);
        trade.setTradeStatus(TradeStatus.open);
        trade.setTradeDate(Date.valueOf(LocalDate.now()));
        trade.setTradeSettlementDate(Date.valueOf(LocalDate.now()));


        this.book = new Book();
        book.setBookName("trading_book_8");

        Set<Book> set = new HashSet<>();
        Set<User> setUser = new HashSet<>();
        Set<Trade> setTrades = new HashSet<>();

        setTrades.add(trade);
        set.add(book);

        client.setTrades(setTrades);

        User user = new User();
        user.setUserName("Michael");
        user.setPassword("michael");
        user.setUserBooks(set);
        setUser.add(user);
        book.setBookUsers(setUser);
        book.setTrades(setTrades);

        trade.setBook(book);
        trade.setCounterparty(client);

        counterPartyRepository.save(client);
        bookRepository.save(book);
        userRepository.save(user);
        tradeRepository.save(trade);
    }

    @Test
    void getAllTrades() {
    }

    @Test
    void getClientTrades() {
        List<Trade> trades = tradeService.getClientTrades(client, "Michael");
        assertEquals(1, trades.size());
    }
}