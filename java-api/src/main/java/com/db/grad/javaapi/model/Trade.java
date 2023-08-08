package com.db.grad.javaapi.model;

import com.db.grad.javaapi.enums.BondType;
import com.db.grad.javaapi.enums.TradeStatus;
import com.db.grad.javaapi.enums.TradeType;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "trades")
@EqualsAndHashCode
@ToString
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Bond getBond() {
        return bond;
    }

    public void setBond(Bond bond) {
        this.bond = bond;
    }

    public CounterParty getCounterparty() {
        return counterparty;
    }

    public void setCounterparty(CounterParty counterparty) {
        this.counterparty = counterparty;
    }

    public TradeType getTradeType() {
        return tradeType;
    }

    public void setTradeType(TradeType tradeType) {
        this.tradeType = tradeType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public TradeStatus getTradeStatus() {
        return tradeStatus;
    }

    public void setTradeStatus(TradeStatus tradeStatus) {
        this.tradeStatus = tradeStatus;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Date getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(Date tradeDate) {
        this.tradeDate = tradeDate;
    }

    public Date getTradeSettlementDate() {
        return tradeSettlementDate;
    }

    public void setTradeSettlementDate(Date tradeSettlementDate) {
        this.tradeSettlementDate = tradeSettlementDate;
    }

    @Override
    public String toString() {
        return "Trade{" +
                "id=" + id +
                ", book=" + book.getId() +
                ", bond=" + bond.getIsin() +
                ", counterparty=" + counterparty.getId() +
                ", tradeType=" + tradeType +
                ", quantity=" + quantity +
                ", currency='" + currency + '\'' +
                ", tradeStatus=" + tradeStatus +
                ", unitPrice=" + unitPrice +
                ", tradeDate=" + tradeDate +
                ", tradeSettlementDate=" + tradeSettlementDate +
                '}';
    }
}
