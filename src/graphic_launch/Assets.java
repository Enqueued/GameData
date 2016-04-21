package graphic_launch;

import java.awt.image.BufferedImage;

/**
 * Created by Parzival on 4/20/2016.
 *
 * this is supposed to create and manage the sprite sheets
 * and pull the assets from them to set them to be used later
 *
 */
public class Assets {
    //these are just example sizes for base width & base height
    private static final int bw=17, bh=17;

    //needs to be public because it will be sent to other things
    public static BufferedImage player, wall, floor, enemy, grass, ground, tree;

    public static void init(){
        Spritez sheet = new Spritez(ImgLoad.loadImage("/textures/dragonwarrior_various_sheet.png"));
        //now we need to crop and set each asset;
        //example
        player = sheet.crop(0, 0, bw, bh);
        grass = sheet.crop(64, 270, bw, bh);
        wall = sheet.crop(16, 204, bw, bh);
        tree = sheet.crop(0, 204, bw, bh);
        ground = sheet.crop(112, 396, bw, bh);
    }
}
