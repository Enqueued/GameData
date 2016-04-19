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

    public Game(String t, int w, int h){
        this.width=w;
        this.height=h;
        this.title=t;
    }

    public void init(){
        dis=new Display(title,width,height);
    }

    private void render(){

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
