package states;

import Entities.Actors.Player;
import graphic_launch.Assets;
import main_pack.Game;

import java.awt.*;

/**
 * Created by main on 4/20/16.
 */
public class GameState extends State {
    private Player player;
    public GameState(Game game){
        super(game);
        player=new Player(game, 100, 100);
    }

    @Override
    public void tick() {
        player.tick();
    }

    @Override
    public void render(Graphics g) {
        //g.drawImage(Assets.player,0,0,null);
        player.render(g);
    }
}