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
    private static final int bw=16, bh=16;

    //needs to be public because it will be sent to other things
    public static BufferedImage wall, floor, enemy, grass, ground, tree;
    public static BufferedImage[] player_down, player_up, player_left, player_right,
            guildhead_down, enemy_down;

    public static void init(){
        Spritez sheet = new Spritez(ImgLoad.loadImage("/textures/dragonwarrior_various_sheet.png"));
        //now we need to crop and set each asset;
        //example
        //player = sheet.crop(0, 0, bw, bh);
        player_down = new BufferedImage[2];
        player_up = new BufferedImage[2];
        player_left = new BufferedImage[2];
        player_right = new BufferedImage[2];

        guildhead_down = new BufferedImage[2];

        enemy_down = new BufferedImage[2];

        player_down[0]=sheet.crop(bw*0, 0, bw, bh);
        player_down[1]=sheet.crop(bw*1+4,0,bw,bh);
        player_up[0]=sheet.crop(bw*5,0,bw,bh);
        player_up[1]=sheet.crop(bw*6+4,0,bw,bh);
        player_left[0]=sheet.crop((bw*2+8),0,bw,bh);
        player_left[1]=sheet.crop((bw*3+12),0,bw,bh);
        player_right[0]=sheet.crop((bw*7+8),0,bw,bh);
        player_right[1]=sheet.crop((bw*8+12),0,bw,bh);

        guildhead_down[0]=sheet.crop(200,120, bw, bh);
        guildhead_down[1]=sheet.crop(220, 120, bw, bh);

        enemy_down[0]=sheet.crop((200-48)+8,5*(16+4),bw,bh);
        enemy_down[1]=sheet.crop((220-48)+8, 5*(16+4),bw,bh);

        grass = sheet.crop(64, 270, bw, bh);
        wall = sheet.crop(16, 204, bw, bh);
        tree = sheet.crop(0, 204, bw, bh);
        ground = sheet.crop(112, 396, bw, bh);
    }
}
