package Entities.Actors;

import graphic_launch.Assets;
import main_pack.Game;

import java.awt.*;

/**
 * Created by Parzival on 4/20/2016.
 */
public class Player extends Actor {
    public Player(Game game, float x, float y) {
        super(game, x, y, Actor.DEFAULT_ACT_WIDE,Actor.DEFAULT_ACT_HIGH);
    }

    @Override
    public void tick() {
        getInput();
        move();
        game.getCam().camFocus(this);
    }

    private void getInput(){
        xMove=0;
        yMove=0;
        if(game.getKeyManager().n){
            yMove = -speed;
        }
        if(game.getKeyManager().s){
            yMove = speed;
        }
        if(game.getKeyManager().w){
            xMove = -speed;
        }
        if(game.getKeyManager().e){
            xMove = speed;
        }
    }

    @Override
    public void render(Graphics g){
        g.drawImage(Assets.player,(int)(x-game.getCam().getxOff()),(int)(y-game.getCam().getyOff()), width, height, null);
    }
}
