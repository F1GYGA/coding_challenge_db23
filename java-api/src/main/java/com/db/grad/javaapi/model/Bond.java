package com.db.grad.javaapi.model;

import com.db.grad.javaapi.enums.BondType;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "securities")
public class Bond {

    @Id
    @Column(name = "isin")
    private String isin;

    @Column(name = "cusip")
    private String cusip;

    @Column(name = "bond_currency", nullable = false)
    private String bondCurrency;

    @Column(name = "coupon_percent", nullable = false)
    private float couponPercent;

    @Column(name = "face_value", nullable = false)
    private float faceValue;

    @Column(name = "issuer_name", nullable = false)
    private String issuerName;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private BondType type;

    @Column(name = "bond_maturity_date", nullable = false)
    private Date maturityDate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "bond")
    private Set<Trade> trades = new HashSet<>();
}
