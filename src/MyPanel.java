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


    public MyPanel() throws IOException{
        image = ImageIO.read(new File("background.jpg"));
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image,0,0,1280,920,null);
    }

}
