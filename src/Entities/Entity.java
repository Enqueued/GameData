package Entities;

import java.awt.*;

/**
 * Created by Parzival on 4/20/2016.
 */
public abstract class Entity {
    protected float x, y; //set as floats to make calculations easier

    public Entity(float x, float y){
        this.x=x;
        this.y=y;
    }

    public abstract void tick();
    public abstract void render(Graphics g);
}
