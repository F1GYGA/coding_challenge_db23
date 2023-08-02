package com.db.grad.javaapi.service;

import com.db.grad.javaapi.repository.BondRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BondService {

    @Autowired
    private BondRepository bondRepo;

}

