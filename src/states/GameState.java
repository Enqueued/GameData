package states;

import World.World;
import main_pack.Handler;

import java.awt.*;

/**
 * Created by main on 4/20/16.
 */
public class GameState extends State {
    private World world;

    public GameState(Handler hands){
        super(hands);
        world = new World(hands, "assets/rooms/room1.txt");
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
}