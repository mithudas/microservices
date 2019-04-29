package com.mithu.microservices.currencyconverterservice;

import java.math.BigDecimal;

public class CurrencyConverterData {
    private String from;
    private String to;
    private Integer quantity;
    private BigDecimal multipicationFactor;
    private BigDecimal totalValue;
    private Long port;

    public CurrencyConverterData() {
    }


    public CurrencyConverterData(String from, String to, Integer quantity, BigDecimal multipicationFactor, BigDecimal totalValue, Long port) {
        this.from = from;
        this.to = to;
        this.quantity = quantity;
        this.multipicationFactor = multipicationFactor;
        this.totalValue = totalValue;
        this.port = port;
    }

    public Long getPort() {
        return port;
    }

    public void setPort(Long port) {
        this.port = port;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getMultipicationFactor() {
        return multipicationFactor;
    }

    public void setMultipicationFactor(BigDecimal multipicationFactor) {
        this.multipicationFactor = multipicationFactor;
    }

    public BigDecimal getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(BigDecimal totalValue) {
        this.totalValue = totalValue;
    }
}
