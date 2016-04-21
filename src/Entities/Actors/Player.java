package Entities.Actors;

import graphic_launch.Assets;
import main_pack.Game;
import main_pack.Handler;

import java.awt.*;

/**
 * Created by Parzival on 4/20/2016.
 */
public class Player extends Actor {
    public Player(Handler hands, float x, float y) {
        super(hands, x, y, Actor.DEFAULT_ACT_WIDE,Actor.DEFAULT_ACT_HIGH);
    }

    @Override
    public void tick() {
        getInput();
        move();
        hands.getCam().camFocus(this);
    }

    private void getInput(){
        xMove=0;
        yMove=0;
        if(hands.getKeys().n){
            yMove = -speed;
        }
        if(hands.getKeys().s){
            yMove = speed;
        }
        if(hands.getKeys().w){
            xMove = -speed;
        }
        if(hands.getKeys().e){
            xMove = speed;
        }
    }

    @Override
    public void render(Graphics g){
        g.drawImage(Assets.player,(int)(x-hands.getCam().getxOff()),(int)(y-hands.getCam().getyOff()), width, height, null);
    }
}
