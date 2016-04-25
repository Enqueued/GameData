package World;

import Entities.Actors.GuildHead;
import Entities.Actors.Player;
import Entities.Emanager;
import Entities.Static.Chest;
import Tiles.Tile;
import Utils.Utilz;
import main_pack.Handler;

import java.awt.*;

/**
 * Created by Parzival on 4/20/2016.
 */
public class World {
    private Handler handler;
    private int width, height;
    private int spawnX, spawnY;
    private int[][] tiles;
    private Emanager entityManager;

    public World(Handler hands, String path){
        this.handler = hands;
        entityManager=new Emanager(hands, new Player(handler, 100, 100));
        entityManager.addEntity(new Chest(handler, 100, 304));
        entityManager.addEntity(new GuildHead(handler, 300, 304));
        loadWorld(path);
        entityManager.getPlayer().setX(spawnX);
        entityManager.getPlayer().setY(spawnY);
    }
    public void tick(){
        entityManager.tick();
    }
    public void render(Graphics g){
        int xMin=(int)Math.max(0, handler.getCam().getxOff()/Tile.TILEWIDE);
        int xMax=(int)Math.min(width, (handler.getCam().getxOff()+ handler.getWidth())/Tile.TILEWIDE+1);
        int yMin=(int)Math.max(0, handler.getCam().getyOff()/Tile.TILEHIGH);
        int yMax=(int)Math.min(height, (handler.getCam().getyOff()+ handler.getHeight())/Tile.TILEHIGH +1);

        for(int y=yMin; y<yMax; y++){
            for(int x=xMin; x<xMax; x++){
                getTile(x, y).render(g, (int)(x*Tile.TILEWIDE - handler.getCam().getxOff()),
                        (int)(y*Tile.TILEHIGH - handler.getCam().getyOff()));
            }
        }
        entityManager.render(g);
    }

    public Tile getTile(int x, int y){
        if(x < 0 || y < 0 || x >=width || y>=height){
            return Tile.dirtT;
        }

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

    //getters
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }
    public Emanager getEntityManager(){
        return entityManager;
    }

}
