package com.example.exchangeratechallenge.dtos;

import java.math.BigDecimal;

public class ExchangeRateConfigDto {

    private Integer id;
    private String originCurrency;
    private String destinyCurrency;
    private BigDecimal exchangeRate;
    private String registryUser;
    private String modificationUser;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
    public String getRegistryUser() {
        return registryUser;
    }

    public void setRegistryUser(String registryUser) {
        this.registryUser = registryUser;
    }

    public String getModificationUser() {
        return modificationUser;
    }

    public void setModificationUser(String modificationUser) {
        this.modificationUser = modificationUser;
    }
}
