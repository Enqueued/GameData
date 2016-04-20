package states;

import java.awt.*;

/**
 * Created by main on 4/20/16.
 */
public abstract class State {
    public abstract void tick();
    public abstract void render(Graphics g);
}
