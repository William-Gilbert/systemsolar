import java.util.ArrayList;
import java.util.List;

/**
 * Created by william on 04/12/2015.
 */
public class Model {
    private List<Astre> listOfAstre;

    public Model(){
        listOfAstre = new ArrayList<Astre>(5);
        for(int i=0 ; i < 5 ; i++) listOfAstre.add(null);
        // TODO nom et image
    }
}
