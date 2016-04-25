package states;

import main_pack.Game;
import main_pack.Handler;

import javax.swing.*;
import java.awt.*;

/**
 * Created by main on 4/20/16.
 */
public abstract class State extends JPanel{
    protected Handler hands;
    public State(Handler hands){
        this.hands = hands;
    }
    public abstract void tick();
    public abstract void render(Graphics g);
}
