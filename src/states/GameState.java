package states;

import Entities.Actors.Player;
import Rooms.World;
import Tiles.Tile;
import graphic_launch.Assets;
import main_pack.Game;

import java.awt.*;

/**
 * Created by main on 4/20/16.
 */
public class GameState extends State {
    private Player player;
    private World world;
    public GameState(Game game){
        super(game);
        player=new Player(game, 100, 100);
        world = new World(game, "assets/rooms/room1.txt");

       // game.getCam().move(0, 0);
    }

    @Override
    public void tick() {
        world.tick();
        player.tick();
       // game.getCam().move(1, 1);
    }

    @Override
    public void render(Graphics g) {
        world.render(g);
        // g.drawImage(Assets.player,0,0,null);
        player.render(g);
        //Tile.tiles[0].render(g, 0, 0);
    }
}