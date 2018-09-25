package com.mx.bitso.challenge.icoin.service;

import com.mx.bitso.challenge.icoin.model.AskBid;
import com.mx.bitso.challenge.icoin.model.Trade;
import com.mx.bitso.challenge.icoin.model.TradeWrapper;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.List;

public class TradesServiceTest {
    int n = 5;

    @Test
    public void testGetLatestTrades(){
        TradesService tradesService = new TradesService();
        TradeWrapper tradeWrapper = tradesService.getLatestTrades(n);
        List<Trade> nLatestTrades = tradeWrapper.getPayload();

        Trade firstElement = nLatestTrades.stream().findFirst().orElse(null);
        Trade secondElement = nLatestTrades.stream().skip(1).findFirst().orElse(null);
        Trade thirdElement = nLatestTrades.stream().skip(2).findFirst().orElse(null);
        Trade fourthElement = nLatestTrades.stream().skip(3).findFirst().orElse(null);
        Trade fifthElement = nLatestTrades.stream().skip(4).findFirst().orElse(null);

        Assert.assertTrue(nLatestTrades.size() == 5);

        Assert.assertTrue( LocalDateTime.parse(firstElement.getCreated_at().substring(0,19)).isAfter(LocalDateTime.parse(secondElement.getCreated_at().substring(0,19))));
        Assert.assertTrue( LocalDateTime.parse(secondElement.getCreated_at().substring(0,19)).isAfter(LocalDateTime.parse(thirdElement.getCreated_at().substring(0,19))));
        Assert.assertTrue( LocalDateTime.parse(thirdElement.getCreated_at().substring(0,19)).isAfter(LocalDateTime.parse(fourthElement.getCreated_at().substring(0,19))));
        Assert.assertTrue( LocalDateTime.parse(fourthElement.getCreated_at().substring(0,19)).isAfter(LocalDateTime.parse(fifthElement.getCreated_at().substring(0,19))));


    }
}
