package fr.system.solar;

import fr.system.solar.Model;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * MyPanel est une classe héritée de JPanel qui permet l'affichage d'une image de fond et des planètes
 *
 * @author Gilbert William, Tournoux Corentin
 * @version 1.0
 * @see JPanel
 */
public class MyPanel extends JPanel {
    /**
     * L'image de fond de l'application
     */
    private BufferedImage image;
    /**
     * Le modèle m de l'application, utilisé pour charger les astres et leurs images
     */
    private Model m;


    /**
     * Constructeur de la classe
     * @param m
     *      Modèle de donnée
     * @throws IOException
     */
    public MyPanel(Model m) throws IOException{
        image = ImageIO.read(new File("image/background.jpg"));
        this.m = m;
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image,0,0,1000,700,null);
        for(Astre a : m.getListOfAstre()){
            paintMySatellites(a, g);
        }

    }

    /**
     * Permet de dessiner récursivement tous les satellites de l'application
     * @param a
     * @param g
     */
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
