package states;

import main_pack.Display;
import main_pack.Game;
import main_pack.Handler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * This WILL be the main menu leading into the game
 * just need to figure out how to do that
 * Created by Parzival on 4/20/16.
 */
public class MenuState extends State implements ActionListener{
    private JButton butt;
    /**
     * This is the constructor for the main menu
     * @param hands
     */
    public MenuState(Handler hands) {
        super(hands);
    }

    @Override
    public void tick() {
        //System.out.println(hands.getMouseManager().getMouseX()+"\t"+hands.getMouseManager().getMouseY());
        if(hands.getMouseManager().isLeftPressed()/*&&hands.getMouseManager().isRightPressed()*/){
            StateManager.setState(hands.getGame().gState);
        }

    }

    /**
     * need to fix the button and make it ACTUALLY a button
     * @param g
     */
    @Override
    public void render(Graphics g) {
        /*butt=new JButton("Goto Game!");
        hands.getGame().dis.getFrame().add(butt);*/
        g.setColor(Color.BLACK);
        g.fillRect(0, 0,hands.getWidth(),hands.getHeight());
        g.setColor(Color.white);
        g.drawString("The Great Grind!", 150, 120);
        g.setColor(Color.cyan);
        g.drawString("This will make you go to the game!", 100, 200);
        g.setColor(Color.blue);
        g.fillRect(hands.getMouseManager().getMouseX(), hands.getMouseManager().getMouseY(),10,10);

        //hands.getGame().init();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if("Switch to Game".equals(e.getActionCommand())){
            if(StateManager.getState()==hands.getGame().menuS)
                StateManager.setState(hands.getGame().gState);
        }
    }
}
