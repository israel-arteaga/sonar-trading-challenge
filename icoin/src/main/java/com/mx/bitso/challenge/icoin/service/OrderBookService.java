package com.mx.bitso.challenge.icoin.service;

import com.mx.bitso.challenge.icoin.model.AskBid;
import com.mx.bitso.challenge.icoin.model.OrderBookWrapper;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class OrderBookService {
    public final static String DEFAULT_ORDER_BOOK_URL = "https://api-dev.bitso.com/v3/order_book/?book=btc_mxn";


    public OrderBookWrapper getBestAsksAndBids(int n){

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent","curl/7.54.0");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

        ResponseEntity<OrderBookWrapper> response = restTemplate.exchange(DEFAULT_ORDER_BOOK_URL, HttpMethod.GET,entity,OrderBookWrapper.class);
        OrderBookWrapper orderBookWrapper = response.getBody();

        orderBookWrapper.getPayload().setAsks(getBestAsks(n,orderBookWrapper.getPayload().getAsks()));
        orderBookWrapper.getPayload().setBids(getBestBids(n,orderBookWrapper.getPayload().getBids()));

        return orderBookWrapper;
    }

    private List<AskBid> getBestAsks(int n, List<AskBid>  asks) {

        // ASK: The lowest price a seller will accept for a crypto currency.
        asks.stream().sorted(Comparator.comparing(AskBid::getPrice)).collect(Collectors.toList());

        return asks.stream().limit(n).collect(Collectors.toList());
    }

    private List<AskBid> getBestBids(int n, List<AskBid> bids) {

        // BID: represents the maximum price that a buyer is willing to pay for a crypto currency
        bids.stream().sorted(Comparator.comparing(AskBid::getPrice).reversed()).collect(Collectors.toList());

        return bids.stream().limit(n).collect(Collectors.toList());
    }
}
