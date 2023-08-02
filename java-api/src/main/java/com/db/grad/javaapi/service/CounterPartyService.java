package com.db.grad.javaapi.service;

import com.db.grad.javaapi.repository.CounterPartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CounterPartyService {

    @Autowired
    private CounterPartyRepository counterPartyRepo;

}
