package fr.system.solar;

import javax.swing.*;

/**
 * Classe qui permet de lancer l'application
 *
 * @author Gilbert William, Tournoux Corentin
 * @version 1.0
 */

public class Application {

    /**
     * Point d'entrée de l'application
     * @param args
     */
    public static void main(String[] args){
        Model m = new Model();
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
