package com.db.grad.javaapi.model;

import com.db.grad.javaapi.enums.BondType;
import com.db.grad.javaapi.enums.TradeStatus;
import com.db.grad.javaapi.enums.TradeType;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "trades")
public class Trade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "security_id", referencedColumnName = "isin")
    private Bond bond;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "counterparty_id", referencedColumnName = "id")
    private CounterParty counterparty;


    @Column(name = "trade_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private TradeType tradeType;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "trade_currency", nullable = false)
    private String currency;

    @Column(name = "trade_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private TradeStatus tradeStatus;

    @Column(name = "unit_price", nullable = false)
    private float unitPrice;

    @Column(name = "trade_date", nullable = false)
    private Date tradeDate;

    @Column(name = "trade_settlement_date", nullable = false)
    private Date tradeSettlementDate;
}
