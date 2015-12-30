package fr.system.solar;

import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controlleur de la fenêtre d'ajout d'un Astre
 *
 * @author Gilbert William, Tournoux Corentin
 * @version 1.0
 */
public class ControlDelWindow implements ActionListener {
    /**
     * Fenêtre de suppression
     */
    private DelWindow delWindow;
    /**
     * Modèle de donnée de l'application
     */
    private Model model;

    /**
     * Constructeur de la fenêtre de suppression
     *
     * @param delWindow
     *      Fenêtre de suppression
     * @param model
     *      Modèle de donnée
     */
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
