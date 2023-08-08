package com.db.grad.javaapi.service;

import com.db.grad.javaapi.enums.BondType;
import com.db.grad.javaapi.enums.TradeStatus;
import com.db.grad.javaapi.enums.TradeType;
import com.db.grad.javaapi.model.Bond;
import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.model.CounterParty;
import com.db.grad.javaapi.model.Trade;
import com.db.grad.javaapi.repository.BondRepository;
import com.db.grad.javaapi.repository.BookRepository;
import com.db.grad.javaapi.repository.CounterPartyRepository;
import com.db.grad.javaapi.repository.TradeRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.swing.text.html.Option;
import java.sql.Date;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
class BondServiceTest {
    @Autowired
    private BondRepository bondRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private TradeRepository tradeRepository;
    @Autowired
    private CounterPartyRepository counterPartyRepository;
    @Autowired
    private BondService bondService;
    private Bond bond;
    private Book book;

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



        Trade trade = new Trade();
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


        CounterParty client = new CounterParty();
        client.setHolderName("X");
        client.setTrades(setTrades);


        trade.setCounterparty(client);

        bond.setTrades(setTrades);

        bondRepository.save(bond);
        counterPartyRepository.save(client);
        bookRepository.save(book);
        tradeRepository.save(trade);

    }

    @Test
    void getAllBonds() {
        int bondsCount = bondRepository.findAll().size();
        assertThat(bondService.getAllBonds().size()).isEqualTo(bondsCount);
    }

    @Test
    void getMaturityBonds() {
        List<Bond> bonds = bondService.getMaturityBonds(String.valueOf(LocalDate.now()));
        assertEquals(1, bonds.size());
    }

    @Test
    void getBondsInBook() {
        List<Bond> bonds = bondService.getBondsInBook(book);
        assertEquals(1, bonds.size());
    }

    // no usages
//    @Test
//    void getClientBonds() {
//
//    }

    @Test
    void getHolders() {
        List<CounterParty> clients = bondService.getHolders(bond);
        assertEquals(1, clients.size());
    }

    @Test
    void updateStatus() {
        bondService.updateStatus(bond.getIsin());
        Optional<Bond> updatedBond = bondService.findBondByIsin(bond.getIsin());
        assertTrue(updatedBond.isPresent());
        assertEquals(updatedBond.get().getStatus(), "inactive");

    }

    @Test
    void findBondByIsin() {
        assertTrue(bondService.findBondByIsin(bond.getIsin()).isPresent());
    }
}