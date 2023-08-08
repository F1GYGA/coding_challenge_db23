package com.db.grad.javaapi.controller;


import com.db.grad.javaapi.dto.BondDto;
import com.db.grad.javaapi.model.Bond;
import com.db.grad.javaapi.model.CounterParty;
import com.db.grad.javaapi.service.BondService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


@RestController
@CrossOrigin(origins="http://localhost:3000")
public class BondController {

    @Autowired
    BondService bondService;

    @GetMapping("/bonds")
    public List<BondDto> getBonds() {
        List<BondDto> list = new ArrayList<>();

        for (Bond bond : bondService.getAllBonds()) {
            List<CounterParty> holders = bondService.getHolders(bond);
            list.add(new BondDto(bond.getIsin(), bond.getCusip(), bond.getBondCurrency(), bond.getCouponPercent(),
                    bond.getFaceValue(), bond.getIssuerName(), bond.getStatus(), bond.getType(), bond.getMaturityDate(), holders));
        }

        return list;
    }


    @GetMapping("/bonds/maturity")
    public List<BondDto> getMaturityBonds(@RequestParam String date) {
        List<BondDto> result = new ArrayList<>();

        for (Bond bond : bondService.getMaturityBonds(date)) {
            List<CounterParty> holders = bondService.getHolders(bond);
            result.add(new BondDto(bond.getIsin(), bond.getCusip(), bond.getBondCurrency(), bond.getCouponPercent(),
                    bond.getFaceValue(), bond.getIssuerName(), bond.getStatus(), bond.getType(), bond.getMaturityDate(), holders));
        }

        return result;
    }


    @PatchMapping("/bonds/maturity/redeem")
    public void triggerRedeemBond(@RequestParam String isin) {
        bondService.updateStatus(isin);
    }

}

