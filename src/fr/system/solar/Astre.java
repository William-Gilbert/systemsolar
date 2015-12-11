package fr.system.solar;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by william on 04/12/2015.
 */
public abstract class Astre implements Serializable {
    protected int identifiant;
    protected ImageIcon image;
    protected String nom;
    protected List<Astre> listOfSatellites;
    protected int posX;
    protected int posY;


    protected Astre(int id,String nom, String pathImg) {
        this.identifiant = id;
        listOfSatellites = new ArrayList<Astre>();
        this.nom = nom;
        image = new ImageIcon("image/"+pathImg);

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

    public boolean addSatellite(int id, String nom, String pathImg, int demiGrandAxe, int demiPetitAxe, int periodeRotation){

        return listOfSatellites.add(new Satellite(id,nom,pathImg,this,demiGrandAxe,demiPetitAxe,periodeRotation));
    }

    public boolean removeAstre(Astre a){
        Iterator<Astre> itAstre = a.getListOfSatellites().iterator();
        while(itAstre.hasNext()){
            removeAstre(itAstre.next());
        }
        return listOfSatellites.remove(a);
    }

    public boolean save(String name){
        try {

            // ouverture d'un flux de sortie vers le fichier name
            FileOutputStream fos = new FileOutputStream(name);
            // création d'un "flux objet" avec le flux fichier
            ObjectOutputStream oos= new ObjectOutputStream(fos);
            try {
                // sérialisation : écriture de l'objet dans le flux de sortie
                oos.writeObject(this);
                // on vide le tampon
                oos.flush();
                System.out.println(this + " a été sérialisé");
            } finally {
                try {
                    oos.close();
                } finally {
                    fos.close();
                }
            }
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
        return true;
    }



    public abstract int getPosX();

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public abstract int getPosY();

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getId() {
        return identifiant;
    }
}
