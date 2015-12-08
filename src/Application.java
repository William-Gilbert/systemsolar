import java.io.IOException;

/**
 * Created by william on 01/12/2015.
 */
public class Application {
    public static void main(String[] args){
        Model m = new Model();
        Etoile a = new Etoile("Sun","soleil.png",200,200);
        m.addAstre(a);
        m.addAstre(new Satellite("Sun","lune.png",a,100,200,50));

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
