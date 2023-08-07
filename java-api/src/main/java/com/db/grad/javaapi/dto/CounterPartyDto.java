package com.db.grad.javaapi.dto;

import lombok.Data;

import java.util.List;

@Data
public class CounterPartyDto {
    private long id;
    private String holderName;
    private float position;
    private List<BondDto> bonds;

    public CounterPartyDto(long id, String holderName, float position, List<BondDto> bonds) {
        this.id = id;
        this.holderName = holderName;
        this.position = position;
        this.bonds = bonds;
    }
}
