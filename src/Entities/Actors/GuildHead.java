package Entities.Actors;

import Tiles.Tile;
import graphic_launch.Anime;
import graphic_launch.Assets;
import main_pack.Handler;
import states.GameState;

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
    private Tile tile;

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

    /**
     * need to make the text have bounds to check if its a solid and shiz
     * may want to just draw a bunch of stone blocks, shove text on there then the character cant walk there!
     * @param g
     */
    @Override
    public void render(Graphics g) {
        g.drawImage(getCurrentAnime(),(int)(x-hands.getCam().getxOff()),(int)(y-hands.getCam().getyOff()), width, height, null);
        if(getInput()/*&&(Entity.checkCollide(Emanager.getPlayer().getY(), Emanager.getPlayer().getX()))*/){
            /*for(int i=0; i<400; i++){
                tile = new Tile(Assets.tree,2);
                tile.render(g, i, 300);
            }*/
            g.setColor(Color.black);
            g.fillRect(0, 300, 400, 100);

            g.setColor(Color.cyan);
            g.drawString("Hello there I am a holder image for the real GuildLeader.",20,350);
            g.drawString("He'll be back soon enough", 20, 370);
            hands.getGame().gState = new GameState(hands, GameState.getRoom(2));
            hands.getGame();
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
