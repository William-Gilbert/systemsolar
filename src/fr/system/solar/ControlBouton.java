package fr.system.solar;

import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by coren_000 on 09/12/2015.
 */
public class ControlBouton implements ActionListener {
    AddWindow addWindow;
    Model model;
    public ControlBouton(AddWindow mainWindow,Model m) {
        this.addWindow = mainWindow;
        model = m;
    }

    public void actionPerformed(ActionEvent a) {
        if(a.getSource() == addWindow.sat){
            if(addWindow.sat.isSelected()){
                addWindow.axeX.setEnabled(false);
                addWindow.axeY.setEnabled(false);
                addWindow.jt.setEnabled(true);
                addWindow.axeA.setEnabled(true);
                addWindow.axeB.setEnabled(true);
                addWindow.revolution.setEnabled(true);
            }
            else{
                addWindow.axeX.setEnabled(true);
                addWindow.axeY.setEnabled(true);
                addWindow.jt.setEnabled(false);
                addWindow.axeA.setEnabled(false);
                addWindow.axeB.setEnabled(false);
                addWindow.revolution.setEnabled(false);
            }
        }
        else if(a.getSource() == addWindow.btValider){
            String nom = addWindow.textName.getText();
            if(addWindow.sat.isSelected()){
                DefaultMutableTreeNode dmtn = (DefaultMutableTreeNode) addWindow.jt.getLastSelectedPathComponent();
                Astre astre = (Astre) dmtn.getUserObject();
                int demiGrandAxe = Integer.parseInt(addWindow.axeA.getText());
                int demiPetiteAxe = Integer.parseInt(addWindow.axeB.getText());
                int periodeRotation = Integer.parseInt(addWindow.revolution.getText());
                try {
                    astre.addSatellite(model.generateId(),nom,"asteroide.png",demiGrandAxe,demiPetiteAxe,periodeRotation);
                } catch (ExceptionUnknowAstre exceptionUnknowAstre) {
                    exceptionUnknowAstre.printStackTrace();
                }
            }
            else{
                int x = Integer.parseInt(addWindow.axeX.getText());
                int y = Integer.parseInt(addWindow.axeY.getText());
                Astre ast=null;
                try {
                    ast = new Etoile(model.generateId(),nom,"asteroide.png",x,y);
                } catch (ExceptionUnknowAstre exceptionUnknowAstre) {
                    exceptionUnknowAstre.printStackTrace();
                }
                model.addAstre(ast);


            }
        }
    }

}

