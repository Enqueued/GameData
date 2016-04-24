package states;

import main_pack.Game;
import main_pack.Handler;

import javax.swing.*;
import java.awt.*;

import static com.sun.javafx.fxml.expression.Expression.add;

/**
 * Created by main on 4/20/16.
 */
public class InvState extends State{
    public JButton button;
    private Font font;
    public InvState(Handler hands){
        super(hands);
        font = new Font("Monospaced", Font.BOLD + Font.ITALIC, 30);
        button = new JButton("Switch Panels");
        button.setFont(font);
        add(button, BorderLayout.NORTH);
    }
    @Override
    public void tick() {
        if(hands.getKeys().pause){
            StateManager.setState(hands.getGame().gState);
        }
    }



    @Override
    public void render(Graphics g) {

    }
}
