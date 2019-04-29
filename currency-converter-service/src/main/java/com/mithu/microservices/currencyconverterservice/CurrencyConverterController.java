package com.mithu.microservices.currencyconverterservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
@EnableFeignClients("com.mithu.microservices.currencyconverterservice")
public class CurrencyConverterController {

    @Autowired
    private CurrencyExchangeServiceProxy proxy;

    @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConverterData retrieveConvertedAmount(@PathVariable String from, @PathVariable String to, @PathVariable Integer quantity) {

        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("from", from);
        uriVariables.put("to", to);
        ResponseEntity<CurrencyConverterData> response = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConverterData.class, uriVariables);
        return new CurrencyConverterData(from, to, quantity, response.getBody().getMultipicationFactor(), BigDecimal.valueOf(quantity).multiply(response.getBody().getMultipicationFactor()), response.getBody().getPort());

    }


    @GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConverterData retrieveConvertedAmountFeign(@PathVariable String from, @PathVariable String to, @PathVariable Integer quantity) {


        CurrencyConverterData currencyConverterData = proxy.retrieveExchangeRate(from, to);
        currencyConverterData.setQuantity(quantity);
        currencyConverterData.setTotalValue(BigDecimal.valueOf(quantity).multiply(currencyConverterData.getMultipicationFactor()));
        return currencyConverterData;


    }
}
