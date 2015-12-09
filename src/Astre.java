import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by william on 04/12/2015.
 */
public abstract class Astre {
    protected ImageIcon image;
    protected String nom;
    protected List<Astre> listOfSatellites;
    protected int posX;
    protected int posY;



    protected Astre(String nom, String pathImg) {
        listOfSatellites = new ArrayList<Astre>();

        this.nom = nom;
        image = new ImageIcon(pathImg);


    }

    public ImageIcon getImage() {
        return image;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Astre> getListOfSatellites() {
        return listOfSatellites;
    }

    public void setListOfSatellites(List<Astre> listOfSatellites) {
        this.listOfSatellites = listOfSatellites;
    }

    public boolean addSatellite(String nom, String pathImg, int demiGrandAxe, int demiPetitAxe, int periodeRotation){

        return listOfSatellites.add(new Satellite(nom,pathImg,this,demiGrandAxe,demiPetitAxe,periodeRotation));
    }

    public boolean removeAstre(Astre a){
        Iterator<Astre> itAstre = a.getListOfSatellites().iterator();
        while(itAstre.hasNext()){
            removeAstre(itAstre.next());
        }
        return listOfSatellites.remove(a);
    }



    public abstract int getPosX();

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public abstract int getPosY();

    public void setPosY(int posY) {
        this.posY = posY;
    }
}
