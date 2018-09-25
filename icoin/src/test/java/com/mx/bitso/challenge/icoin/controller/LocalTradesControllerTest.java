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
public class LocalTradesControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void displayLatestTrades() throws Exception {

        this.mockMvc.perform(get("/icoin/trades/local/5/2/2"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.payload").isNotEmpty())
                .andExpect(jsonPath("$.payload[0].maker_side").value("nothing"))
                .andExpect(jsonPath("$.payload[0].amount").value("0"));
    }
}
