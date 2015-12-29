package fr.system.solar;
import javax.naming.ldap.Control;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * Created by coren_000 on 08/12/2015.
 */
public class AddWindow extends JFrame {
    private ArrayList<JTextField> tfs;
    private JTree jtLocation;
    private JLabel pathImg;
    private JPanel p3;
    private JPanel p4;
    private JCheckBox sat;
    private JButton btValider;
    private JButton btImage;




    public AddWindow(Model m) throws IOException {
        tfs = new ArrayList<JTextField>();
        ControlBouton controlbouton = new ControlBouton(this,m);

        setTitle("Ajouter un astre");
        setSize(800, 600);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        JPanel p1 = new JPanel();
        p1.setLayout(new FlowLayout());
        JLabel name = new JLabel("nom de l'astre :");
        JTextField textName = new JTextField();
        textName.setColumns(10);
        tfs.add(textName);
        p1.add(name);
        p1.add(textName);

        JPanel p2 = new JPanel();
        p2.setLayout(new FlowLayout());

        sat = new JCheckBox();
        sat.addActionListener(controlbouton);
        jtLocation = loadListOfAstre(m.getListOfAstre());
        jtLocation.setEnabled(false);

        p2.add(sat);
        p2.add(new JLabel("Satellite :"));
        p2.add(jtLocation);




        p3 = new JPanel();
        p3.setLayout(new FlowLayout());

        JTextField axeA = new JTextField();
        axeA.setColumns(10);
        tfs.add(axeA);

        JTextField axeB = new JTextField();
        axeB.setColumns(10);
        tfs.add(axeB);


        JTextField revolution = new JTextField();
        revolution.setColumns(10);
        tfs.add(revolution);

        p3.add(new JLabel("Demi grand axe A :"));
        p3.add(axeA);
        p3.add(new JLabel("Demi grand axe B :"));
        p3.add(axeB);
        p3.add(new JLabel("Période de révolution :"));
        p3.add(revolution);
        p3.setVisible(false);



        p4 = new JPanel();
        p4.setLayout(new FlowLayout());

        JTextField axeX = new JTextField();
        axeX.setColumns(10);
        tfs.add(axeX);

        JTextField axeY = new JTextField();
        axeY.setColumns(10);
        tfs.add(axeY);

        p4.add(new JLabel("Position X :"));
        p4.add(axeX);
        p4.add(new JLabel("Position Y :"));
        p4.add(axeY);


        JPanel image = new JPanel();
        image.setLayout(new FlowLayout());
        btImage = new JButton("Choisir une image");
        btImage.addActionListener(controlbouton);
        image.add(btImage);

        JPanel p5=new JPanel();
        p5.setLayout(new FlowLayout());
        btValider = new JButton("Ajouter un astre");
        btValider.addActionListener(controlbouton);

        pathImg = new JLabel(" ");
        image.add(pathImg);
        p5.add(btValider);


        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));

        main.add(p1);
        main.add(p2);
        main.add(p3);
        main.add(p4);
        main.add(image);
        main.add(p5);
        setContentPane(main);



    }

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

    public ArrayList<JTextField> getTfs(){
        return tfs;
    }

    public JLabel getPathImg(){
        return pathImg;
    }

    public JTree getJtLocation(){
        return jtLocation;
    }

    public JPanel getPanSat(){
        return p3;
    }

    public JPanel getPanEtoile(){
        return p4;
    }

    public JButton getBtImage(){
        return btImage;
    }

    public JButton getBtValider(){
        return btValider;
    }

    public JCheckBox getCheckBoxSat(){
        return sat;
    }
}
