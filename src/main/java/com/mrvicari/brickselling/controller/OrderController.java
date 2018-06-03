package com.mrvicari.brickselling.controller;

import com.mrvicari.brickselling.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class OrderController
{
    private OrderService orderService;

    public OrderController(OrderService orderService)
    {
        this.orderService = orderService;
    }

    @PostMapping("/order")
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, Integer> createOrder()
    {
        // Call service to create order

        Map<String, Integer> orderMap = new HashMap<>();
        orderMap.put("reference", 1);

        return orderMap;
    }
}
