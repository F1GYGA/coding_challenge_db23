package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.CounterParty;
import com.db.grad.javaapi.repository.CounterPartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CounterPartyService {

    @Autowired
    private CounterPartyRepository counterPartyRepo;

    public List<CounterParty> getAllCounterParties() {
        return counterPartyRepo.findAll();
    }

}
