package main_pack;

import Rooms.World;
import graphic_launch.Game_Camera;
import input.KeyManager;

/**
 * Created by Parzival on 4/21/2016.
 */
public class Handler {
    private Game game;
    private World world;
    public Handler(Game game){
        this.game = game;
    }

    public Game_Camera getCam(){
        return game.getCam();
    }
    public KeyManager getKeys(){
        return game.getKeyManager();
    }
    public int getWidth(){
        return game.width;
    }
    public int getHeight(){
        return game.height;
    }
    public Game getGame(){
        return game;
    }
    public World getWorld(){
        return world;
    }
    //setters
    public void setGame(Game game){
        this.game=game;
    }
    public void setWorld(World world) {
        this.world = world;
    }
}
