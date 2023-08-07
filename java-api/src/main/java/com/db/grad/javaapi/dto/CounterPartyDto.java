package com.db.grad.javaapi.dto;

import com.db.grad.javaapi.model.Trade;
import lombok.Data;

import java.util.List;

@Data
public class CounterPartyDto {
    private long id;
    private String holderName;
    private double position;
    private List<TradeDto> bonds;

    public CounterPartyDto(long id, String holderName, double position, List<TradeDto> bonds) {
        this.id = id;
        this.holderName = holderName;
        this.position = position;
        this.bonds = bonds;
    }
}
