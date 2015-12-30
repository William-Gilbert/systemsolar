package fr.system.solar;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Window est la classe qui permet la création de la fenêtre
 * @author Gilbert W
 * @author  Tournoux C
 */
public class MainWindow extends JFrame {
    /**
     *  Barre de menu
     */
    JMenuBar menuBar;
    /**
     *  Menu Fichier
     */
    JMenu menuFichier;
    /**
     *  Menu Astre
     */
    JMenu menuAstre;
    /**
     *  Option "ouvrir"
     */
    JMenuItem itemOpen;
    /**
     * Option "sauvegarder"
     */
    JMenuItem itemSave;
    /**
     *  Option "Quitter"
     */
    JMenuItem itemExit;
    /**
     * Option "Nouvel Astre"
     */
    JMenuItem itemAdd;
    /**
     * Option "Supprimer"
     */
    JMenuItem itemSuppr;
    /**
     *
     */
    private MyPanel pan_global;


    /**
     * Constructeur de la fenêtre principal
     * @param m
     *      Modèle de donnée
     * @throws IOException
     */
    public MainWindow(Model m) throws IOException{
        setTitle("Système Stellaire");
        setSize(1000, 700);
        setResizable(false);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = this.getContentPane();
        ControlMenu controlmenu = new ControlMenu(this,m);
        menuBar = new JMenuBar();
        menuFichier = new JMenu("Fichier");
        menuAstre = new JMenu("Astre");
        itemOpen = new JMenuItem("Ouvrir");
        itemOpen.addActionListener(controlmenu);
        itemSave = new JMenuItem("Enregistrer");
        itemSave.addActionListener(controlmenu);
        itemExit = new JMenuItem("Quitter");
        itemExit.addActionListener(controlmenu);
        itemAdd = new JMenuItem("Ajouter un astre");
        itemAdd.addActionListener(controlmenu);
        itemSuppr = new JMenuItem("Supprimer un astre");
        itemSuppr.addActionListener(controlmenu);
        menuFichier.add(itemOpen);
        menuFichier.add(itemSave);
        menuFichier.add(itemExit);
        menuAstre.add(itemAdd);
        menuAstre.add(itemSuppr);
        menuBar.add(menuFichier);
        menuBar.add(menuAstre);

        setLayout(new BorderLayout());

        pan_global = new MyPanel(m);
        pan_global.setLayout(null);

        c.add(pan_global, BorderLayout.CENTER);
        setContentPane(c);
        setJMenuBar(menuBar);
        setVisible(true);
    }

    /**
     * Remettre à jour l'UI
     */
    public void display(){
        pan_global.repaint();
    }
}
