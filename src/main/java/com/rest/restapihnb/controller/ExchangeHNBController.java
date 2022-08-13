package com.rest.restapihnb.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rest.restapihnb.model.ExchangeHNB;
import net.minidev.json.JSONArray;
import net.minidev.json.parser.JSONParser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@RestController
@RequestMapping("/exchangeHNB")
public class ExchangeHNBController {

// port od postgreSQL = 5432

    @GetMapping(value = "/jsonFromHNBApi")
    public JSONArray getJsonFromHNBApi() throws net.minidev.json.parser.ParseException {

        String url = "https://api.hnb.hr/tecajn/v1?valuta=EUR";
        RestTemplate restTemplate = new RestTemplate();
        JSONArray jsonFromHNBApi = restTemplate.getForObject(url, JSONArray.class);

        return jsonFromHNBApi;
    }

    @GetMapping(value = "/getSrednjiTecajFromHNBApi")
    public BigDecimal getSrednjiTecajFromHNBApi() throws Exception {

        BigDecimal srednjiTecaj;

        ExchangeHNB exchangeHNB = getHNBJsonAndFillExchangeHNBObject();
        srednjiTecaj = new BigDecimal( exchangeHNB.getSrednjiZaDevize() );

        return srednjiTecaj;
    }


    @GetMapping(value = "/getHNBJsonAndFillExchangeHNBObject")
    public ExchangeHNB getHNBJsonAndFillExchangeHNBObject() throws Exception {

        ExchangeHNB exchangeHNB;

        JSONArray jsonFromHNBApi = getJsonFromHNBApi();

        JSONParser parser = new JSONParser();
        JSONArray jsonArray= (JSONArray) parser.parse(jsonFromHNBApi.toString());

        ObjectMapper objectMapper = new ObjectMapper();
        exchangeHNB = objectMapper.readValue( jsonArray.get(0).toString(), ExchangeHNB.class);

        System.out.println("Srednji tečaj 4 : " + exchangeHNB.getSrednjiZaDevize());

        exchangeHNB.setKupivniZaDevize(replaceCommaWithPeriod(exchangeHNB.getKupivniZaDevize()));
        exchangeHNB.setProdajniZaDevize(replaceCommaWithPeriod(exchangeHNB.getProdajniZaDevize()));
        exchangeHNB.setSrednjiZaDevize(replaceCommaWithPeriod(exchangeHNB.getSrednjiZaDevize()));

        return exchangeHNB;

    }


    public String replaceCommaWithPeriod(String exchangeRate) throws Exception {

        if (exchangeRate != null) {
            exchangeRate = exchangeRate.replace(",", ".");
        } else {
            throw new Exception("ExchangeRate is null!");
        }

        return exchangeRate;

    }



}
