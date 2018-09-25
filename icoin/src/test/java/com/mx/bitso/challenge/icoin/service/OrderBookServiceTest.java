package com.mx.bitso.challenge.icoin.service;

import com.mx.bitso.challenge.icoin.model.TradeWrapper;
import org.junit.Assert;
import org.junit.Test;

public class TradesServiceTest {

    @Test
    public void testGetLatestTrades(){
        TradesService tradesService = new TradesService();
        TradeWrapper tradeWrapper = tradesService.getLatestTrades();
        System.out.println(tradeWrapper);
        Assert.assertTrue(tradeWrapper.getPayload() != null);

    }
}
