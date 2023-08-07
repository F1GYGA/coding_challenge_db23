package com.db.grad.javaapi.controller;


import com.db.grad.javaapi.dto.BondDto;
import com.db.grad.javaapi.model.Bond;
import com.db.grad.javaapi.model.CounterParty;
import com.db.grad.javaapi.model.Trade;
import com.db.grad.javaapi.service.BondService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class BondController {

    @Autowired
    BondService bondService;

    @GetMapping("/bonds")
    public List<BondDto> getBonds() {
        List<BondDto> list = new ArrayList<>();

        for (Bond bond : bondService.getAllBonds()) {
            List<CounterParty> holders = bond.getTrades().stream().map(Trade::getCounterparty).distinct().collect(Collectors.toList());
            list.add(new BondDto(bond.getIsin(), bond.getCusip(), bond.getBondCurrency(), bond.getCouponPercent(),
                    bond.getFaceValue(), bond.getIssuerName(), bond.getStatus(), bond.getType(), bond.getMaturityDate(), holders));
        }

        return list;
    }


    @GetMapping("/bonds/maturity")
    public List<BondDto> getMaturityBonds(@RequestParam String date) {
        List<BondDto> result = new ArrayList<>();

        for (Bond bond : bondService.getMaturityBonds(date)) {
            List<CounterParty> holders = bond.getTrades().stream().map(Trade::getCounterparty).distinct().collect(Collectors.toList());
            result.add(new BondDto(bond.getIsin(), bond.getCusip(), bond.getBondCurrency(), bond.getCouponPercent(),
                    bond.getFaceValue(), bond.getIssuerName(), bond.getStatus(), bond.getType(), bond.getMaturityDate(), holders));
        }

        return result;
    }

    @GetMapping("/bonds/maturity/lastday")
    public List<BondDto> getLastMaturityBonds() {
        List<BondDto> result = new ArrayList<>();

        for (Bond bond : bondService.getLastDayMaturityBonds()) {
            List<CounterParty> holders = bond.getTrades().stream().map(Trade::getCounterparty).distinct().collect(Collectors.toList());
            result.add(new BondDto(bond.getIsin(), bond.getCusip(), bond.getBondCurrency(), bond.getCouponPercent(),
                    bond.getFaceValue(), bond.getIssuerName(), bond.getStatus(), bond.getType(), bond.getMaturityDate(), holders));
        }

        return result;
    }

    @GetMapping("/bonds/maturity/last5days")
    public List<BondDto> getLast5MaturityBonds() {
        List<BondDto> result = new ArrayList<>();

        for (Bond bond : bondService.getLast5DaysMaturityBonds()) {
            List<CounterParty> holders = bond.getTrades().stream().map(Trade::getCounterparty).distinct().collect(Collectors.toList());
            result.add(new BondDto(bond.getIsin(), bond.getCusip(), bond.getBondCurrency(), bond.getCouponPercent(),
                    bond.getFaceValue(), bond.getIssuerName(), bond.getStatus(), bond.getType(), bond.getMaturityDate(), holders));
        }

        return result;
    }


    @GetMapping("/bonds/maturity/overdue")
    public List<BondDto> getNotRedeemedBonds() {
        List<BondDto> result = new ArrayList<>();

        for (Bond bond : bondService.getPassedAndActiveBonds()) {
            List<CounterParty> holders = bond.getTrades().stream().map(Trade::getCounterparty).distinct().collect(Collectors.toList());
            result.add(new BondDto(bond.getIsin(), bond.getCusip(), bond.getBondCurrency(), bond.getCouponPercent(),
                    bond.getFaceValue(), bond.getIssuerName(), bond.getStatus(), bond.getType(), bond.getMaturityDate(), holders));
        }

        return result;
    }


    @PatchMapping("/bonds/maturity/redeem")
    public void triggerRedeemBond(@RequestParam String isim) {
        bondService.updateStatus(isim);
    }

    @GetMapping("/bonds/maturity/redeemed")
    public List<BondDto> triggerRedeemBond() {
        List<BondDto> result = new ArrayList<>();

        for (Bond bond : bondService.getRedeemedBonds()) {
            List<CounterParty> holders = bond.getTrades().stream().map(Trade::getCounterparty).distinct().collect(Collectors.toList());
            result.add(new BondDto(bond.getIsin(), bond.getCusip(), bond.getBondCurrency(), bond.getCouponPercent(),
                    bond.getFaceValue(), bond.getIssuerName(), bond.getStatus(), bond.getType(), bond.getMaturityDate(), holders));
        }

        return result;
    }


}

