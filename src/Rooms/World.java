package Rooms;

import Tiles.Tile;
import Utils.Utilz;
import main_pack.Game;

import java.awt.*;

/**
 * Created by Parzival on 4/20/2016.
 */
public class World {
    private Game game;
    private int width, height;
    private int spawnX, spawnY;
    private int[][] tiles;

    public World(Game game, String path){
        this.game=game;
        loadWorld(path);
    }
    public void tick(){

    }
    public void render(Graphics g){

        for(int y=0; y<height; y++){
            for(int x=0; x<width; x++){
                getTile(x, y).render(g, (int)(x*Tile.TILEWIDE - game.getCam().getxOff()),
                        (int)(y*Tile.TILEHIGH - game.getCam().getyOff()));
            }
        }
    }
    public Tile getTile(int x, int y){
        Tile t = Tile.tiles[tiles[x][y]];
        if(t==null)
            return Tile.dirtT;
        return t;
    }

    private void loadWorld(String path){
        String file = Utilz.loadFileAsString(path);
        String[] tokens = file.split("\\s+"); //make sure to cut white space
        width = Utilz.parseInt(tokens[0]);
        height = Utilz.parseInt(tokens[1]);
        spawnX = Utilz.parseInt(tokens[2]);
        spawnY = Utilz.parseInt(tokens[3]);

        tiles = new int[width][height];
        for(int y=0; y<height; y++){
            for(int x=0; x<width; x++){
                tiles[x][y]=Utilz.parseInt(tokens[(x+y*width)+4]);
            }
        }
    }

}
