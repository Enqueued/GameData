package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Parzival on 4/20/2016.
 */
public class KeyManager implements KeyListener{
    private boolean[] keys;
    public boolean n, s, e, w;
    public KeyManager(){
        keys = new boolean[256];
    }

    public void tick(){
        //using WASD controls
        n=keys[KeyEvent.VK_W];
        s=keys[KeyEvent.VK_S];
        w=keys[KeyEvent.VK_A];
        e=keys[KeyEvent.VK_D];

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()]=true;
        System.out.println("Pressed!");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()]=false;
    }
}
