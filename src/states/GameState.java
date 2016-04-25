package states;

import World.World;
import main_pack.Handler;

import java.awt.*;

/**
 * Created by main on 4/20/16.
 */
public class GameState extends State {
    private World world;
    public static String star = "assets/rooms/room1.txt";
    public static String dung  = "assets/rooms/Dungeon1.txt";
    public GameState(Handler hands, String num){
        super(hands);
        if (num.equals(dung)){
            world = new World(hands,dung);
        }else {
            world = new World(hands, star);
        }
        hands.setWorld(world);
        //player=new Player(hands, 100, 100);
    }

    @Override
    public void tick() {
        world.tick();
        if(hands.getKeys().pause){
            StateManager.setState(hands.getGame().invS);
        }
        //player.tick();
       // game.getCam().move(1, 1);
    }

    @Override
    public void render(Graphics g) {
        world.render(g);
        // g.drawImage(Assets.player,0,0,null);
        //player.render(g);
        //Tile.tiles[0].render(g, 0, 0);
    }
    public static String getRoom(int num){
        if (num == 1){
            return star;
        }else{
            return dung;
        }
    }
}