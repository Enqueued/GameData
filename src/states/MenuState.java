package states;

import main_pack.Game;
import main_pack.Handler;

import javax.swing.*;
import java.awt.*;

/**
 * Created by main on 4/20/16.
 */
public class MenuState extends State {
    private JButton start;

    public MenuState(Handler hands){
        super(hands);
    }

    @Override
    public void tick() {
        //System.out.println(hands.getMouseManager().getMouseX()+"\t"+hands.getMouseManager().getMouseY());
        if(hands.getMouseManager().isLeftPressed()&&hands.getMouseManager().isRightPressed()){
            StateManager.setState(hands.getGame().gState);
        }

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.blue);
        g.fillRect(hands.getMouseManager().getMouseX(), hands.getMouseManager().getMouseY(),10,10);

    }
}
