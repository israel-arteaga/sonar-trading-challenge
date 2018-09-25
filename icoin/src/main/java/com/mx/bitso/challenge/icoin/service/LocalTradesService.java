package com.mx.bitso.challenge.icoin.service;


import com.mx.bitso.challenge.icoin.model.AskBid;
import com.mx.bitso.challenge.icoin.model.OrderBookWrapper;
import com.mx.bitso.challenge.icoin.model.Trade;
import com.mx.bitso.challenge.icoin.model.TradeWrapper;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class TradesService {
    public final static String DEFAULT_TRADES_URL = "https://api-dev.bitso.com/v3/trades/?book=btc_mxn";

    public TradeWrapper getLatestTrades(int n){

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent","curl/7.54.0");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

        ResponseEntity<TradeWrapper> response = restTemplate.exchange(DEFAULT_TRADES_URL, HttpMethod.GET,entity,TradeWrapper.class);

        TradeWrapper tradeWrapper = response.getBody();

        tradeWrapper.setPayload(getNLatestTrades(tradeWrapper.getPayload(), n));

        return response.getBody();
    }

    private List<Trade> getNLatestTrades( List<Trade> trades, int n) {

        trades.stream().sorted(Comparator.comparing(Trade::getCreated_at).reversed()).collect(Collectors.toList());

        return trades.stream().limit(n).collect(Collectors.toList());
    }

}
