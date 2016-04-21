package Entities.Actors;

import graphic_launch.Assets;
import java.awt.*;

/**
 * Created by Parzival on 4/20/2016.
 */
public class Player extends Actor {

    public Player(float x, float y) {
        super(x, y);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g){
        g.drawImage(Assets.player,(int)x,(int)y,null);
    }
}
