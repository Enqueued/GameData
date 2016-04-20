import graphic_launch.*; //graphics package for image loading

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

/**
 * Created by Parzival on 4/19/2016.
 * going to be the main code for the game, where everything gets made
 */
public class Game implements Runnable{
    private Display dis;
    public int width, height;
    public String title;
    private boolean running;
    private Thread thread;
    private BufferStrategy buff; //used to prevent screen flashing
    private Graphics g;

    private BufferedImage map;

    public Game(String t, int w, int h){
        this.width=w;
        this.height=h;
        this.title=t;
    }

    public void init(){
        dis=new Display(title,width,height);
        map= ImgLoad.loadImage("/textures/test.png");
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

        g.drawImage(map, 0, 0, null);

        //below use to show the drawn obj and clean the waste
        buff.show();
        g.dispose();
    }

    private void tick(){

    }

    public void run(){
        init();
        while(running){
            tick();
            render();
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
