package com.mrvicari.brickselling.service;

import com.mrvicari.brickselling.exception.OrderNotFoundException;
import com.mrvicari.brickselling.model.BrickOrder;
import com.mrvicari.brickselling.repository.OrderRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
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

    @Test
    public void getOrder_returnDetails()
    {
        when(orderRepository.findByReference(anyInt())).thenReturn(TEST_ORDER);

        BrickOrder order = orderService.getOrder(anyInt());

        assertThat(order.getNumOfBricks()).isEqualTo(NUM_OF_BRICKS);
    }

    @Test(expected = OrderNotFoundException.class)
    public void getOrder_invalidReference()
    {
        when(orderRepository.findByReference(anyInt())).thenReturn(null);

        orderService.getOrder(anyInt());
    }

    @Test
    public void getAllOrders_returnList()
    {
        BrickOrder order1 = new BrickOrder(1, 5);
        BrickOrder order2 = new BrickOrder(2, 10);

        when(orderRepository.findAll()).thenReturn(Arrays.asList(order1, order2));

        List<BrickOrder> allOrders = orderService.getAllOrders();

        assertThat(allOrders.size()).isEqualTo(2);
        assertThat(allOrders.get(0)).isEqualTo(order1);
        assertThat(allOrders.get(1)).isEqualTo(order2);
    }

    @Test
    public void updateOrder_searchDb_returnReference()
    {
        when(orderRepository.findByReference(anyInt())).thenReturn(new BrickOrder(1, 5));

        BrickOrder editedOrder = new BrickOrder(null,10);

        BrickOrder updatedOrder = orderService.updateOrder(1, editedOrder);

        assertThat(updatedOrder.getReference()).isEqualTo(1);
        assertThat(updatedOrder.getNumOfBricks()).isEqualTo(editedOrder.getNumOfBricks());
    }
}
