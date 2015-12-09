import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by coren_000 on 08/12/2015.
 */
public class AddWindow extends JFrame {
    JPanel main;
    //Premiere couche
    JPanel p1;
    JLabel name;
    JTextField textName;
    //Deuxieme couche
    JPanel p2;
    JLabel nameSat;
    JCheckBox sat;
    JList astreList;
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
    public AddWindow(Model m) throws IOException {
        setTitle("Système Solaire");
        setSize(800, 600);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        List<Astre> lista = m.getListOfAstre();
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
        astreList.setModel(modeleList);
        p2.add(sat);
        p2.add(nameSat);
        p2.add(astreList);


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
        main.add(p1);
        main.add(p2);
        main.add(p3);
        main.add(p4);
        setContentPane(main);
    }
}
