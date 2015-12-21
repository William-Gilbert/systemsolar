package fr.system.solar;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
/**
 * Created by coren_000 on 08/12/2015.
 */
public class AddWindow extends JFrame {
    private JButton createAstre;
    private ArrayList<JTextField> tfAdd;
    private JCheckBox chSatellite;
    private JPanel panSat;

    JPanel main;
    //Premiere couche
    JPanel p1;
    JLabel name;
    private JTextField textName;
    //Deuxieme couche
    JPanel p2;
    JLabel nameSat;

    JList astreList;
    //Troisieme couche

    JLabel a;
    private JTextField axeA;
    JLabel b;
    private JTextField axeB;
    JLabel revo;
    private JTextField revolution;
    //Quatrieme couche
    JPanel p4;
    JLabel x;
    private JTextField axeX;
    JLabel y;
    private JTextField axeY;


    public AddWindow(Model m) throws IOException {
        setTitle("Système Solaire");
        setSize(800, 600);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        tfAdd = new ArrayList<>();
        ControlAddWindow ctrlAdd = new ControlAddWindow(m, this);

        main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
        p1 = new JPanel();
        p1.setLayout(new FlowLayout());
        name = new JLabel("nom de l'astre :");
        JTextField tfName = new JTextField();
        tfAdd.add(tfName);
        tfName.setColumns(10);
        p1.add(name);
        p1.add(tfName);

        p2 = new JPanel();
        p2.setLayout(new FlowLayout());
        nameSat = new JLabel("Satellite :");
        chSatellite = new JCheckBox();
        chSatellite.addActionListener(ctrlAdd);


        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Système");
        for(Astre a : m.getListOfAstre()){
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(a.getNom());
            rec(node,a);
            root.add(node);
        }

        JTree tre = new JTree(root);

        /*List<Astre> lista = m.getListOfAstre();
        DefaultListModel modeleList = new DefaultListModel();
        astreList = new JList();

        if(lista.size()>0) {
            for(int i=0; i<lista.size(); i++){
                modeleList.addElement(lista.get(i).getNom());
                List<Astre> listeS = lista.get(i).getListOfSatellites();
                DefaultListModel modelListSat = new DefaultListModel();
                for(int j=0;j< listeS.size();j++){
                    modelListSat.addElement(listeS.get(j).getNom());
                }
                modeleList.addElement(modelListSat);
            }
        }
        astreList.setModel(modeleList);*/
        p2.add(chSatellite);
        p2.add(nameSat);
        p2.add(tre);
        //p2.add(astreList);






        panSat = new JPanel();
        panSat.setLayout(new FlowLayout());
        a = new JLabel("Demi grand axe A :");
        JTextField axeA = new JTextField();
        axeA.setColumns(10);
        tfAdd.add(axeA);

        b = new JLabel("Demi grand axe B :");
        JTextField axeB = new JTextField();
        axeB.setColumns(10);
        tfAdd.add(axeB);

        revo = new JLabel("Période de révolution :");
        JTextField revolution = new JTextField();
        revolution.setColumns(10);
        tfAdd.add(revolution);

        panSat.add(a);
        panSat.add(axeA);
        panSat.add(b);
        panSat.add(axeB);
        panSat.add(revo);
        panSat.add(revolution);
        panSat.setVisible(false);





        p4 = new JPanel();
        p4.setLayout(new FlowLayout());
        x = new JLabel("X :");
        JTextField axeX = new JTextField();
        axeX.setColumns(10);
        tfAdd.add(axeX);

        y = new JLabel("Y :");
        JTextField axeY = new JTextField();
        axeY.setColumns(10);
        tfAdd.add(axeY);

        p4.add(x);
        p4.add(axeX);
        p4.add(y);
        p4.add(axeY);

        createAstre = new JButton("Ajouter");

        createAstre.addActionListener(ctrlAdd);


        main.add(p1);
        main.add(p2);
        main.add(panSat);
        main.add(p4);
        main.add(createAstre);
        setContentPane(main);
    }

    private void rec(DefaultMutableTreeNode noeud, Astre astre){
        for(Astre a : astre.getListOfSatellites()){
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(a.getNom());
            rec(node, a);
            noeud.add(node);
        }
    }

    public JButton getCreateAstre(){
        return createAstre;
    }

    public ArrayList<JTextField> getTfAdd(){
        return tfAdd;
    }

    public JCheckBox getChSatellite(){
        return chSatellite;
    }

    public JPanel getPanSat(){
        return panSat;
    }
}
