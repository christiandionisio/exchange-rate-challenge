package com.example.exchangeratechallenge.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table
public class Exchange {

    @Id
    private Integer id;
    private BigDecimal amount;
    private String originCurrency;
    private String destinyCurrency;
    private BigDecimal exchangeRate;
    private BigDecimal exchangedAmount;
    private LocalDateTime registryDate;
    private String registryUser;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getOriginCurrency() {
        return originCurrency;
    }

    public void setOriginCurrency(String originCurrency) {
        this.originCurrency = originCurrency;
    }

    public String getDestinyCurrency() {
        return destinyCurrency;
    }

    public void setDestinyCurrency(String destinyCurrency) {
        this.destinyCurrency = destinyCurrency;
    }

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public LocalDateTime getRegistryDate() {
        return registryDate;
    }

    public void setRegistryDate(LocalDateTime registryDate) {
        this.registryDate = registryDate;
    }

    public String getRegistryUser() {
        return registryUser;
    }

    public void setRegistryUser(String registryUser) {
        this.registryUser = registryUser;
    }

    public BigDecimal getExchangedAmount() {
        return exchangedAmount;
    }

    public void setExchangedAmount(BigDecimal exchangedAmount) {
        this.exchangedAmount = exchangedAmount;
    }
}
