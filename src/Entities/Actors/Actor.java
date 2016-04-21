package Entities.Actors;

import Entities.Entity;

/**
 * Created by Parzival on 4/20/2016.
 */
public abstract class Actor extends Entity {
    protected int health;
    protected float speed;
    protected float xMove, yMove;
    public static final int DEFAULT_HEALTH=10;
    public static final float DEFAULT_SPEED=3.0f;
    public static final int DEFAULT_ACT_WIDE=32;
    public static final int DEFAULT_ACT_HIGH=32;

    public Actor(float x, float y, int width, int height) {
        super(x, y, width, height);    //sends to the entity class constructor
        health=DEFAULT_HEALTH;
        speed=DEFAULT_SPEED;
    }
    public void move(){
        x+=xMove;
        y+=yMove;
    }
    //Getters
    public int getHealth(){
        return health;
    }
    public float getSpeed(){
        return speed;
    }
    public float getyMove(){
        return yMove;
    }
    public float getxMove(){
        return xMove;
    }
    //Setters
    public void setHealth(int health){
        this.health=health;
    }
    public void setSpeed(int speed){
        this.speed=speed;
    }
    public void setxMove(int xMove){
        this.xMove=xMove;
    }
    public void setyMove(int yMove){
        this.yMove=yMove;
    }
}
