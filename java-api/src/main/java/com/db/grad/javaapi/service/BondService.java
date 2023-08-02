package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Bond;
import com.db.grad.javaapi.repository.BondRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BondService {

    @Autowired
    private BondRepository bondRepo;

    public List<Bond> getAllBonds() {
        return bondRepo.findAll();
    }

}

