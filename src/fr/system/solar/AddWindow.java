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
    JPanel main;
    ControlBouton controlbouton;
    //Premiere couche
    JPanel p1;
    JLabel name;
    JTextField textName;
    //Deuxieme couche
    JPanel p2;
    JLabel nameSat;
    JCheckBox sat;
    JTree jt;
    //Troisieme couche
    JPanel p3;
    JLabel a;
    JTextField axeA;
    JLabel b;
    JTextField axeB;
    JLabel revo;
    JTextField revolution;
    //Quatrieme couche
    JPanel p4;
    JLabel x;
    JTextField axeX;
    JLabel y;
    JTextField axeY;
    //Cinquieme couche
    JPanel p5;
    JButton btValider;
    JPanel image;
    JButton btImage;
    JLabel pre;
    JLabel nom;
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

    public AddWindow(Model m) throws IOException {
        controlbouton = new ControlBouton(this,m);
        setTitle("Ajouter un astre");
        setSize(800, 600);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
        p1 = new JPanel();
        p1.setLayout(new FlowLayout());
        name = new JLabel("nom de l'astre :");
        textName = new JTextField();
        textName.setColumns(10);
        p1.add(name);
        p1.add(textName);

        p2 = new JPanel();
        p2.setLayout(new FlowLayout());
        nameSat = new JLabel("Satellite :");
        sat = new JCheckBox();
        sat.addActionListener(controlbouton);
        p2.add(sat);
        p2.add(nameSat);
        List<Astre> lista = m.getListOfAstre();
        DefaultTreeModel dtm;

        DefaultMutableTreeNode racine;
        dtm = new DefaultTreeModel(racine = new DefaultMutableTreeNode("Astres de l'univers"));
        jt = new JTree(dtm);
        if(lista.size()>0) {
            DefaultMutableTreeNode test = parcours(lista,racine);
        }
        p2.add(jt);



        p3 = new JPanel();
        p3.setLayout(new FlowLayout());
        a = new JLabel("Demi grand axe A :");
        axeA = new JTextField();
        axeA.setColumns(10);
        b = new JLabel("Demi grand axe B :");
        axeB = new JTextField();
        axeB.setColumns(10);
        revo = new JLabel("Période de révolution :");
        revolution = new JTextField();
        revolution.setColumns(10);
        p3.add(a);
        p3.add(axeA);
        p3.add(b);
        p3.add(axeB);
        p3.add(revo);
        p3.add(revolution);

        p4 = new JPanel();
        p4.setLayout(new FlowLayout());
        x = new JLabel("X :");
        axeX = new JTextField();
        y = new JLabel("Y :");
        axeY = new JTextField();
        axeX.setColumns(10);
        axeY.setColumns(10);
        p4.add(x);
        p4.add(axeX);
        p4.add(y);
        p4.add(axeY);
        image = new JPanel();
        image.setLayout(new FlowLayout());
        btImage = new JButton("Choisir une image");
        btImage.addActionListener(controlbouton);
        image.add(btImage);
        p5=new JPanel();
        p5.setLayout(new FlowLayout());
        btValider = new JButton("Ajouter un astre");
        btValider.addActionListener(controlbouton);
        pre = new JLabel("Image : ");
        nom = new JLabel(" ");
        image.add(pre);
        image.add(nom);
        p5.add(btValider);


        main.add(p1);
        main.add(p2);
        main.add(p3);
        main.add(p4);
        main.add(image);
        main.add(p5);
        setContentPane(main);
        axeX.setEnabled(true);
        axeY.setEnabled(true);
        jt.setEnabled(false);
        axeA.setEnabled(false);
        axeB.setEnabled(false);
        revolution.setEnabled(false);
    }


    private void rec(DefaultMutableTreeNode noeud, Astre astre){
        for(Astre a : astre.getListOfSatellites()){
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(a.getNom());
            rec(node, a);
            noeud.add(node);
        }
    }
}
