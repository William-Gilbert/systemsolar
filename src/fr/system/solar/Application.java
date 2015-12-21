package fr.system.solar;

import java.io.IOException;

/**
 * Created by william on 01/12/2015.
 */
public class Application {
    public static void main(String[] args){
        Model m = new Model();
        Etoile a = new Etoile(m.generateId(),"Sun","soleil.png",450,375);
        a.addSatellite(m.generateId(),"Terre","terre.png",300,200,20);
        a.getListOfSatellites().get(0).addSatellite(m.generateId(),"Lune", "lune.png", 200, 80, 5);
        a.getListOfSatellites().get(0).addSatellite(m.generateId(), "phobos","phobos.png",100,40,2);
        m.addAstre(a);


        Etoile e2 = new Etoile(m.generateId(),"mars","mars.png",300,300);
        e2.addSatellite(m.generateId(),"phobos","phobos.png",30,30,15);
        m.addAstre(e2);



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
