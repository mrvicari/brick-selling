package com.mrvicari.brickselling.service;

import com.mrvicari.brickselling.model.BrickOrder;
import com.mrvicari.brickselling.repository.OrderRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ServiceTest
{
    private static BrickOrder TEST_ORDER;
    private static final Integer NUM_OF_BRICKS = 5;

    @Mock
    private OrderRepository orderRepository;

    private OrderService orderService;

    @Before
    public void setup()
    {
        orderService = new OrderService(orderRepository);

        TEST_ORDER = new BrickOrder(1, 5);
    }

    @Test
    public void createOrder_searchDb_returnOrder()
    {
        when(orderRepository.save(any())).thenReturn(TEST_ORDER);

        BrickOrder newOrder = orderService.createOrder(new BrickOrder(1, NUM_OF_BRICKS));

        assertThat(newOrder.getNumOfBricks()).isEqualTo(NUM_OF_BRICKS);
    }
}
