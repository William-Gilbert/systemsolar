import javafx.stage.FileChooser;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by william on 04/12/2015.
 */
public class Model implements Serializable {
    private List<Astre> listOfAstre;

    public Model(){
        listOfAstre = new ArrayList<Astre>();
    }



    public void open(String name)throws Exception{
        Astre a = null;
        try {
            // ouverture d'un flux d'entrée depuis le fichier "personne.serial"
            FileInputStream fis = new FileInputStream(name);
            // création d'un "flux objet" avec le flux fichier
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
        } catch(IOException ioe) {
            ioe.printStackTrace();
        } catch(ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        }
        if(a != null) {
            System.out.println(a + " a été désérialisé");
        }

        listOfAstre.add(a);

    }


    public List<Astre> getListOfAstre() {
        return listOfAstre;
    }

    public void setListOfAstre(List<Astre> listOfAstre) {
        this.listOfAstre = listOfAstre;
    }

    public boolean addAstre(Astre a){
        return listOfAstre.add(a);
    }


    public boolean removeAstre(int index){
        return listOfAstre.remove(index)!=null;
    }


    public Astre getAstre(int i) {
        return listOfAstre.get(i);
    }

    public Astre getAstre(String nom) throws ExceptionUnknowAstre{
        for(Astre a : listOfAstre){
            if(a.getNom().equals(nom))
                return a;
        }
        throw new ExceptionUnknowAstre(nom+ " n'existe pas");
    }
}
