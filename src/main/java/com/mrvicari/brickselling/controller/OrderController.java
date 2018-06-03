package com.mrvicari.brickselling.controller;

import com.mrvicari.brickselling.exception.OrderNotFoundException;
import com.mrvicari.brickselling.model.BrickOrder;
import com.mrvicari.brickselling.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
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

    @GetMapping("/order/{reference}")
    public BrickOrder getOrder(@PathVariable Integer reference)
    {
        return orderService.getOrder(reference);
    }

    @GetMapping("/order")
    public List<BrickOrder> getAllOrders()
    {
        return orderService.getAllOrders();
    }

    @PutMapping("/order/{reference}")
    public Map<String, Integer> updateOrder(@PathVariable Integer reference, @RequestBody BrickOrder editedOrder)
    {
        BrickOrder order = orderService.updateOrder(reference, editedOrder);

        Map<String, Integer> orderMap = new HashMap<>();
        orderMap.put("reference", order.getReference());

        return orderMap;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void orderNotFoundHandler(OrderNotFoundException ex)
    {
    }
}
