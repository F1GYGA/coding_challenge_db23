package com.db.grad.javaapi.dto;

import lombok.Data;

@Data
public class CounterPartyDto {
    private long id;
    private String holderName;

    public CounterPartyDto(long id, String holderName) {
        this.id = id;
        this.holderName = holderName;
    }
}
