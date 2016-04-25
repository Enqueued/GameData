package states;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Parzival on 4/20/16.
 */
public class StateManager{
    private static State currS = null;

    /**
     * sets the current state
     * @param state
     */
    public static void setState(State state){
        currS=state;
    }

    /**
     * returns the current state that is pointed to.
     * @return
     */
    public static State getState(){
        return currS;
    }

}
