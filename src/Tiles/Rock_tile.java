package Tiles;

import graphic_launch.Assets;

/**
 * Created by Parzival on 4/20/2016.
 */
public class Rock_tile extends Tile {
    public Rock_tile(int id){
        super(Assets.wall, id);
    }

    @Override
    public boolean isSolid(){
        return true;
    }
}
