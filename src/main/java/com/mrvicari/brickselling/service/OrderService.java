package com.mrvicari.brickselling.service;

import com.mrvicari.brickselling.exception.OrderNotFoundException;
import com.mrvicari.brickselling.model.BrickOrder;
import com.mrvicari.brickselling.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService
{
    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository)
    {
        this.orderRepository = orderRepository;
    }

    public BrickOrder createOrder(BrickOrder order)
    {
        orderRepository.save(order);

        return order;
    }

    public BrickOrder getOrder(Integer reference)
    {
        BrickOrder order = orderRepository.findByReference(reference);
        if (order == null)
            throw new OrderNotFoundException();

        return order;
    }

    public List<BrickOrder> getAllOrders()
    {
        return orderRepository.findAll();
    }

    public BrickOrder updateOrder(Integer reference, BrickOrder editedOrder)
    {
        BrickOrder order = orderRepository.findByReference(reference);

        if (order == null)
            throw new OrderNotFoundException();

        order.setNumOfBricks(editedOrder.getNumOfBricks());
        orderRepository.save(order);

        return order;
    }
}
