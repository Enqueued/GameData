package main_pack;

import graphic_launch.*; //graphics package for image loading
import input.KeyManager;
import states.*;

import java.awt.*;
import java.awt.image.*;

/**
 * Created by Parzival on 4/19/2016.
 * going to be the main code for the game, where everything gets made
 */
public class Game implements Runnable{

    public int width, height;
    public String title;

    private Display dis;
    private boolean running;
    private Thread thread;
    private BufferStrategy buff; //used to prevent screen flashing
    private Graphics g;
    private State gState;
    private State invS;
    private State menuS;
    private KeyManager keyM;

    //private BufferedImage map;

    public Game(String t, int w, int h){
        this.width=w;
        this.height=h;
        this.title=t;
        keyM=new KeyManager();
    }

    public void init(){
        dis=new Display(title,width,height);
        dis.getFrame().addKeyListener(keyM);
        Assets.init();

        gState=new GameState(this);
        invS = new InvState(this);
        menuS=new MenuState(this);
        StateManager.setState(gState);
    }

    /**
     * used to draw things to the canvas
     */
    private void render(){
        buff=dis.getCanvas().getBufferStrategy();
        if(buff == null){ //nothing in the canvas
            dis.getCanvas().createBufferStrategy(3);
            return;
        }
        g=buff.getDrawGraphics();
        g.clearRect(0,0,width,height); //used to clean whatever is on it

       //g.drawImage(map, 0, 0, null);
        if(StateManager.getState()!=null)
            StateManager.getState().render(g);
        g.drawImage(Assets.player, 0, 10, null);
        //below use to show the drawn obj and clean the waste
        buff.show();
        g.dispose();
    }

    private void tick(){
        //x+=1;
        if(StateManager.getState()!=null)
            StateManager.getState().tick();
    }

    public void run(){
        init();
        int fps=20;
        double tpt=1000000000/fps; //100000000 nanosecs per 1 sec
        double delta=0;
        long now;
        long last=System.nanoTime();

        while(running){
            now = System.nanoTime();
            delta+=(now-last)/tpt;
            last = now;
            if(delta>=1) {
                tick();
                render();
                delta--;
            }
        }
        stop();
    }

    public synchronized void start(){
        if(running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop(){
        if (!running)
            return;
        running = false;
        //error trapped to get the reason why it didnt work
        try{
            thread.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

}
