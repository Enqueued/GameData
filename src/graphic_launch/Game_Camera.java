package graphic_launch;

import Entities.Entity;
import Tiles.Tile;
import main_pack.Game;
import main_pack.Handler;

/**
 * Created by Parzival on 4/21/2016.
 */
public class Game_Camera {
    private float yOff;
    private float xOff;
    private Handler handler;

    public Game_Camera(Handler hands, float xOff, float yOff){
        this.handler= hands;
        this.xOff=xOff;
        this.yOff=yOff;
    }

    public void theVoid(){
        if(xOff<0){
            xOff = 0;
        }else if(xOff>handler.getWorld().getWidth() * Tile.TILEWIDE-handler.getWidth()){
            xOff =handler.getWorld().getWidth()* Tile.TILEWIDE-handler.getWidth();
        }
        if(yOff < 0){
            yOff = 0;
        } else if (yOff>handler.getWorld().getHeight() * Tile.TILEHIGH-handler.getHeight()){
            yOff=handler.getWorld().getHeight() * Tile.TILEHIGH-handler.getHeight();
        }
    }

    public void camFocus(Entity e){
        xOff=e.getX()-handler.getWidth()/2 +e.getWidth()/2;
        yOff=e.getY()-handler.getHeight()/2 +e.getHeight()/2;
        theVoid();
    }

    public void move(float x, float y){
        xOff+=x;
        yOff+=y;
        theVoid();
    }

    //getters
    public float getxOff(){
        return xOff;
    }
    public float getyOff(){
        return yOff;
    }
    //setters
    public void setxOff(float x){
        xOff=x;
    }
    public void setyOff(float y){
        yOff=y;
    }
}
