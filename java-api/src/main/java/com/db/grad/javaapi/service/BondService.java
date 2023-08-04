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

    public List<Bond> getLastDayMaturityBonds() {
        List<Bond> result = new ArrayList<>();

        for (Bond bond : getAllBonds()) {
            String maturityDate = String.valueOf(bond.getMaturityDate());

            LocalDate date1 = LocalDate.now();
            LocalDate date2 = LocalDate.parse(maturityDate);

            if( date1.toEpochDay() == date2.toEpochDay())
                result.add(bond);
        }

        return result;
    }

    public List<Bond> getLast5DaysMaturityBonds() {
        List<Bond> result = new ArrayList<>();

        for (Bond bond : getAllBonds()) {
            String maturityDate = String.valueOf(bond.getMaturityDate());

            LocalDate date1 = LocalDate.now();
            LocalDate date2 = LocalDate.parse(maturityDate);

            long d1 = date1.toEpochDay();
            long d2 = date2.toEpochDay();

            long daysBetween = (d1 >= d2) ? (d1 - d2) : Integer.MAX_VALUE;

            if (daysBetween <= 5)
                result.add(bond);
        }

        return result;
    }

    public List<Bond> getPassedAndActiveBonds() {
        List<Bond> result = new ArrayList<>();

        for (Bond bond : getAllBonds()) {
            String maturityDate = String.valueOf(bond.getMaturityDate());

            LocalDate date1 = LocalDate.now();
            LocalDate date2 = LocalDate.parse(maturityDate);

            long d1 = date1.toEpochDay();
            long d2 = date2.toEpochDay();

            if (d1 > d2 && bond.getStatus().equals("active"))
                result.add(bond);
        }

        return result;
    }

    public List<Bond> getUpdatedBondsAfterRedemption(String isim) {
        List<Bond> result = new ArrayList<>();

        for (Bond bond : getAllBonds()) {
            if (bond.getIsin().equals(isim)) {
                bond.setStatus("inactive");
            }
            result.add(bond);
        }

        return result;
    }


}

