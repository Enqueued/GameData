package Entities;

import main_pack.Handler;

import java.awt.*;

/**
 * This class is what all other PCs and NPCs are based off of.
 * Basic bounding boxes along with various size vars
 * Created by Parzival on 4/20/2016.
 */
public abstract class Entity {
    protected Handler hands;
    protected float x, y; //set as floats to make calculations easier
    protected int width, height;
    protected Rectangle bound;

    /**
     * The constructor for the Entity class
     * will set the basis up
     * @param hands
     * @param x
     * @param y
     * @param width
     * @param height
     */
    public Entity(Handler hands, float x, float y, int width, int height){
        this.hands=hands;
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        bound = new Rectangle(0,0, width, height);
    }

    public abstract void tick();
    public abstract void render(Graphics g);

    /**
     * This should be used to check the collision between an entity and other entities
     * xoff is the current x position
     * yOff is the current y position
     * @param xOff
     * @param yOff
     * @return
     */
    public boolean checkCollide(float xOff, float yOff){
        for( Entity e : (hands.getWorld().getEntityManager().getEntities())) {
            if(e.equals(this))
                continue;
            if (e.getBound(0f, 0f).intersects(getBound(xOff, yOff)))
               return true;
        }
        return false;
    }

    /**
     * returns the bounds of an entity
     * @param xOff
     * @param yOff
     * @return
     */
    public Rectangle getBound(float xOff, float yOff){
        return new Rectangle((int)(x+bound.x+xOff), (int)(y+bound.y+yOff),bound.width, bound.height);
    }
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
