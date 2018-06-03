package com.mrvicari.brickselling.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BrickOrder
{
    @Id
    @GeneratedValue
    private Integer reference;

    @JsonProperty("num_of_bricks")
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
