package Entities.Actors;

import graphic_launch.Anime;
import graphic_launch.Assets;
import main_pack.Game;
import main_pack.Handler;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Parzival on 4/20/2016.
 */
public class Player extends Actor {
    private Anime animeDown, animeUp, animeLeft, animeRight;

    public Player(Handler hands, float x, float y) {
        super(hands, x, y, Actor.DEFAULT_ACT_WIDE,Actor.DEFAULT_ACT_HIGH);
        bound.x=8;
        bound.y=8;
        bound.width=16;
        bound.height=24;

        animeDown=new Anime (500, Assets.player_down);
        animeUp=new Anime (500, Assets.player_up);
        animeLeft=new Anime (500, Assets.player_left);
        animeRight=new Anime (500, Assets.player_right);
    }

    @Override
    public void tick() {
        animeDown.tick();
        animeUp.tick();
        animeLeft.tick();
        animeRight.tick();
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
        g.drawImage(getCurrentAnime(),(int)(x-hands.getCam().getxOff()),(int)(y-hands.getCam().getyOff()), width, height, null);
        //g.setColor(Color.black);
       // g.fillRect((int)(x+bound.x-hands.getCam().getxOff()),
                //(int)(y+bound.y-hands.getCam().getyOff()), bound.width, bound.height);
    }
    private BufferedImage getCurrentAnime(){
        if(xMove<0){
            return animeLeft.getCurrentFrame();
        }else if(xMove>0){
            return animeRight.getCurrentFrame();
        }else if(yMove<0) {
            return animeUp.getCurrentFrame();
        }else{
            return animeDown.getCurrentFrame();
        }
    }
}
