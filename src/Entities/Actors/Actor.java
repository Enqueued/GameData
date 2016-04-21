package Entities.Actors;

import Entities.Entity;

/**
 * Created by Parzival on 4/20/2016.
 */
public abstract class Actor extends Entity {
    protected int health;
    public Actor(float x, float y) {
        super(x, y);    //sends to the entity class constructor
        health=10;
    }
}
