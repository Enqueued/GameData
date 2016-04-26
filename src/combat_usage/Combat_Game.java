package combat_usage;

import main_pack.Display;
import main_pack.Handler;
import states.StateManager;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * Created by main on 4/25/16.
 */
public class Combat_Game extends JFrame {
    private Display dis;
    private JPanel pan;
    private Handler handler;
    private BufferStrategy buff;
    public Combat_Game(Handler hands){
        this.handler = hands;

        dis = new Display("Battle!", 300, 300);
        StateManager.setState(handler.getGame().cState);
       // handler.getGame().dis=this.dis;
        //thread = new Thread();

    }

    public void tick(){

    }
    public void render(Graphics g){
        buff=dis.getCanvas().getBufferStrategy();
        if(buff == null){ //nothing in the canvas
            dis.getCanvas().createBufferStrategy(3);
            return;
        }
        g=buff.getDrawGraphics();
        g.clearRect(0,0,300,300); //used to clean whatever is on it

        //g.drawImage(map, 0, 0, null);
        if(StateManager.getState()!=null)
            StateManager.getState().render(g);
        //g.drawImage(Assets.player, 0, 10, null);
        //below use to show the drawn obj and clean the waste
        buff.show();
        g.dispose();
        g.setColor(Color.blue);
        g.fillRect(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY(),10,10);
//        dis.getFrame().add(butt);
    }

}
