package com.mx.bitso.challenge.icoin.service;

import com.mx.bitso.challenge.icoin.model.AskBid;
import com.mx.bitso.challenge.icoin.model.OrderBookWrapper;
import com.mx.bitso.challenge.icoin.model.TradeWrapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.validation.constraints.AssertTrue;
import java.util.List;
import java.util.Optional;

public class OrderBookServiceTest {
    OrderBookService orderBookService = new OrderBookService();
    OrderBookWrapper orderBookWrapper = new OrderBookWrapper();
    int n=5;

    @Before
    public void getBestsAsksAndBids(){
        orderBookWrapper = orderBookService.getBestAsksAndBids(n);
        System.out.println(orderBookWrapper);
    }


    @Test
    public void testGetNBestAsks(){
        //ASK Price: The lowest price a would-be seller will accept for a crypto currency.

        List<AskBid> bestAsks = orderBookWrapper.getPayload().getAsks();
        Assert.assertTrue(bestAsks.size() == n);

        AskBid firstElement = bestAsks.stream().findFirst().orElse(null);
        AskBid secondElement = bestAsks.stream().skip(1).findFirst().orElse(null);
        AskBid thirdElement = bestAsks.stream().skip(2).findFirst().orElse(null);
        AskBid fourthElement = bestAsks.stream().skip(3).findFirst().orElse(null);
        AskBid fifthElement = bestAsks.stream().skip(4).findFirst().orElse(null);

        Assert.assertTrue(Double.parseDouble(firstElement.getPrice()) <= Double.parseDouble(secondElement.getPrice()));
        Assert.assertTrue(Double.parseDouble(secondElement.getPrice()) <= Double.parseDouble(thirdElement.getPrice()));
        Assert.assertTrue(Double.parseDouble(thirdElement.getPrice()) <= Double.parseDouble(fourthElement.getPrice()));
        Assert.assertTrue(Double.parseDouble(fourthElement.getPrice()) <= Double.parseDouble(fifthElement.getPrice()));

    }

    @Test
    public void testGetNBestBids(){
        // BID: represents the maximum price that a buyer is willing to pay for a crypto currency

        List<AskBid> bestBids = orderBookWrapper.getPayload().getBids();
        Assert.assertTrue(bestBids.size() == n);


        AskBid firstElement = bestBids.stream().findFirst().orElse(null);
        AskBid secondElement = bestBids.stream().skip(1).findFirst().orElse(null);
        AskBid thirdElement = bestBids.stream().skip(2).findFirst().orElse(null);
        AskBid fourthElement = bestBids.stream().skip(3).findFirst().orElse(null);
        AskBid fifthElement = bestBids.stream().skip(4).findFirst().orElse(null);

        Assert.assertTrue(Double.parseDouble(firstElement.getPrice()) >= Double.parseDouble(secondElement.getPrice()));
        Assert.assertTrue(Double.parseDouble(secondElement.getPrice()) >= Double.parseDouble(thirdElement.getPrice()));
        Assert.assertTrue(Double.parseDouble(thirdElement.getPrice()) >= Double.parseDouble(fourthElement.getPrice()));
        Assert.assertTrue(Double.parseDouble(fourthElement.getPrice()) >= Double.parseDouble(fifthElement.getPrice()));

    }
}
