package com.mrvicari.brickselling.controller;

import com.mrvicari.brickselling.model.BrickOrder;
import com.mrvicari.brickselling.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    public Map<String, Integer> createOrder(@RequestBody BrickOrder newOrder)
    {
        BrickOrder createdOrder = orderService.createOrder(newOrder);

        Map<String, Integer> orderMap = new HashMap<>();
        orderMap.put("reference", createdOrder.getReference());

        return orderMap;
    }
}
