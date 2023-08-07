package com.db.grad.javaapi.service;

import com.db.grad.javaapi.enums.BondType;
import com.db.grad.javaapi.enums.TradeStatus;
import com.db.grad.javaapi.enums.TradeType;
import com.db.grad.javaapi.model.*;
import com.db.grad.javaapi.repository.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
class CounterPartyServiceTest {

    @Autowired
    private BondRepository bondRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private TradeRepository tradeRepository;
    @Autowired
    private CounterPartyRepository counterPartyRepository;
    @Autowired
    private CounterPartyService counterPartyService;
    @Autowired
    private UserRepository userRepository;

    private Bond bond;
    private Book book;
    private User user;
    private Trade trade;

    @BeforeAll
    void setUp() {


        bond = new Bond();
        bond.setIsin("ABCD1234");
        bond.setCusip("QWERT1234");
        bond.setBondCurrency("USD");
        bond.setCouponPercent(25);
        bond.setFaceValue(123);
        bond.setIssuerName("Google");
        bond.setStatus("active");
        bond.setType(BondType.GOVN);
        bond.setMaturityDate(Date.valueOf(LocalDate.now()));



        trade = new Trade();
        trade.setTradeType(TradeType.buy);
        trade.setQuantity(100);
        trade.setCurrency("USD");
        trade.setUnitPrice(1000);
        trade.setTradeStatus(TradeStatus.open);
        trade.setTradeDate(Date.valueOf(LocalDate.now()));
        trade.setTradeSettlementDate(Date.valueOf(LocalDate.now()));

        Set<Trade> setTrades = new HashSet<>();
        setTrades.add(trade);

        book = new Book();
        book.setBookName("trading_book_8");
        book.setTrades(setTrades);

        trade.setBook(book);

        Set<Book> setBook = new HashSet<>();
        setBook.add(book);

        user = new User();
        user.setUserName("Michael");
        user.setPassword("michael");
        user.setUserBooks(setBook);

        Set<User> setUser = new HashSet<>();
        setUser.add(user);

        book.setBookUsers(setUser);


        CounterParty client = new CounterParty();
        client.setHolderName("X");
        client.setTrades(setTrades);


        trade.setCounterparty(client);

        bond.setTrades(setTrades);

        bondRepository.save(bond);
        counterPartyRepository.save(client);
        bookRepository.save(book);
        userRepository.save(user);
        tradeRepository.save(trade);
    }

    @Test
    void getAllCounterParties() {
        long numberOfStoredCounterParties = counterPartyRepository.count();
        assertEquals(counterPartyService.getAllCounterParties().size(), numberOfStoredCounterParties);
    }

    @Test
    void getUserCounterParties() {
        List<CounterParty> userCounterParties = counterPartyService.getUserCounterParties(user.getUserName());
        assertEquals(userCounterParties.size(), 1);
    }

    @Test
    void getPosition() {
        List<CounterParty> userCounterParties = counterPartyService.getUserCounterParties(user.getUserName());
        assertEquals(userCounterParties.size(), 1);
        double positionRes = counterPartyService.getPosition(userCounterParties.get(0), user.getUserName());
        assertEquals(positionRes, trade.getQuantity() * trade.getUnitPrice());
    }
}