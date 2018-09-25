package com.mx.bitso.challenge.icoin.model;

import java.util.List;

public class OrderBook {
    public String updated_at;
    public List<AskBid> bids;
    public List<AskBid> asks;
    public String sequence;

    public OrderBook() {
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public List<AskBid> getBids() {
        return bids;
    }

    public void setBids(List<AskBid> bids) {
        this.bids = bids;
    }

    public List<AskBid> getAsks() {
        return asks;
    }

    public void setAsks(List<AskBid> asks) {
        this.asks = asks;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }
}
