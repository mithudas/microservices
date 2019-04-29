package com.mithu.microservices.currencyexchangeservice;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;


@Entity
public class ExchangeValue {

    @Id
    private Long id;
    @Column(name = "currency_from")
    private String from;
    @Column(name = "currency_to")

    private String to;
    @Column(name = "currency_value")
    private BigDecimal multipicationFactor;
    private Long port;

    public ExchangeValue() {
    }

    public ExchangeValue(Long id, String from, String to, BigDecimal multipicationFactor, Long port) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.multipicationFactor = multipicationFactor;
        this.port = port;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public BigDecimal getMultipicationFactor() {
        return multipicationFactor;
    }

    public void setMultipicationFactor(BigDecimal multipicationFactor) {
        this.multipicationFactor = multipicationFactor;
    }

    public Long getPort() {
        return port;
    }

    public void setPort(Long port) {
        this.port = port;
    }
}
