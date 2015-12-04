import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by william on 04/12/2015.
 */
public abstract class Astre {
    protected ImageIcon image;
    protected String nom;
    protected List<Astre> listOfSatellites;

    public Astre(String nom, String pathImg){
        listOfSatellites = new ArrayList<Astre>(5);
        for(int i=0 ; i < 5 ; i++) listOfSatellites.add(null);
        // TODO nom et image
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

    public boolean addSatellite(Astre a){
        return listOfSatellites.add(a);
    }

    public boolean removeSatellite(Astre a){
        return listOfSatellites.remove(a);
    }

    public boolean removeSatellite(int index){
        return listOfSatellites.remove(index)!=null;
    }


}
