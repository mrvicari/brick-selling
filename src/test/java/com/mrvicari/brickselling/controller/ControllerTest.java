package com.mrvicari.brickselling.controller;

import com.mrvicari.brickselling.model.BrickOrder;
import com.mrvicari.brickselling.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class ControllerTest
{
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderService orderService;

    @Test
    public void createOrder_returnReference() throws Exception
    {
        BrickOrder order = new BrickOrder(1, 5);

        when(orderService.createOrder(any())).thenReturn(order);

        mockMvc.perform(post("/api/order")
        .contentType(MediaType.APPLICATION_JSON_UTF8)
        .content("{\"num_of_bricks\": 5}"))
                .andExpect(status().isCreated())
                .andExpect(content().json("{\"reference\": 1}"));
    }
}
