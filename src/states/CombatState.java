package states;

import Entities.Actors.Actor;
import Entities.Actors.Enemy;
import Entities.Actors.GuildHead;
import Entities.Actors.Player;
import combat_usage.rng;
import graphic_launch.Anime;
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
    public Player player;
    public Enemy enemy;
    public Anime badime = new Anime(200, Assets.enemy_down);
    public int i=0;
    public int maxCombo=0;
    private int flag=0;
    /**
     * This is the constructor for the main menu
     * @param hands
     */
    public CombatState(Handler hands) {
        super(hands);
        player = hands.getWorld().getEntityManager().getPlayer();
        enemy = hands.getWorld().getEntityManager().getEnemy();
        //enemy.setHealth(40);
    }

    @Override
    public void tick() {
        //System.out.println(hands.getMouseManager().getMouseX()+"\t"+hands.getMouseManager().getMouseY())
        if(hands.getMouseManager().isLeftPressed() && flag==1){
            flag=0;
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
        badime.tick();
        g.drawImage(badime.getCurrentFrame(),145,150,100,100,null);
        g.drawString("fighting happens here", 130, 50);
        g.setColor(Color.blue);
        g.fillRect(hands.getMouseManager().getMouseX(), hands.getMouseManager().getMouseY(),10,10);

        if(enemy.getHealth()<=0){
            g.setColor(Color.yellow);
            g.drawString("MAX COMBO: "+maxCombo, 250,125);
            g.setColor(Color.green);
            g.drawString("You killed him! Click to continue...", 105, 350);
            flag=1;
        }

        if(enemy.getHealth() > 0){
            combatCheck(g,player,enemy);
        }



        //hands.getGame().init();

    }
    public void combatCheck(Graphics g, Player player, Enemy enemy ){
        g.setColor(Color.white);
        int dmg = player.getdamage();
        int health = enemy.getHealth();
        g.drawString("Enemy Health: "+health, 138,145);
        if(player.get_hit() < 15){
            g.drawString("missed", 150, 275);
            i=0;
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else {
            i++;
            g.drawString("hit x"+i+ " for "+(dmg*i), 155, 300);
            if (i>maxCombo)
                maxCombo=i;
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
