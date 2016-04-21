package Entities;

import main_pack.Game;
import main_pack.Handler;

import java.awt.*;

/**
 * Created by Parzival on 4/20/2016.
 */
public abstract class Entity {
    protected Handler hands;
    protected float x, y; //set as floats to make calculations easier
    protected int width, height;

    public Entity(Handler hands, float x, float y, int width, int height){
        this.hands=hands;
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
    }

    public abstract void tick();
    public abstract void render(Graphics g);

    //Getters
    public float getX(){
        return x;
    }
    public float getY(){
        return y;
    }
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }
    //Setters
    public void setX(float x){
        this.x=x;
    }
    public void setY(float y){
        this.y=y;
    }
    public void setWidth(int w){
        this.width=w;
    }
    public void setHeight(int h){
        this.height=h;
    }
}
