package graphic_launch; //package for graphics

import java.awt.image.BufferedImage;

/**
 * Created by Parzival on 4/19/2016.
 */
public class Spritez {
    private BufferedImage sheet;
    public Spritez(BufferedImage sheet){
        this.sheet=sheet;
    }
    public BufferedImage crop(int x, int y, int w, int h){
        return sheet.getSubimage(x,y,w,h);
    }
}
