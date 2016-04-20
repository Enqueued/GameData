package states;

import graphic_launch.Assets;

import java.awt.*;

/**
 * Created by main on 4/20/16.
 */
public class GameState extends State {

    public GameState(){

    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.player,0,0,null);
    }
}