package com.mrvicari.brickselling.repository;

import com.mrvicari.brickselling.model.BrickOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<BrickOrder, Integer>
{
    BrickOrder findByReference(Integer reference);

    @Override
    List<BrickOrder> findAll();
}
