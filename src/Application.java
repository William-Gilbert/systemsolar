import java.io.IOException;

/**
 * Created by william on 01/12/2015.
 */
public class Application {
    public static void main(String[] args){
        Model m = new Model();
        Etoile a = new Etoile("Sun","terre.png",200,200);
        a.addSatellite("Sun","deimos.png",70,70,3);
        a.getListOfSatellites().get(0).addSatellite("Luné","lune.png",50,50,2);
        m.addAstre(a);



        try {
            MainWindow w = new MainWindow(m);
            while(true){
                w.display();
                Thread.sleep(20);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }



    }
}
