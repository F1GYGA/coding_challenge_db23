package com.db.grad.javaapi.dto;


import com.db.grad.javaapi.enums.BondType;
import java.sql.Date;

import lombok.Data;

@Data
public class BondDto {
    private String isin;
    private String cusip;
    private String bondCurrency;
    private float couponPercent;
    private float faceValue;
    private String issuerName;
    private String status;
    private BondType type;
    private Date maturityDate;

    public BondDto(String isin, String cusip, String bondCurrency, float couponPercent, float faceValue,
                   String issuerName, String status, BondType type, Date maturityDate) {
        this.isin = isin;
        this.cusip = cusip;
        this.bondCurrency = bondCurrency;
        this.couponPercent = couponPercent;
        this.faceValue = faceValue;
        this.issuerName = issuerName;
        this.status = status;
        this.type = type;
        this.maturityDate = maturityDate;
    }

    @Override
    public String toString() {
        return "BondDTO{" +
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
