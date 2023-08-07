package com.db.grad.javaapi.dto;

import lombok.Data;

import java.util.List;

@Data
public class CounterPartyDto {
    private long id;
    private String holderName;
    private List<BondDto> bonds;

    public CounterPartyDto(long id, String holderName, List<BondDto> bonds) {
        this.id = id;
        this.holderName = holderName;
        this.bonds = bonds;
    }
}
