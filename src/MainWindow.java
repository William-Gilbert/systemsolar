import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Window est la classe qui permet la création de la fenêtre
 * @author Gilbert W
 * @author  Tournoux C
 */
public class MainWindow extends JFrame {
    JMenuBar menuBar;
    JMenu menuFichier;
    JMenu menuAstre;
    JMenuItem itemOpen;
    JMenuItem itemSave;
    JMenuItem itemExit;
    JMenuItem itemAdd;
    JMenuItem itemSuppr;
    ControlMenu controlmenu;


    public MainWindow(Model m) throws IOException{
        setTitle("Système Solaire");
        setSize(1000, 700);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = this.getContentPane();
        controlmenu = new ControlMenu(this,m);
        menuBar = new JMenuBar();
        menuFichier = new JMenu("Fichier");
        menuAstre = new JMenu("Astre");
        itemOpen = new JMenuItem("Ouvrir");
        itemSave = new JMenuItem("Enregistrer");
        itemExit = new JMenuItem("Quitter");
        itemAdd = new JMenuItem("Ajouter un astre");
        itemAdd.addActionListener(controlmenu);
        itemSuppr = new JMenuItem("Supprimer un astre");
        menuFichier.add(itemOpen);
        menuFichier.add(itemSave);
        menuFichier.add(itemExit);
        menuAstre.add(itemAdd);
        menuAstre.add(itemSuppr);
        menuBar.add(menuFichier);
        menuBar.add(menuAstre);
        setJMenuBar(menuBar);

        c.add(new MyPanel());
        setContentPane(c);
    }
}
