package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.*;
import com.db.grad.javaapi.repository.BondRepository;
import com.db.grad.javaapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Math.abs;

@Service
public class BondService {

    @Autowired
    private BondRepository bondRepo;

    @Autowired
    private UserRepository userRepo;

    public List<Bond> getAllBonds() {
        return bondRepo.findAll();
    }

    public List<Bond> getMaturityBonds(String date) {
        List<Bond> result = new ArrayList<>();

        for (Bond bond : getAllBonds()) {
            String maturityDate = String.valueOf(bond.getMaturityDate());

            LocalDate date1 = LocalDate.parse(date);
            LocalDate date2 = LocalDate.parse(maturityDate);

            long daysBetween = abs(date1.toEpochDay() - date2.toEpochDay());
            if (daysBetween <= 5)
                result.add(bond);
        }

        return result;
    }

    public List<Bond> getBondsInBook(Book book) {
        return book.getTrades().stream()
                .map(Trade::getBond)
                .distinct()
                .sorted(Comparator.comparing(Bond::getIsin))
                .collect(Collectors.toList());
    }

    public List<Bond> getClientBonds(CounterParty client) {
        return client.getTrades().stream()
                .map(Trade::getBond)
                .distinct()
                .sorted(Comparator.comparing(Bond::getIsin))
                .collect(Collectors.toList());
    }

    public List<CounterParty> getHolders(Bond bond) {
        return bond.getTrades().stream()
                .map(Trade::getCounterparty)
                .distinct()
                .sorted(Comparator.comparing(CounterParty::getHolderName))
                .collect(Collectors.toList());
    }

}

