package com.db.grad.javaapi.service;

import com.db.grad.javaapi.dto.BondDto;
import com.db.grad.javaapi.model.Bond;
import com.db.grad.javaapi.repository.BondRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

@Service
public class BondService {

    @Autowired
    private BondRepository bondRepo;

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

}
