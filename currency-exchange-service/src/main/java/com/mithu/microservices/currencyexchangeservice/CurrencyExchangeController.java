package com.mithu.microservices.currencyexchangeservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {


    @Autowired
    private ExchangeValueRepository exchangeValueRepository;

    @Autowired
    private Environment environment;


    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeRate(@PathVariable String from, @PathVariable String to) {
        ExchangeValue exchangeValue = exchangeValueRepository.findByFromAndTo(from, to);
        exchangeValue.setPort(Long.parseLong(environment.getProperty("local.server.port")));
        return exchangeValue;
    }

    @RequestMapping("/updateCurrencies")
    public void updateCurrencyExchangeValues() {
        ExchangeValue value = new ExchangeValue(1L, "USD", "INR", BigDecimal.valueOf(75), 0L);
        exchangeValueRepository.save(value);
        value = new ExchangeValue(2L, "ASD", "INR", BigDecimal.valueOf(65), 0L);
        exchangeValueRepository.save(value);
        value = new ExchangeValue(3L, "INR", "BUD", BigDecimal.valueOf(110), 0L);
        exchangeValueRepository.save(value);
    }
}
