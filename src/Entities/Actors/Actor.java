package Entities.Actors;

import Entities.Entity;
import Tiles.Tile;
import main_pack.Game;
import main_pack.Handler;

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

    /**
     * the constructor for the Actor class which the player is based off of
     * @param hands the handler var
     * @param x the position in terms of x
     * @param y the position in terms of y
     * @param width the width of the actor
     * @param height the height of the actor
     */
    public Actor(Handler hands, float x, float y, int width, int height) {
        super(hands, x, y, width, height);    //sends to the entity class constructor
        health=DEFAULT_HEALTH;
        speed=DEFAULT_SPEED;
        xMove=0;
        yMove=0;
    }

    /**
     * this is the base for movement where it will check that there is nothing hindering the Actor in the space they are
     * trying to move to
     */
    public void move(){
        if(!checkCollide(xMove, 0f)) {
            moveX();
        }
        if (!checkCollide(0f, yMove))
            moveY();
    }

    /**
     * This is for movement based along the X axis
     * This is how the player moves, it look to see if the collision is false in both top and bottom of the
     * entities bounding box and will either render it at the original space or move it accordingly
     */
    public void moveX(){
        if(xMove>0){
            int tx = (int)(x+xMove+bound.x+bound.width)/Tile.TILEWIDE;
            if(!collision(tx, (int)(y+bound.y)/Tile.TILEHIGH) &&
                    !collision(tx,(int)(y+bound.y +bound.height)/Tile.TILEHIGH)){
                x+=xMove;
            }
        }else if(xMove<0){
            int tx = (int)(x+xMove+bound.x)/Tile.TILEWIDE;
            if(!collision(tx, (int)(y+bound.y)/Tile.TILEHIGH) &&
                    !collision(tx,(int)(y+bound.y +bound.height)/Tile.TILEHIGH)){
                x+=xMove;
            }
        }

    }

    /**
     * This is the movement based on the Y axis
     * This is how the player moves, it look to see if the collision is false in both top and bottom of the
     * entities bounding box and will either render it at the original space or move it accordingly
     */
    public void moveY(){
        if(yMove<0){
            int ty = (int)(y+yMove+bound.y)/Tile.TILEHIGH;
            if(!collision((int)(x+bound.x)/Tile.TILEWIDE, ty) &&
                    !collision((int)(x+bound.x +bound.width)/Tile.TILEWIDE, ty)){
                y+=yMove;
            }
        }else if(yMove>0){
            int ty = (int)(y+yMove+bound.y+bound.height)/Tile.TILEHIGH;
            if(!collision((int)(x+bound.x)/Tile.TILEWIDE, ty) &&
                    !collision((int)(x+bound.x +bound.width)/Tile.TILEWIDE, ty)){
                y+=yMove;
            }
        }
    }

    /**
     * This will help the Actor check if a position is a solid and therefore wont move to said position
     * @param x this is the future tile that it is checking (along x)
     * @param y ditto(along y)
     * @return  ret true or false
     */
    protected boolean collision(int x, int y){
        return hands.getWorld().getTile(x,y).isSolid();
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
