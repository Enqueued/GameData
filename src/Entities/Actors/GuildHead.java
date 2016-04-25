package Entities.Actors;

import Tiles.Tile;
import graphic_launch.Anime;
import graphic_launch.Assets;
import main_pack.Handler;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Parzival on 4/23/2016.
 */
public class GuildHead extends Actor {
    private boolean initial_Speak=false;
    private Anime animeDown;

    public GuildHead(Handler hands, float x, float y) {
        super(hands, x, y, Actor.DEFAULT_ACT_WIDE,Actor.DEFAULT_ACT_HIGH);
        bound.x=8;
        bound.y=8;
        bound.width=16;
        bound.height=24;

        animeDown=new Anime(500, Assets.guildhead_down);
    }

    public boolean isSolid(){
        return true;
    }

    public void tick() {
        this.animeDown.tick();
        getInput();

    }

    public void render(Graphics g) {
        g.drawImage(getCurrentAnime(),(int)(x-hands.getCam().getxOff()),(int)(y-hands.getCam().getyOff()), width, height, null);
        if((checkCollide(hands.getCam().getxOff(), hands.getCam().getyOff()) == true || hands.getKeys().start)){
            g.drawRect(0, 300, 400, 100);
            g.drawString("Hello there I am a holder image\nfor the real GuildLeader.\n He'll be back soon enough",
                    20,350);
        }
    }
    private void getInput() {
        if (hands.getKeys().start){
            System.out.println("I am talking now");
        }

    }
    private BufferedImage getCurrentAnime(){
            return animeDown.getCurrentFrame();
    }
}
