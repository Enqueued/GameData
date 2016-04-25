package Entities.Actors;

import graphic_launch.Anime;
import graphic_launch.Assets;
import main_pack.Handler;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * The GuildLeader here is supposed to give the player some quests and give him some help overall
 * too bad he doesnt do that right now.
 * pretty shitty of him huh?
 * Created by Parzival on 4/23/2016.
 */
public class GuildHead extends Actor {
    private boolean initial_Speak=false;
    private Anime animeDown;

    /**
     * This is the constructor for the GuildLeader
     * @param hands
     * @param x
     * @param y
     */
    public GuildHead(Handler hands, float x, float y) {
        super(hands, x, y, Actor.DEFAULT_ACT_WIDE,Actor.DEFAULT_ACT_HIGH);
        bound.x=8;
        bound.y=8;
        bound.width=16;
        bound.height=24;

        animeDown=new Anime(500, Assets.guildhead_down);
    }

    @Override
    public void tick() {
        this.animeDown.tick();
        getInput();

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(getCurrentAnime(),(int)(x-hands.getCam().getxOff()),(int)(y-hands.getCam().getyOff()), width, height, null);
        if(getInput()/*&&(Entity.checkCollide(Emanager.getPlayer().getY(), Emanager.getPlayer().getX()))*/){
            g.drawRect(0, 300, 400, 100);
            g.drawString("Hello there I am a holder image for the real GuildLeader.",20,350);
            g.drawString("He'll be back soon enough", 20, 370);
        }
    }

    /**
     * This will listen to the key listener to check if the enter key has been pressed and if so then it will
     * return true
     * @return
     */
    private boolean getInput() {
        if (hands.getKeys().start)
            return true;
        else
            return false;
    }
    private BufferedImage getCurrentAnime(){
            return animeDown.getCurrentFrame();
    }
}
