package fr.system.solar;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Fenêtre d'ajout d'un astre
 *
 * @author Gilbert William, Tournoux Corentin
 * @version 1.0
 */

public class AddWindow extends JFrame {
    /**
     *  Un liste de JTextField. Pour éviter d'avoir x getters.
     */
    private ArrayList<JTextField> tfs;
    /**
     *  Un JTree pour choisir l'astre sur quel sera ajouté en orbite le nouvel astre.
     */
    private JTree jtLocation;
    /**
     *  String vers une image pour l'associé au nouvel astre.
     */
    private JLabel pathImg;
    /**
     *  Panel de création d'une étoile.
     */
    private JPanel p3;
    /**
     *  Panel de création d'un satellite.
     */
    private JPanel p4;
    /**
     *  CheckBox pour créer ou non un astre.
     */
    private JCheckBox sat;
    /**
     *      Bouton pour valider la création d'un Astre.
     */
    private JButton btValider;
    /**
     *      Bouton pour ouvrir une fenêtre d'exploration.
     */
    private JButton btImage;


    /**
     *  Constructeur de la fenêtre.
     *
     * @param m
     *      Modèle de l'application.
     * @throws IOException
     */
    public AddWindow(Model m) throws IOException {
        tfs = new ArrayList<JTextField>();
        ControlAddWindow ctrlAddW = new ControlAddWindow(this,m);

        setTitle("Ajouter un astre");
        setSize(800, 600);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        JPanel p1 = createPan1();
        JPanel p2 = createPan2(ctrlAddW, m);
        p3 = createPan3();
        p4 = createPan4();
        JPanel image = createPanImg(ctrlAddW);
        JPanel p5 = createPan5(ctrlAddW);
        JPanel main = createPanMain(p1,p2,image,p5);
        setContentPane(main);

    }


    /**
     *  Créer le panel principal de la fenêtre.
     *
     * @param p1
     *      Panel de création du nom de l'astre.
     * @param p2
     *      Panel de la checkbox.
     * @param image
     *      Panel du choix de l'image.
     * @param p5
     *      Panel du bouton de validation
     * @return
     *      Le Panel principal
     */
    private JPanel createPanMain(JPanel p1, JPanel p2, JPanel image, JPanel p5){
        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));

        main.add(p1);
        main.add(p2);
        main.add(p3);
        main.add(p4);
        main.add(image);
        main.add(p5);
        return main;
    }

    /**
     * Créer le panel de création du nom de l'Astre
     *
     * @return
     *      Le panel 1
     */
    private JPanel createPan1(){
        JPanel p1 = new JPanel();
        p1.setLayout(new FlowLayout());
        JLabel name = new JLabel("Nom :");
        JTextField textName = new JTextField();
        textName.setColumns(10);
        tfs.add(textName);
        p1.add(name);
        p1.add(textName);
        return p1;
    }

    /**
     * Créer le panel du bouton de validation.
     *
     * @param ctrlAddW
     *      Le controlleur du bouton.
     * @return
     *      Le Panel
     */
    private JPanel createPan5(ControlAddWindow ctrlAddW){
        JPanel p5 =new JPanel();
        p5.setLayout(new FlowLayout());
        btValider = new JButton("Ajouter un astre");
        btValider.addActionListener(ctrlAddW);

        p5.add(btValider);
        return p5;
    }

    /**
     * Créer le Panel ou on choisi l'image de l'Astre
     * @param ctrlAddW
     *      Controlleur du bouton.
     * @return
     *      Le Panel du choix de l'image
     */
    private JPanel createPanImg(ControlAddWindow ctrlAddW){
        JPanel image = new JPanel();
        image.setLayout(new FlowLayout());
        btImage = new JButton("Choisir une image");
        btImage.addActionListener(ctrlAddW);
        image.add(btImage);
        pathImg = new JLabel(" ");
        image.add(pathImg);
        return image;
    }

    /**
     * Créer le panel de création d'une étoile.
     * @return
     *      Le Panel de création d'une étoile.
     */
    private JPanel createPan4(){
        JPanel p = new JPanel();
        p.setLayout(new FlowLayout());

        JTextField axeX = new JTextField();
        axeX.setColumns(10);
        tfs.add(axeX);

        JTextField axeY = new JTextField();
        axeY.setColumns(10);
        tfs.add(axeY);

        p.add(new JLabel("Position X :"));
        p.add(axeX);
        p.add(new JLabel("Position Y :"));
        p.add(axeY);

        return p;
    }

    /**
     * Créer le Panel de création d'un satellite.
     * @return
     *      Le Panel de création d'un satellite.
     */
    private JPanel createPan3(){
        JPanel p = new JPanel();
        p.setLayout(new FlowLayout());

        JTextField axeA = new JTextField();
        axeA.setColumns(10);
        tfs.add(axeA);

        JTextField axeB = new JTextField();
        axeB.setColumns(10);
        tfs.add(axeB);

        JTextField revolution = new JTextField();
        revolution.setColumns(10);
        tfs.add(revolution);

        p.add(new JLabel("Demi grand axe A :"));
        p.add(axeA);
        p.add(new JLabel("Demi grand axe B :"));
        p.add(axeB);
        p.add(new JLabel("Période de révolution :"));
        p.add(revolution);
        p.setVisible(false);

        return p;
    }

    /**
     * Créer le panel de la check box.
     *
     * @param ctrlAddW
     *      Controlleur de la checkbox.
     * @param m
     *      Modèle de donnée utilisé par le JTree.
     * @return
     *  Le Panel de création d'un satellite.
     */
    private JPanel createPan2(ControlAddWindow ctrlAddW,Model m){
        JPanel p2 = new JPanel();
        p2.setLayout(new FlowLayout());

        sat = new JCheckBox();
        sat.addActionListener(ctrlAddW);
        jtLocation = loadListOfAstre(m.getListOfAstre());
        jtLocation.setVisible(false);

        p2.add(sat);
        p2.add(new JLabel("Satellite"));
        p2.add(jtLocation);

        return p2;
    }

    /**
     * Renvoie un Arbre avec la liste des satellites écrit récursiveemnt.
     *
     * @param list
     *      Liste des satellites d'un astre.
     * @param dmtn
     *      Un Noeud acorrespondant à l'astre courant.
     * @return
     *      Le même noeud qu'en entré mais avec ces satellites indiqué.
     */
    public DefaultMutableTreeNode parcours(List<Astre> list,DefaultMutableTreeNode dmtn){
        if(list!=null) {
            for (int i = 0; i < list.size(); i++) {
                DefaultMutableTreeNode astrecourant = new DefaultMutableTreeNode(list.get(i));
                if (list.get(i).getListOfSatellites() != null) {
                    parcours(list.get(i).getListOfSatellites(), astrecourant);
                }
                dmtn.add(astrecourant);
            }

        }
        return dmtn;
    }

    /**
     *  Permet de recharger le JTree
     * @param lista
     *      Liste de satellite.
     * @return
     *      Un JTree représentant le système.
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
     * Renvoie la listes des textfields de la fenêtre
     * @return
     *      Renvoie la listes des textsfield de la fenêtre
     */
    public ArrayList<JTextField> getTfs(){
        return tfs;
    }

    /**
     *  Renvoie le chemin vers l'image de l'astre
     * @return
     *      Renvoie le chemin vers l'image de l'astre
     */
    public JLabel getPathImg(){
        return pathImg;
    }

    /**
     *  Renvoie le JTree de la fenêtre
     * @return
     *      JTree repérésent le modèle de donnée
     */
    public JTree getJtLocation(){
        return jtLocation;
    }

    /**
     *  Le Panel de création du satellite
     * @return
     *      Le Panel de création du satellite
     */
    public JPanel getPanSat(){
        return p3;
    }

    /**
     * Le Panel de création du'une étoile
     *
     * @return
     *      Le Panel de création du'une étoile
     */
    public JPanel getPanEtoile(){
        return p4;
    }

    /**
     * Le bouton de parcours d'image
     * @return
     *      Le bouton de parcours d'image
     */
    public JButton getBtImage(){
        return btImage;
    }

    /**
     * Le bouton de validation.
     *
     * @return
     *      Le bouton de validation.
     */
    public JButton getBtValider(){
        return btValider;
    }

    /**
     * Le CheckBox de création de sattelite.
     * @return
     *  Le CheckBox de création de sattelite.
     */
    public JCheckBox getCheckBoxSat(){
        return sat;
    }
}
