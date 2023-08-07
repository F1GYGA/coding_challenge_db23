package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Bond;
import com.db.grad.javaapi.repository.BondRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
class BondServiceTest {
    @Autowired
    private BondService bondService;
    @Autowired
    private BondRepository bondRepository;

    private Bond bond;

    @BeforeEach
    void setUp() {
//        bond = new Bond("XXX123", "1234abcd", "USD", 2, 900, "UBS Facebook (USD)", "active", "CORP", );


    }

    @Test
    void getAllBonds() {
        int bondsCount = bondRepository.findAll().size();
        assertThat(bondService.getAllBonds().size()).isEqualTo(bondsCount);
    }

    @Test
    void getMaturityBonds() {
    }

    @Test
    void getBondsInBook() {
    }

    @Test
    void getClientBonds() {
    }

    @Test
    void getHolders() {
    }
}