package com.mrvicari.brickselling.repository;

import com.mrvicari.brickselling.model.BrickOrder;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RepositoryTest
{
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    TestEntityManager testEntityManager;

    @After
    public void tearDown()
    {
        orderRepository.deleteAll();
    }

    @Test
    public void saveOrder_findByReference()
    {
        BrickOrder newOrder = testEntityManager.persistAndFlush(new BrickOrder(1, 5));
        BrickOrder foundOrder = orderRepository.findByReference(1);

        assertThat(foundOrder.getReference()).isEqualTo(newOrder.getReference());
        assertThat(foundOrder.getNumOfBricks()).isEqualTo(newOrder.getNumOfBricks());
    }
}
