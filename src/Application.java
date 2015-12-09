import java.io.IOException;

/**
 * Created by william on 01/12/2015.
 */
public class Application {
    public static void main(String[] args){
        Model m = new Model();
        Etoile a = new Etoile("Sun","terre.png",200,200);
        a.addSatellite(new Satellite("Sun","deimos.png",a,70,70,3));
        m.addAstre(a);
        m.addAstre(new Satellite("Sun","lune.png",a,50,50,3));


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
