package fr.system.solar;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.util.List;

/**
 * Réagit aux actions de l'utilisateur
 *
 * @author Gilbert William, Tournoux Corentin
 * @version 1.0
 */

public class DelWindow extends JFrame {
    /**
     *  Bouton de validation de la suppression
     */
    private JButton btDelValider;
    /**
     * JTree pour consulter les astres
     */
    private JTree jtLocation;


    /**
     * Constructeur de la fenêtre
     * @param m
     *      Modèle de donnée
     */
    public DelWindow(Model m){
        JPanel pan1 = new JPanel();
        JPanel pan2 = new JPanel();
        JPanel pan3 = new JPanel();
        JPanel main = new JPanel();
        ControlDelWindow controldelwindow = new ControlDelWindow(this,m);

        // Fenêtre
        setTitle("Supprimer un astre");
        setSize(400, 300);
        setLocation(200,200);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);


        pan1.setLayout(new FlowLayout());
        JLabel text = new JLabel("Supprimer un astre");
        pan1.add(text);

        jtLocation = loadListOfAstre(m.getListOfAstre());
        jtLocation.setPreferredSize(new Dimension(200,200));
        pan2.setLayout(new FlowLayout());
        pan2.add(jtLocation);

        btDelValider = new JButton("Supprimer un astre");
        btDelValider.addActionListener(controldelwindow);
        pan3.setLayout(new FlowLayout());
        pan3.add(btDelValider);

        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
        main.add(pan1);
        main.add(pan2);
        main.add(pan3);

        setContentPane(main);

    }

    /**
     * Création de la JTree du système stellaire
     * @param lista
     *      Liste de satellite
     * @return
     *      Un JTree correspondant au modèle de donnée
     */
    public JTree loadListOfAstre(List<Astre> lista){
        JTree tr;
        DefaultTreeModel dtm;
        DefaultMutableTreeNode racine;
        dtm = new DefaultTreeModel(racine = new DefaultMutableTreeNode("Système stellaire"));
        tr = new JTree(dtm);
        if(lista.size()>0) {
            DefaultMutableTreeNode test = parcours(lista,racine);
        }


        return tr;
    }

    /**
     * Parcours récursif des satellites et ajout de ceux si dans le JTree
     *
     * @param list
     *      Liste de satellite
     * @param dmtn
     *      Noeud à développer
     * @return
     *      Objet pour créer un JTree
     */
    public DefaultMutableTreeNode parcours(List<Astre> list,DefaultMutableTreeNode dmtn){
        for(int i=0;i<list.size();i++){
            DefaultMutableTreeNode astrecourant = new DefaultMutableTreeNode(list.get(i));
            if(list.get(i).getListOfSatellites()!=null){
                parcours(list.get(i).getListOfSatellites(),astrecourant);
            };
            dmtn.add(astrecourant);
        }
        return dmtn;
    }


    /**
     * Récupère le bouton de validation de la suppression
     * @return
     *      Bouton de validation
     */
    public JButton getBtDelete(){
        return btDelValider;
    }

    /**
     * Récupère le JTree de suppression
     * @return
     *      Le JTree de la suppression
     */
    public JTree getJtLocation(){
        return jtLocation;
    }
}

