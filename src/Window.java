import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Created by william on 04/12/2015.
 */
public class Window extends JFrame {


    public Window(Model m) throws IOException{
        setTitle("Système Solaire");
        setSize(1280, 920);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = this.getContentPane();

        c.add(new MyPanel());

        setContentPane(c);
    }
}
