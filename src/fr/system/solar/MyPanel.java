package fr.system.solar;

import fr.system.solar.Model;

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
        image = ImageIO.read(new File("image/background.jpg"));
        this.m = m;
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image,0,0,1000,700,null);
        for(Astre a : m.getListOfAstre()){
            paintMySatellites(a, g);
        }

    }

    protected void paintMySatellites(Astre a, Graphics g){
        if(a != null){
            int dec = a.getImage().getIconHeight()/2;
            a.getImage().paintIcon(this,g,a.getPosX()-dec,a.getPosY()-dec);

            for(Astre e : a.getListOfSatellites()){
                paintMySatellites(e, g);
            }
        }

    }

}
