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
     *  Option "ouvrir"
     */
    private JMenuItem itemOpen;
    /**
     * Option "sauvegarder"
     */
    private JMenuItem itemSave;
    /**
     *  Option "Quitter"
     */
    private JMenuItem itemExit;
    /**
     * Option "Nouvel Astre"
     */
    private JMenuItem itemAdd;
    /**
     * Option "Supprimer"
     */
    private JMenuItem itemSuppr;

    /**
     *  Panel de la fenêtre
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
        JMenuBar menuBar = new JMenuBar();
        JMenu menuFichier = new JMenu("Fichier");
        JMenu menuAstre = new JMenu("Astre");
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

    /**
     * Récupère l'item "Ouvrir"
     * @return
     *      L'objet "Ouvrir" du JMenu
     */
    public JMenuItem getItemOpen() {
        return itemOpen;
    }

    /**
     * Récupère l'item "Sauvegarder"
     * @return
     *      L'objet "Sauvegarder" du JMenu
     */
    public JMenuItem getItemSave() {
        return itemSave;
    }

    /**
     * Récupère l'item "Quitter"
     * @return
     *      L'objet "Quitter" du JMenu
     */
    public JMenuItem getItemExit() {
        return itemExit;
    }

    /**
     * Récupère l'item "Ajouter"
     * @return
     *      L'objet "Ajouter" du JMenu
     */
    public JMenuItem getItemAdd() {
        return itemAdd;
    }

    /**
     * Récupère l'item "Supprimer"
     * @return
     *      L'objet "Supprimer" du JMenu
     */
    public JMenuItem getItemSuppr() {
        return itemSuppr;
    }
}
