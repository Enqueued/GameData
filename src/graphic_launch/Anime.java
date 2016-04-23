package graphic_launch;

import java.awt.image.BufferedImage;

/**
 * Created by Parzival on 4/22/2016.
 */
public class Anime{
    private int sonic, index;
    private long timer, last;
    private BufferedImage[] frames;

    public Anime (int sonic, BufferedImage[] frame){
        this.sonic=sonic;
        this.frames=frame;
        index=0;
        timer=0;
        last=System.currentTimeMillis();
    }
    public void tick(){
        timer+=System.currentTimeMillis()-last;
        last=System.currentTimeMillis();
        if(timer > sonic){
            index ++;
            timer = 0;
            if(index >= frames.length)
                index = 0;
        }
    }

    public BufferedImage getCurrentFrame(){
        return frames[index];
    }

}
