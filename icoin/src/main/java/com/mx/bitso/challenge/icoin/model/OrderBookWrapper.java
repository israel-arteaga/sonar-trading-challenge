package com.mx.bitso.challenge.icoin.model;

import java.util.List;

public class OrderBookWrapper {
    private String success;
    private OrderBook payload;

    public OrderBookWrapper() {
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public OrderBook getPayload() {
        return payload;
    }

    public void setPayload(OrderBook payload) {
        this.payload = payload;
    }
}
