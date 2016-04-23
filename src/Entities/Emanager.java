package Entities;

import Entities.Actors.Player;
import main_pack.Handler;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by Parzival on 4/23/2016.
 */
public class Emanager {
    private Handler hands;
    private Player player;
    private ArrayList<Entity> entities;
    private Comparator<Entity> renderSort=new Comparator<Entity>() {
        @Override
        public int compare(Entity o1, Entity o2) {
            if(o1.getY()+ o1.getHeight()<o2.getY()+o2.getHeight())
                return -1; //if o2 1st and o1 second
            return 1;
        }
    };

    public Emanager (Handler handler, Player player){
        this.hands=handler;
        this.player=player;
        entities=new ArrayList<Entity>();
        addEntity(player);
    }

    public void tick(){
        for(int i=0; i<entities.size(); i++){
            Entity e = (Entity) entities.get(i);
            e.tick();
        }
        entities.sort(renderSort);
    }
    public void render(Graphics g){
        for(Entity e : entities){
            e.render(g);
        }
    }
    public void addEntity(Entity e){
        entities.add(e);
    }
    public Handler getHands(){
        return hands;
    }
    public Player getPlayer(){
        return player;
    }
    public ArrayList<Entity> getEntities(){
        return entities;
    }
    public void setHands(Handler handler){
        this.hands=handler;
    }
    public void setPlayer(Player player){
        this.player=player;
    }
    public void setEntities(ArrayList<Entity> entities){
        this.entities=entities;
    }
}
