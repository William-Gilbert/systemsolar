import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by william on 04/12/2015.
 */
public abstract class Astre {
    private ImageIcon image;
    private String nom;
    private List<Astre> listOfSatellites;


    public Astre(String nom, String pathImg){
        listOfSatellites = new ArrayList<Astre>(5);
        for(int i=0 ; i < 5 ; i++) listOfSatellites.set(i,null);
        // TODO nom et image
    }
}
