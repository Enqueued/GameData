package graphic_launch;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by Parzival on 4/19/2016.
 */
public class ImgLoad {
    public static BufferedImage loadImage(String path){
        try {
            return ImageIO.read(ImgLoad.class.getResource(path));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        return null;
    }
}
