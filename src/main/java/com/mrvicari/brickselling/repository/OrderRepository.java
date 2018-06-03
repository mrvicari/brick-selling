package com.mrvicari.brickselling.repository;

import com.mrvicari.brickselling.model.BrickOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<BrickOrder, Integer>
{
}
