package com.mrvicari.brickselling.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BrickOrder
{
    @Id
    @GeneratedValue
    private Integer reference;

    private Integer numOfBricks;

    public BrickOrder()
    {
    }

    public BrickOrder(Integer reference, Integer numOfBricks)
    {
        this.reference = reference;
        this.numOfBricks = numOfBricks;
    }

    public Integer getReference()
    {
        return reference;
    }

    public void setReference(Integer reference)
    {
        this.reference = reference;
    }

    public Integer getNumOfBricks()
    {
        return numOfBricks;
    }

    public void setNumOfBricks(Integer numOfBricks)
    {
        this.numOfBricks = numOfBricks;
    }
}
