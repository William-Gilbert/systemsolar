package fr.system.solar;

import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by coren_000 on 28/12/2015.
 */
public class ControlDelWindow implements ActionListener {
    DelWindow delWindow;
    Model model;

    public ControlDelWindow(DelWindow delWindow, Model m){
        this.delWindow = delWindow;
        model=m;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == delWindow.btDelValider){
            DefaultMutableTreeNode dmtn = (DefaultMutableTreeNode) delWindow.jt.getLastSelectedPathComponent();
            Astre astre = (Astre) dmtn.getUserObject();
            astre.removeAstre();
            if(astre instanceof Etoile){
               model.removeAstre(astre);
            }
            else if(astre instanceof Satellite){
                System.out.println("sat");
            }

        }
    }
}
