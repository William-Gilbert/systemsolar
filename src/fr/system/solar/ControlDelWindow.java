package fr.system.solar;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by coren_000 on 28/12/2015.
 */
public class ControlDelWindow implements ActionListener {
    private DelWindow delWindow;
    private Model model;

    public ControlDelWindow(DelWindow delWindow, Model model){
        this.delWindow = delWindow;
        this.model=model;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == delWindow.getBtDelete()){

            DefaultMutableTreeNode astreNode = (DefaultMutableTreeNode) delWindow.getJtLocation().getLastSelectedPathComponent();


            DefaultMutableTreeNode parentNode =(DefaultMutableTreeNode)  astreNode.getParent();
            if(astreNode.isRoot())
                return;

            Astre astre = (Astre) astreNode.getUserObject();
            if(parentNode.isRoot()){
                model.removeAstre(astre);
            }else{
                Astre parent = (Astre) parentNode.getUserObject();
                parent.removeAstre(astre);
            }




            delWindow.dispose(); // en attendant de remettre à jour
           // delWindow.jt =  delWindow.loadListOfAstre(model.getListOfAstre());





        }
    }
}
