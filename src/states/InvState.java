package states;

import main_pack.Game;
import main_pack.Handler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import static com.sun.javafx.fxml.expression.Expression.add;

/**
 * Created by main on 4/20/16.
 */
public class InvState extends State{
    public JButton button;
    private JPanel jPanel;
    private Font font;
    public InvState(Handler hands){
        super(hands);

    }
    @Override
    public void tick() {
        if(hands.getKeys().pause){
            StateManager.setState(hands.getGame().invS);
        }
        jPanel.repaint();
    }



    @Override
    public void render(Graphics g) {
        //g.drawButton();
        jPanel=new JPanel();
        font = new Font("Monospaced", Font.BOLD + Font.ITALIC, 30);
        button = new JButton("Switch Panels");
        button.setFont(font);
        //add(button, BorderLayout.NORTH);
        //add(jPanel, BorderLayout.CENTER);
        jPanel.setBackground(Color.cyan);
        jPanel.add(button);
        button.addKeyListener(hands.getKeys());
    }

}
