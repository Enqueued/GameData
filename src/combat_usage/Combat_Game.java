package combat_usage;

import main_pack.Display;
import main_pack.Handler;

import javax.swing.*;
import java.awt.*;

/**
 * Created by main on 4/25/16.
 */
public class Combat_Game extends JFrame {
    private Display dis;
    private JButton butt;
    private JPanel pan;
    private Handler handler;
    public Combat_Game(Handler hands){
        this.handler = hands;

        dis = new Display("Battle!", 300, 300);
       // handler.getGame().dis=this.dis;
        //thread = new Thread();

    }

    public void tick(){

    }
    public void render(Graphics g){
        g.setColor(Color.blue);
        g.fillRect(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY(),10,10);
//        dis.getFrame().add(butt);
    }

}
