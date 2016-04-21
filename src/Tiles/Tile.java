package Tiles;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Parzival on 4/20/2016.
 */
public class Tile {
    //static stuffs
    public static Tile[] tiles=new Tile[256];
    public static Tile grassT=new grass_tile(0);
    public static Tile dirtT=new Dirt_tile(1);
    public static Tile RockT=new Rock_tile(2);

    //class
    public static final int TILEWIDE=32, TILEHIGH=32;
    protected BufferedImage texture;
    protected final int id;

    public Tile(BufferedImage texture, int id){
        this.texture=texture;
        this.id=id;
        tiles[id]=this;
    }
    public boolean isSolid(){
        return false;
    }
    public void tick(){

    }
    public void render(Graphics g, int x, int y){
        g.drawImage(texture, x, y, TILEWIDE, TILEHIGH, null);
    }
    /*public getID(){
        return id;
    }*/
}
