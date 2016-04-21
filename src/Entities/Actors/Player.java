package Entities.Actors;

import graphic_launch.Assets;
import main_pack.Game;

import java.awt.*;

/**
 * Created by Parzival on 4/20/2016.
 */
public class Player extends Actor {
    private Game game;
    public Player(Game game, float x, float y) {
        super(x, y, Actor.DEFAULT_ACT_WIDE,Actor.DEFAULT_ACT_HIGH);
        this.game=game;
    }

    @Override
    public void tick() {
        getInput();
        move();
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
        g.drawImage(Assets.player,(int)x,(int)y, width, height, null);
    }
}
