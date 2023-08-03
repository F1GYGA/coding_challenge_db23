package com.db.grad.javaapi.dto;

import com.db.grad.javaapi.enums.TradeStatus;
import com.db.grad.javaapi.enums.TradeType;
import lombok.Data;

import java.sql.Date;

@Data
public class TradeDto {
    private long id;
    private TradeType tradeType;
    private int quantity;
    private String currency;
    private TradeStatus tradeStatus;
    private float unitPrice;
    private Date tradeDate;
    private Date tradeSettlementDate;

    public TradeDto(long id, TradeType tradeType, int quantity, String currency,
                    TradeStatus tradeStatus, float unitPrice, Date tradeDate, Date tradeSettlementDate) {
        this.id = id;
        this.tradeType = tradeType;
        this.quantity = quantity;
        this.currency = currency;
        this.tradeStatus = tradeStatus;
        this.unitPrice = unitPrice;
        this.tradeDate = tradeDate;
        this.tradeSettlementDate = tradeSettlementDate;
    }
}
