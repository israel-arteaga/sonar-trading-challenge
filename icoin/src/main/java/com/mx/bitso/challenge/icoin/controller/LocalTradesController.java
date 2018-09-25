package com.mx.bitso.challenge.icoin.controller;

import com.mx.bitso.challenge.icoin.model.TradeWrapper;
import com.mx.bitso.challenge.icoin.service.LocalTradesService;
import com.mx.bitso.challenge.icoin.service.TradesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/icoin")
public class LocalTradesController {

    @Autowired
    LocalTradesService tradesService;

    @RequestMapping(value = "/trades/local/{n}/{N}/{M}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public TradeWrapper getLatestTrades(@PathVariable("n") String n, @PathVariable("N") String N, @PathVariable("M") String M) throws Exception {

        return tradesService.getLatestTrades(Integer.parseInt(n), Integer.parseInt(N), Integer.parseInt(M));
    }


}
