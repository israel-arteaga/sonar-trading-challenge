package com.mx.bitso.challenge.icoin.model;

import java.util.List;

public class TradeWrapper {
    private String success;
    private List<Trade> payload;

    public TradeWrapper() {
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public List<Trade> getPayload() {
        return payload;
    }

    public void setPayload(List<Trade> payload) {
        this.payload = payload;
    }
}
