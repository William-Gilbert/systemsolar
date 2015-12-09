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

    public boolean save(String name){
        ObjectOutputStream oos = null;

        try {
            final FileOutputStream fichier = new FileOutputStream(name+".dat");
            oos = new ObjectOutputStream(fichier);

        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            try {
                if (oos != null) {
                    oos.flush();
                    oos.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return true;
    }

    public static Model open(String name)throws Exception{
        // TODO exception
        Model m = null;
            // ouverture d'un flux d'entrée depuis le fichier "personne.serial"
        FileInputStream fis = new FileInputStream(name+".dat");
        // création d'un "flux objet" avec le flux fichier
        ObjectInputStream ois= new ObjectInputStream(fis);

        // désérialisation : lecture de l'objet depuis le flux d'entrée
        m = (Model) ois.readObject();

        ois.close();
        fis.close();

        if(m== null) throw new NullPointerException();

        return m;

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


}
