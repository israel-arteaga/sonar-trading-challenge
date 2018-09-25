package com.mx.bitso.challenge.icoin.controller;

import com.mx.bitso.challenge.icoin.model.OrderBookWrapper;
import com.mx.bitso.challenge.icoin.service.OrderBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/icoin")
public class OrderBookController {

    @Autowired
    OrderBookService orderBookService;

    @RequestMapping(value = "/orderbook/{n}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public OrderBookWrapper getNBestAsksAndBids(@PathVariable("n") String n) throws Exception {

        return orderBookService.getBestAsksAndBids(Integer.valueOf(n));
    }


}
