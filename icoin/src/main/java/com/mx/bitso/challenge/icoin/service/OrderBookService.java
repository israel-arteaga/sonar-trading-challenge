package com.mx.bitso.challenge.icoin.service;


import com.mx.bitso.challenge.icoin.model.TradeWrapper;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;


@Service
public class TradesService {
    public final static String DEFAULT_ORDER_BOOK = "btc_mxn";
    public final static String DEFAULT_TRADES_URL = "https://api-dev.bitso.com/v3/trades/?book=btc_mxn";

    public TradeWrapper getLatestTrades(){

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent","curl/7.54.0");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

        ResponseEntity<TradeWrapper> response = restTemplate.exchange(DEFAULT_TRADES_URL, HttpMethod.GET,entity,TradeWrapper.class);

        return response.getBody();
    }

}
