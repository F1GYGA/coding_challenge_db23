package com.db.grad.javaapi.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "counter_parties")
public class CounterParty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "holder_name", nullable = false)
    private String holderName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "counterparty")
    private Set<Trade> trades = new HashSet<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public Set<Trade> getTrades() {
        return trades;
    }

    public void setTrades(Set<Trade> trades) {
        this.trades = trades;
    }

    @Override
    public String toString() {
        return "CounterParty{" +
                "id=" + id +
                ", holderName='" + holderName + '\'' +
                '}';
    }
}
