package Entities;

import Entities.Actors.GuildHead;
import Entities.Actors.Player;
import main_pack.Handler;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * This should help manage all of the entities in this game
 * I bet this guy gets paid more than me...I dont get paid at all...
 * Created by Parzival on 4/23/2016.
 */
public class Emanager {
    private Handler hands;
    public Player player;
    public GuildHead enemy;
    private ArrayList<Entity> entities;
    //this is setting up for the sort
    private Comparator<Entity> renderSort=new Comparator<Entity>() {
        @Override
        public int compare(Entity o1, Entity o2) {
            if(o1.getY()+ o1.getHeight()<o2.getY()+o2.getHeight())
                return -1; //if o2 1st and o1 second
            return 1;
        }
    };

    /**
     * The constructor for the Event manager
     * @param handler
     * @param player
     */
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
        //noinspection Since15
        entities.sort(renderSort);
    }
    public void render(Graphics g){
        for(Entity e : entities){
            e.render(g);
        }
    }

    /**
     * this is going to add an entity to the array list
     * @param e
     */
    public void addEntity(Entity e){
        entities.add(e);
    }

    /**
     * this will return the handler
     * @return
     */
    public Handler getHands(){
        return hands;
    }

    /**
     * will do pretty much what it says
     * @return
     */
    public Player getPlayer(){
        return player;
    }
    public GuildHead getEnemy(){
        return enemy;
    }
    /**
     * ditto for this one
     * @return
     */
    public ArrayList<Entity> getEntities(){
        return entities;
    }

    /**
     * this will SET the handler up (not for failure hopefully)
     * @param handler
     */
    public void setHands(Handler handler){
        this.hands=handler;
    }

    /**
     * This will set the player in the entity array
     * would help if more than one player but whatevs
     * @param player
     */
    public void setPlayer(Player player){
        this.player=player;
    }

    /**
     * will set the array list equal to a diff one if I so choose
     * for I am the almighty creator and this should fear me (if i finish in time)
     * @param entities
     */
    public void setEntities(ArrayList<Entity> entities){
        this.entities=entities;
    }
}
