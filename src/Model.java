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

    public List<Astre> getListOfAstre() {
        return listOfAstre;
    }

    public void setListOfAstre(List<Astre> listOfAstre) {
        this.listOfAstre = listOfAstre;
    }

    public boolean addAstre(Astre a){
        return listOfAstre.add(a);
    }

    public boolean removeAstre(Astre a){
        return listOfAstre.remove(a);
    }

    public boolean removeAstre(int index){
        return listOfAstre.remove(index)!=null;
    }


}
