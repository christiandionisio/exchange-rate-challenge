package com.example.exchangeratechallenge.dtos;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

public class ExchangeDto {

    private Integer id;
    @NotEmpty(message = "amount no debe estar vacio")
    private BigDecimal amount;

    @NotEmpty(message = "originCurrency no debe estar vacio")
    private String originCurrency;

    @NotEmpty(message = "destinyCurrency no debe estar vacio")
    private String destinyCurrency;

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
}
