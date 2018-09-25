package com.mx.bitso.challenge.icoin.service;

import com.mx.bitso.challenge.icoin.model.Trade;
import com.mx.bitso.challenge.icoin.model.TradeWrapper;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class LocalTradesServiceTest {
    int n = 5;
    final static int M = 2;
    final static int N = 2;

    @Test
    public void testGetLatestTrades(){
        LocalTradesService localTradesService = new LocalTradesService();
        TradeWrapper tradeWrapper = localTradesService.getLatestTrades(n, M, N);
        List<Trade> nLatestTrades = tradeWrapper.getPayload();

        Assert.assertTrue(nLatestTrades.size() == 5);
    }

    @Test
    public void testMConsecutiveUpTricks(){
        Trade trade1 = new Trade();
        trade1.setAmount("0.06741869");
        trade1.setMaker_side("buy");
        trade1.setBook("btc_mxn");
        trade1.setCreated_at("2018-09-22T19:46:29+0000");
        trade1.setPrice("118000.00");
        trade1.setTid(1804924L);

        Trade trade2 = new Trade();
        trade2.setAmount("0.06383996");
        trade2.setMaker_side("sell");
        trade2.setBook("btc_mxn");
        trade2.setCreated_at("2018-09-22T18:59:51+0000");
        trade2.setPrice("118000.00");
        trade2.setTid(1804885L);

        Trade trade3 = new Trade();
        trade3.setAmount("0.00123464");
        trade3.setMaker_side("sell");
        trade3.setBook("btc_mxn");
        trade3.setCreated_at("2018-09-22T18:39:28+0000");
        trade3.setPrice("121493.06");
        trade3.setTid(1804865L);

        Trade trade4 = new Trade();
        trade4.setAmount("0.00333200");
        trade4.setMaker_side("sell");
        trade4.setBook("btc_mxn");
        trade4.setCreated_at("2018-09-22T18:25:03+0000");
        trade4.setPrice("121493.06");
        trade4.setTid(1804856L);

        Trade trade5 = new Trade();
        trade5.setAmount("0.02523266");
        trade5.setMaker_side("sell");
        trade5.setBook("btc_mxn");
        trade5.setCreated_at("2018-09-22T18:15:24+0000");
        trade5.setPrice("121628.00");
        trade5.setTid(1804839L);

        List<Trade> trades = new ArrayList<>();
        trades.add(trade1);
        trades.add(trade2);
        trades.add(trade3);
        trades.add(trade4);
        trades.add(trade5);

        LocalTradesService localTradesService = new LocalTradesService();

        List<Trade> localTrades = localTradesService.getNLatestTrades(trades, n, N, M);

        Trade fifthElement = localTrades.stream().skip(4).findFirst().orElse(null);

        Assert.assertTrue(Integer.parseInt(fifthElement.getAmount())==1);
        Assert.assertTrue(fifthElement.getMaker_side().equals("sell"));

    }

    @Test
    public void testNConsecutiveDownTricks(){
        Trade trade1 = new Trade();
        trade1.setAmount("0.06741869");
        trade1.setMaker_side("buy");
        trade1.setBook("btc_mxn");
        trade1.setCreated_at("2018-09-22T19:46:29+0000");
        trade1.setPrice("121628.00");
        trade1.setTid(1804924L);

        Trade trade2 = new Trade();
        trade2.setAmount("0.06383996");
        trade2.setMaker_side("sell");
        trade2.setBook("btc_mxn");
        trade2.setCreated_at("2018-09-22T18:59:51+0000");
        trade2.setPrice("121628.00");
        trade2.setTid(1804885L);

        Trade trade3 = new Trade();
        trade3.setAmount("0.00123464");
        trade3.setMaker_side("sell");
        trade3.setBook("btc_mxn");
        trade3.setCreated_at("2018-09-22T18:39:28+0000");
        trade3.setPrice("121493.06");
        trade3.setTid(1804865L);

        Trade trade4 = new Trade();
        trade4.setAmount("0.00333200");
        trade4.setMaker_side("sell");
        trade4.setBook("btc_mxn");
        trade4.setCreated_at("2018-09-22T18:25:03+0000");
        trade4.setPrice("121493.06");
        trade4.setTid(1804856L);

        Trade trade5 = new Trade();
        trade5.setAmount("0.02523266");
        trade5.setMaker_side("sell");
        trade5.setBook("btc_mxn");
        trade5.setCreated_at("2018-09-22T18:15:24+0000");
        trade5.setPrice("118000.00");
        trade5.setTid(1804839L);

        List<Trade> trades = new ArrayList<>();
        trades.add(trade1);
        trades.add(trade2);
        trades.add(trade3);
        trades.add(trade4);
        trades.add(trade5);

        LocalTradesService localTradesService = new LocalTradesService();

        List<Trade> localTrades = localTradesService.getNLatestTrades(trades, n, N, M);

        Trade fifthElement = localTrades.stream().skip(4).findFirst().orElse(null);

        Assert.assertTrue(Integer.parseInt(fifthElement.getAmount())==1);
        Assert.assertTrue(fifthElement.getMaker_side().equals("buy"));

    }
}
