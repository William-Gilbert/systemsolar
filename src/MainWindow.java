import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Window est la classe qui permet la création de la fenêtre
 * @author Gilbert W
 * @author  Tournoux C
 */
public class MainWindow extends JFrame {
    private MyPanel pan_global;

    public MainWindow(Model m) throws IOException{
        setTitle("Système Solaire");
        setSize(1000, 700);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = this.getContentPane();
        pan_global = new MyPanel(m);
        pan_global.setLayout(null);




        c.add(pan_global);

        setContentPane(c);
    }

    public void display(){
        pan_global.repaint();
    }
}
