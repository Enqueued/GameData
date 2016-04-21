package states;

import main_pack.Game;

import java.awt.*;

/**
 * Created by main on 4/20/16.
 */
public abstract class State {
    protected Game game;

    public State(Game game){
        this.game=game;
    }
    public abstract void tick();
    public abstract void render(Graphics g);
}
