package com.mx.bitso.challenge.icoin.controller;

import com.mx.bitso.challenge.icoin.model.TradeWrapper;
import com.mx.bitso.challenge.icoin.service.TradesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/icoin")
public class TradesController {

    @Autowired
    TradesService tradesService;

    @RequestMapping(value = "/trades", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public TradeWrapper getLatestTrades() throws Exception {

        return tradesService.getLatestTrades();
    }


}
