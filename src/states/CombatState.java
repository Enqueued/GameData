package states;

import Entities.Actors.Actor;
import Entities.Actors.GuildHead;
import Entities.Actors.Player;
import combat_usage.rng;
import graphic_launch.Assets;
import main_pack.Display;
import main_pack.Game;
import main_pack.Handler;

import javax.swing.*;
import javax.swing.text.html.parser.Entity;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

/**
 * This WILL be the main menu leading into the game
 * just need to figure out how to do that
 * Created by Parzival on 4/20/16.
 */
public class CombatState extends State{ //implements ActionListener{
    private JButton butt;
    public Player player;
    public Player enemy;
    public int i =0;
    /**
     * This is the constructor for the main menu
     * @param hands
     */
    public CombatState(Handler hands) {
        super(hands);
        player = hands.getWorld().getEntityManager().getPlayer();
        enemy = hands.getWorld().getEntityManager().getPlayer();
        //enemy.setHealth(40);
    }

    @Override
    public void tick() {
        //System.out.println(hands.getMouseManager().getMouseX()+"\t"+hands.getMouseManager().getMouseY())
        if(hands.getMouseManager().isLeftPressed()/*&&hands.getMouseManager().isRightPressed()*/){
            StateManager.setState(hands.getGame().gState);
        }

    }

    /**
     * need to fix the button and make it ACTUALLY a button
     * @param g
     */
    @Override
    public void render(Graphics g) {
        /*butt=new JButton("Goto Game!");
        hands.getGame().dis.getFrame().add(butt);*/
        g.setColor(Color.BLACK);
        g.fillRect(0,0,500,500);
        g.setColor(Color.red);
        g.drawImage(Assets.guildhead_down[0],200,200,100,100,null);
        g.drawString("fighting happens here", 105, 150);
        g.setColor(Color.blue);
        g.fillRect(hands.getMouseManager().getMouseX(), hands.getMouseManager().getMouseY(),10,10);
        g.setColor(Color.green);
        if(enemy.getHealth() <= 0){
            g.drawString("you killed him! click to continue", 105, 350);

        }

        if(enemy.getHealth() > 0){
            combatCheck(g,player,enemy);
        }



        //hands.getGame().init();

    }
    public void combatCheck(Graphics g, Player player, Player enemy ){
        g.setColor(Color.white);
        int dmg = player.getdamage();
        int health = enemy.getHealth();
        g.drawString("Enemy Health: "+health, 190,185);
        if(player.get_hit() < 15){
            g.drawString("missed", 105, 275);
            i=0;
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else {
            i++;
            g.drawString("hit x"+i+ " for "+(dmg*i), 105, 300);
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            enemy.setHealth(enemy.getHealth() - dmg);
        }
    }
    public void actionPerformed(ActionEvent e) {
        if("Switch to Game".equals(e.getActionCommand())){
            if(StateManager.getState()==hands.getGame().cState)
                StateManager.setState(hands.getGame().gState);
        }
    }
//    @Override
   // public void actionPerformed(ActionEvent e) {
     //   if("Switch to Game".equals(e.getActionCommand())){
       //     if(StateManager.getState()==hands.getGame().menuS)
    //            StateManager.setState(hands.getGame().gState);
    //    }
    //}
}
