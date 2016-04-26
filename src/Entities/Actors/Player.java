package Entities.Actors;

import Classes.Cleric;
import Classes.Fighter;
import Classes.Mage;
import Classes.Rouge;
import combat_usage.rng;
import graphic_launch.Anime;
import graphic_launch.Assets;
import main_pack.Game;
import main_pack.Handler;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * This is used to set all current stuff in the player
 * Created by Parzival on 4/20/2016.
 */
public class Player extends Actor {
    private Anime animeDown, animeUp, animeLeft, animeRight;
    public Fighter myClass = new Fighter();
    public int steps;

    /**
     * the constructor for the player
     * this will set its bounding box and some animations
     *
     * @param hands
     * @param x
     * @param y
     */
    public Player(Handler hands, float x, float y) {
        super(hands, x, y, Actor.DEFAULT_ACT_WIDE, Actor.DEFAULT_ACT_HIGH);
        bound.x = 8;
        bound.y = 8;
        bound.width = 16;
        bound.height = 24;

        animeDown = new Anime(500, Assets.player_down);
        animeUp = new Anime(500, Assets.player_up);
        animeLeft = new Anime(500, Assets.player_left);
        animeRight = new Anime(500, Assets.player_right);
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

    /**
     * will set up the keys to do certain things
     * like movement for example
     */
    private void getInput() {
        xMove = 0;
        yMove = 0;
        if (hands.getKeys().n) {
            yMove = -speed;
            steps++;
        }
        if (hands.getKeys().s) {
            yMove = speed;
            steps++;
        }
        if (hands.getKeys().w) {
            xMove = -speed;
            steps++;
        }
        if (hands.getKeys().e) {
            xMove = speed;
            steps++;
        }

        System.out.println("Steps " + steps);
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(getCurrentAnime(), (int) (x - hands.getCam().getxOff()), (int) (y - hands.getCam().getyOff()), width, height, null);
        //g.setColor(Color.black);
        // g.fillRect((int)(x+bound.x-hands.getCam().getxOff()),
        //(int)(y+bound.y-hands.getCam().getyOff()), bound.width, bound.height);
    }

    /**
     * this will return the current animation frame that is being used
     * not the current hit anime like One Punch Man that was amazing and fantastic
     * ONE PUNNNNNNNNNNNCH!!!
     *
     * @return
     */
    private BufferedImage getCurrentAnime() {
        if (xMove < 0) {
            return animeLeft.getCurrentFrame();
        } else if (xMove > 0) {
            return animeRight.getCurrentFrame();
        } else if (yMove < 0) {
            return animeUp.getCurrentFrame();
        } else {
            return animeDown.getCurrentFrame();
        }
    }

    int strength = rng.rng_maker(18, 10);
    int dex = rng.rng_maker(14, 6);
    int con = rng.rng_maker(14, 8);
    int wisdom = rng.rng_maker(18, 6);
    int charm = rng.rng_maker(16, 6);
    int intel = rng.rng_maker(20, 10);
    /*public void setClass(String s){
        if(s.equals("fighter")){
            myClass = Fighter;
        }else if(s.equals("mage")){
            myClass= Mage;
        }else if(s.equals("cleric")){
            myClass= Cleric;
        }else if(s.equals("rouge")){
            myClass= Rouge;
        }else{
            myClass=Fighter;
        }
    }*/

    public int getdamage() {
        return rng.rng_maker(12, 1) + strength;
    }

    public int getdodge() {
        return 17;
    }

    public int get_gud() {
        return 0;
    }

    public int get_hit() {
        return rng.rng_maker(20, 1) + (strength-10)/2;
    }
}