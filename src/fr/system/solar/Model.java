package fr.system.solar;

import javafx.stage.FileChooser;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * Model est la classe ou les données concernant les astres de l'application sont stockées
 *
 * @author Gilbert William, Tournoux Corentin
 * @version 1.0
 */

public class Model implements Serializable {
    /**
     * La liste des astres de l'application. Elle peut être modifiée.
     *
     * @see Model#addAstre(Astre)
     * @see Model#getAstre(int)
     * @see Model#getListOfAstre()
     */
    private List<Astre> listOfAstre;

    /**
     * Constructeur
     */
    public Model(){
        listOfAstre = new ArrayList<Astre>();
    }

    /**
     * Génére un identifiant unique pour un nouvel astre
     *
     * @return
     *      Un identifiant unique utilisable par l'application
     */
    public int generateId(){
        return recId(listOfAstre.size());
    }

    /**
     * Fonction récursive qui génére un identifiant par rapport aux astres existants
     *
     * @param id
     *      Identifiant d'astre dont on vérifie l'unicité
     * @return
     *      Un identifiant
     */
    private int recId(int id){
        for(Astre a : listOfAstre){
            if(a.getId() == id)
                recId(id++);
        }
        return id;
    }


    /**
     * Ajoute les astres du fichier donné en paramètre dans la liste des Astres de l'application
     *
     * @param name
     *      Chemin absolu vers le fichier dans lequel est stocké les données
     * @return
     *      Un code erreur (1) valide ; (0) valide mais astre déjà ouvert ; (-1) erreur
     */
    public int open(String name){
        Astre a = null;
        try {
            // Ouverture du flux d'entré
            FileInputStream fis = new FileInputStream(name);
            // Création d'un flux objet avec le flux d'entré
            ObjectInputStream ois= new ObjectInputStream(fis);
            try {
                // désérialisation : lecture de l'objet depuis le flux d'entrée
                a = (Astre) ois.readObject();
            } finally {
                // on ferme les flux
                try {
                    ois.close();
                } finally {
                    fis.close();
                }
            }
        } catch(IOException e) {
            JOptionPane.showMessageDialog(null, name+"\nMauvais format." , "Erreur", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, name+"Inexistant.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }

        // Vérification de l'opération de désérialisation
        if(null != a) {
            // Déjà ouvert
            for(Astre iterA : listOfAstre){
                if(iterA.getId() == a.getId()){
                    return 0;
                }
            }
            // Valide
            listOfAstre.add(a);
            return 1;

        }
        return 0;
    }


    /**
     * Récupère la liste des Astres de l'application
     *
     * @return
     *      Liste des Astres de l'application
     */
    public List<Astre> getListOfAstre() {
        return listOfAstre;
    }

    /**
     * Ajoute un astre à la liste des Astres de l'application
     *
     * @param a
     *      Astre à ajouté à la liste des Astres de l'application
     * @return
     *      Un booléen qui indique si l'ajout à eu lieu ou non
     */
    public boolean addAstre(Astre a){
        return listOfAstre.add(a);
    }


    public boolean removeAstre(Astre a){
        a.removeMySatellites();
        listOfAstre.remove(a);
        /*if(a.getListOfSatellites()!=null){
            for(int i=0;i<list.size();i++){
                Astre astrecourant = list.get(i);
                if(list.get(i).getListOfSatellites()!=null){
                    removeAstre(astrecourant);
                    astrecourant.getListOfSatellites().remove(i);
                }
            }
        }
        return listOfAstre.remove(o);*/
        return true;
    }



    /**
     * Récupère l'astre à la position de l'index i
     * @param i
     *      Indice de l'astre dans la liste des Astres
     * @return
     *      Astre placé à l'index i
     */
    public Astre getAstre(int i) throws ArrayIndexOutOfBoundsException{
        return listOfAstre.get(i);
    }

}
