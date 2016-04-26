package Entities.Actors;

import Classes.Fighter;
import combat_usage.rng;
import graphic_launch.Anime;
import graphic_launch.Assets;
import main_pack.Handler;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by main on 4/25/16.
 */
public class Enemy extends Actor{
    private Anime animeDown;
    //public Fighter myClass = new Fighter();
    //public int steps;

    /**
     * the constructor for the Enemy
     * this will set its bounding box and some animations
     *
     * @param hands
     * @param x
     * @param y
     */
    public Enemy(Handler hands, float x, float y) {
        super(hands, x, y, Actor.DEFAULT_ACT_WIDE, Actor.DEFAULT_ACT_HIGH);
        bound.x = 8;
        bound.y = 8;
        bound.width = 16;
        bound.height = 24;

        animeDown = new Anime(200, Assets.enemy_down);
        this.setHealth(con+rng.rng_maker(500,100));
    }

    @Override
    public void tick() {
        animeDown.tick();
        //hands.getCam().camFocus(this);
    }

    @Override
    public void render(Graphics g) {
        //g.drawImage(getCurrentAnime(), (int) (x - hands.getCam().getxOff()), (int) (y - hands.getCam().getyOff()), width, height, null);
    }

    /**
     * this will return the current animation frame that is being used
     * not the current hit anime like One Punch Man that was amazing and fantastic
     * ONE PUNNNNNNNNNNNCH!!!
     *
     * @return
     */
    private BufferedImage getCurrentAnime() {
        return animeDown.getCurrentFrame();
    }

    int strength = rng.rng_maker(18, 10);
    int dex = rng.rng_maker(14, 6);
    public int con = rng.rng_maker(14, 8);
    int wisdom = rng.rng_maker(18, 6);
    int charm = rng.rng_maker(16, 6);
    int intel = rng.rng_maker(20, 10);

    public int getdamage() {
        return rng.rng_maker(10, 1) + intel;
    }

    public int getdodge() {
        return rng.rng_maker(20,1)+dex;
    }

    public int get_gud() {
        return 0;
    }

    public int get_hit() {
        return rng.rng_maker(20, 1) + (intel-10)/2;
    }
    public int getHealth(){
        return this.health;
    }
}
