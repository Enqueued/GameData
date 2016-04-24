package states;

import main_pack.Game;
import main_pack.Handler;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by main on 4/20/16.
 */
public abstract class State implements ActionListener {
    protected Handler hands;
    public State(Handler hands){
        this.hands = hands;
    }
    public abstract void tick();
    public abstract void render(Graphics g);
    public void actionPerformed (ActionEvent e){

    }
}
