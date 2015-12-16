package fr.system.solar;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * MyPanel est une classe héritée de JPanel qui permet l'affichage d'une image de fond et des planètes
 *
 * @author Gilbert William, Tournoux Corentin
 * @version 1.0
 * @see Serializable
 */
public abstract class Astre implements Serializable {
    /**
     * Identifiant de l'astre, existe de façon à ce que deux astre aient le même nom.
     */
    protected int identifiant;
    /**
     * L'image correspondant à l'astre.
     */
    protected ImageIcon image;
    /**
     * Le nom de l'astre.
     */
    protected String nom;
    /**
     * La liste de satellite que possède l'astre.
     */
    protected List<Astre> listOfSatellites;
    /**
     * La coordonnées x sur l'écran, où ce trouve l'astre.
     */
    protected int posX;
    /**
     * La coordonnées y sur l'écran, où ce trouve l'astre.
     */
    protected int posY;


    /**
     * Constructeur d'astre
     *
     * @param id
     *      Identifiant de l'astre
     * @param nom
     *      Le nom de l'astre
     * @param pathImg
     *      Chemin absolue ou relatif vers l'astre
     */
    protected Astre(int id,String nom, String pathImg) {
        this.identifiant = id;
        this.listOfSatellites = new ArrayList<Astre>();
        this.nom = nom;
        this.image = new ImageIcon("image/"+pathImg);
    }

    /**
     * Renvoie l'imageIcon associé à l'astre
     * @return
     *      L'image représentant l'astre
     */
    public ImageIcon getImage() {
        return image;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }

    /**
     * Renvoie le nom de l'astre
     * @return
     *      Nom de l'astre
     */
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Permet de récupérer la liste des astres en orbites autour de l'astre courant
     * @return
     *      Listre d'astre en orbite autour de l'astre courant
     */
    public List<Astre> getListOfSatellites() {
        return listOfSatellites;
    }

    public void setListOfSatellites(List<Astre> listOfSatellites) {
        this.listOfSatellites = listOfSatellites;
    }

    /**
     * Permet de créer un nouvel astre en orbite autour de l'astre courant.
     *
     * @param id
     *      Identifiant du futur astre
     * @param nom
     *      Nom du futur astre
     * @param pathImg
     *      Chemin vers l'image représentant le futur astre
     * @param demiGrandAxe
     *      Demi-grand axe de l'ellipse représentant l'orbite du nouvel astre
     * @param demiPetitAxe
     *      Demi-petit axe de l'ellipse représentant l'orbite du nouvel astre
     * @param periodeRotation
     *      Période de rotation du nouvel astre
     * @return
     *      Un booléen indiquant si oui ou non le nouvel astre a été ajouté à la liste des astres
     */
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


    /**
     * Fonction qui permet de sauvegarder l'astre courant dans un fichier.dat
     *
     * @param name
     *      Nom du fichier dans lequel sera enregistré l'astre
     * @return
     *      Un booléen indiquant si oui ou non l'astre a été sauvegardé
     */
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


    /**
     * @see Etoile#getPosX()
     * @see Satellite#getPosX()
     */
    public abstract int getPosX();


    public void setPosX(int posX) {
        this.posX = posX;
    }

    /**
     * @see Etoile#getPosY()
     * @see Satellite#getPosY()
     */
    public abstract int getPosY();

    public void setPosY(int posY) {
        this.posY = posY;
    }

    /**
     * Récupère l'identifiant de l'astre
     *
     * @return
     *      L'identifiant unique de l'astre
     */
    public int getId() {
        return identifiant;
    }
}
