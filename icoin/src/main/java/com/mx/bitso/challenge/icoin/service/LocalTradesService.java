package com.mx.bitso.challenge.icoin.service;


import com.mx.bitso.challenge.icoin.model.Trade;
import com.mx.bitso.challenge.icoin.model.TradeWrapper;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;


@Service
public class LocalTradesService {
    public final static String DEFAULT_TRADES_URL = "https://api-dev.bitso.com/v3/trades/?book=btc_mxn";
    //public final static int N = 2;
    //public final static int M = 2;

    public TradeWrapper getLatestTrades(int n, int N, int M) {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent","curl/7.54.0");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

        ResponseEntity<TradeWrapper> response = restTemplate.exchange(DEFAULT_TRADES_URL, HttpMethod.GET,entity,TradeWrapper.class);

        TradeWrapper tradeWrapper = response.getBody();

        tradeWrapper.setPayload(getNLatestTrades(tradeWrapper.getPayload(), n, N, M));

        return response.getBody();
    }

    public List<Trade> getNLatestTrades( List<Trade> trades, int n, int N, int M) {
        AtomicInteger counterUpTricks = new AtomicInteger(0);
        AtomicInteger counterDownTricks = new AtomicInteger();
        Stack<Trade> zeroTricks = new Stack<>();
        final Trade[] previousTrade = {null};

        trades.stream().forEach(trade -> {

            System.out.println(trade);
            //reset trade values
            trade.setMaker_side("nothing");
            trade.setAmount("0");

            if(previousTrade[0] !=null){
                System.out.println("next trade.."+ previousTrade[0].getTid());
                Double tradePrice = Double.parseDouble(trade.getPrice());
                Double secondPrice = Double.parseDouble(previousTrade[0].getPrice());
                if( tradePrice.doubleValue() == secondPrice.doubleValue()){
                    zeroTricks.push(trade);
                }

                if(!zeroTricks.empty()){
                    Double mostRecentZeroTrick = Double.parseDouble(zeroTricks.peek().getPrice());
                    if(tradePrice.doubleValue() > mostRecentZeroTrick.doubleValue()){
                        int mConsecutiveUpTricks = counterUpTricks.incrementAndGet();
                        if(mConsecutiveUpTricks == M){
                            trade.setAmount("1");
                            trade.setMaker_side("sell");
                        }
                    }else{
                        if(tradePrice.doubleValue() < mostRecentZeroTrick.doubleValue()){
                            int nConsecutiveDownTricks = counterDownTricks.incrementAndGet();
                            if(nConsecutiveDownTricks == N){
                                trade.setAmount("1");
                                trade.setMaker_side("buy");
                            }
                        }
                    }
                }
            }
            previousTrade[0] = trade;
        });
        return trades.stream().limit(n).collect(Collectors.toList());
    }

}
