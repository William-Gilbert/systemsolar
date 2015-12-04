import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Window est la classe qui permet la création de la fenêtre
 * @author Gilbert W
 * @author  Tournoux C
 */
public class MainWindow extends JFrame {


    public MainWindow(Model m) throws IOException{
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
