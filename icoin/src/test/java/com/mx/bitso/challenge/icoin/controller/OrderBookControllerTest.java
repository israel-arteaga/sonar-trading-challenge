package com.mx.bitso.challenge.icoin.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class OrderBookControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void displayNBestAsksAndTrades() throws Exception {

        this.mockMvc.perform(get("/icoin/orderbook/5"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.payload").isNotEmpty())
                .andExpect(jsonPath("$.payload.updated_at").isNotEmpty())
                .andExpect(jsonPath("$.payload.sequence").isNotEmpty())
                .andExpect(jsonPath("$.payload.bids[0].book").value("btc_mxn"))
                .andExpect(jsonPath("$.payload.bids[0].price").isNotEmpty())
                .andExpect(jsonPath("$.payload.bids[0].amount").isNotEmpty())
                .andExpect(jsonPath("$.payload.asks[0].book").value("btc_mxn"))
                .andExpect(jsonPath("$.payload.asks[0].price").isNotEmpty())
                .andExpect(jsonPath("$.payload.asks[0].amount").isNotEmpty());

    }
}
