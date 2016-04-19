import javax.swing.*;asd
import java.awt.*;

/**
 * Created by Parzival on 4/19/2016.
 */

public class Display {
    private JFrame frame;as
    private Canvas canvas;
    private Dimension dimi;
    private String title;
    private int width, height;

    /**
     * constructor for the display class
     */
    public Display(String t, int w, int h){
        this.title=t;
        this.width=w;
        this.height=h;
        makeDisp();
    }

    private void makeDisp(){
        frame=new JFrame(title);
        frame.setSize(width, height);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        canvas =new Canvas();
        dimi=new Dimension(width, height);
        canvas.setPreferredSize(dimi);
        canvas.setMinimumSize(dimi);
        canvas.setMaximumSize(dimi);
        frame.add(canvas);
        frame.pack();
    }

}
