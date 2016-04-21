package graphic_launch;

import Entities.Entity;
import main_pack.Game;

/**
 * Created by Parzival on 4/21/2016.
 */
public class Game_Camera {
    private float yOff;
    private float xOff;
    private Game game;

    public Game_Camera(Game game, float xOff, float yOff){
        this.game= game;
        this.xOff=xOff;
        this.yOff=yOff;
    }

    public void camFocus(Entity e){
        xOff=e.getX()-game.width/2 +e.getWidth()/2;
        yOff=e.getY()-game.height/2 +e.getHeight()/2;
    }

    public void move(float x, float y){
        xOff+=x;
        yOff+=y;
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
