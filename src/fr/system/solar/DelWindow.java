package fr.system.solar;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.util.List;

/**
 * Created by coren_000 on 25/12/2015.
 */
public class DelWindow extends JFrame {
    JPanel main;
    JPanel pan1;
    JPanel pan2;
    JPanel pan3;
    JButton btDelValider;
    ControlDelWindow controldelwindow;
    JLabel text;
    JTree jt;
    Dimension dimension;
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
    public DelWindow(Model m){
        pan1= new JPanel();
        pan2= new JPanel();
        pan3= new JPanel();
        controldelwindow = new ControlDelWindow(this,m);
        setTitle("Supprimmer un astre");
        setSize(400, 300);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        dimension=new Dimension(200,200);
        main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
        pan1.setLayout(new FlowLayout());
        text = new JLabel("Supprimmer un astre");
        pan1.add(text);
        List<Astre> lista = m.getListOfAstre();
        DefaultTreeModel dtm;

        DefaultMutableTreeNode racine;
        dtm = new DefaultTreeModel(racine = new DefaultMutableTreeNode("Astres de l'univers"));
        jt = new JTree(dtm);
        if(lista.size()>0) {
            DefaultMutableTreeNode test = parcours(lista,racine);
        }
        jt.setPreferredSize(dimension);
        pan2.setLayout(new FlowLayout());
        pan2.add(jt);
        btDelValider = new JButton("Suprimmer un astre");
        btDelValider.addActionListener(controldelwindow);
        pan3.setLayout(new FlowLayout());
        pan3.add(btDelValider);
        main.add(pan1);
        main.add(pan2);
        main.add(pan3);
        setContentPane(main);

    }
}

