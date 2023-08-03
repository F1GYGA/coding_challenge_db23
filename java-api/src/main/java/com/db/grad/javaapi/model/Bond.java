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

    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }

    public String getCusip() {
        return cusip;
    }

    public void setCusip(String cusip) {
        this.cusip = cusip;
    }

    public String getBondCurrency() {
        return bondCurrency;
    }

    public void setBondCurrency(String bondCurrency) {
        this.bondCurrency = bondCurrency;
    }

    public float getCouponPercent() {
        return couponPercent;
    }

    public void setCouponPercent(float couponPercent) {
        this.couponPercent = couponPercent;
    }

    public float getFaceValue() {
        return faceValue;
    }

    public void setFaceValue(float faceValue) {
        this.faceValue = faceValue;
    }

    public String getIssuerName() {
        return issuerName;
    }

    public void setIssuerName(String issuerName) {
        this.issuerName = issuerName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BondType getType() {
        return type;
    }

    public void setType(BondType type) {
        this.type = type;
    }

    public Date getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(Date maturityDate) {
        this.maturityDate = maturityDate;
    }

    public Set<Trade> getTrades() {
        return trades;
    }

    public void setTrades(Set<Trade> trades) {
        this.trades = trades;
    }

    @Override
    public String toString() {
        return "Bond{" +
                "isin='" + isin + '\'' +
                ", cusip='" + cusip + '\'' +
                ", bondCurrency='" + bondCurrency + '\'' +
                ", couponPercent=" + couponPercent +
                ", faceValue=" + faceValue +
                ", issuerName='" + issuerName + '\'' +
                ", status='" + status + '\'' +
                ", type=" + type +
                ", maturityDate=" + maturityDate +
                '}';
    }
}
