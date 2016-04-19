/**
 * Created by Parzival on 4/19/2016.
 * going to be the main code for the game, where everything gets made
 */
public class Game {
    private Display dis;
    public int width, height;
    public Game(String t, int w, int h){
        this.width=w;
        this.height=h;
        dis=new Display(t,w,h);
    }
}
