package Entities.Static;

import Tiles.Tile;
import graphic_launch.Assets;
import main_pack.Handler;

import java.awt.*;

/**
 * Created by Parzival on 4/22/2016.
 */
public class Chest extends Static{
    public Chest(Handler handler, float x, float y){
        super(handler, x, y, Tile.TILEWIDE, Tile.TILEHIGH);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.tree, (int)(x-hands.getCam().getxOff()),(int)(y-hands.getCam().getyOff()), null);
    }
}
