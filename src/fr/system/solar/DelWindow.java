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
    private JButton btDelValider;
    private JTree jtLocation;


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


    public JButton getBtDelete(){
        return btDelValider;
    }

    public JTree getJtLocation(){
        return jtLocation;
    }
}

