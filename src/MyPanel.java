import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by william on 04/12/2015.
 */
public class MyPanel extends JPanel {
    private BufferedImage image;
    private Model m;


    public MyPanel(Model m) throws IOException{
        image = ImageIO.read(new File("background.jpg"));
        this.m = m;
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image,0,0,1000,700,null);
        for(Astre a : m.getListOfAstre()){
            if(a != null ){
                a.getImage().paintIcon(this,g,a.getPosX(),a.getPosY());
            }
        }

    }

}
