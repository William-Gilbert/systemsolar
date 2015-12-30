package fr.system.solar;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Controlleur de la fenêtre d'ajout d'un Astre
 *
 * @author Gilbert William, Tournoux Corentin
 * @version 1.0
 */
public class ControlAddWindow implements ActionListener {
    /**
     *  Fenêtre d'ajout
     */
    private AddWindow addWindow;
    /**
     *  Modèle de donnée
     */
    private Model model;

    /**
     * Constructeur du controlleur de la classe AddWindow
     *
     * @param mainWindow
     *      Fenêtre lié au controlleur
     * @param m
     *      Modèle de donnée
     */
    public ControlAddWindow(AddWindow mainWindow, Model m) {
        this.addWindow = mainWindow;
        model = m;
    }

    public void actionPerformed(ActionEvent a) {
        if(a.getSource() == addWindow.getCheckBoxSat()){
            hide();
        }
        else if(a.getSource() == addWindow.getBtValider()){
            add();
        }
        else if(a.getSource() == addWindow.getBtImage()){
            selectAnImage();
        }
    }


    /**
     *  Méhtode pour afficher le panel de création d'étoile ou de satellite
     */
    private void hide(){
        if(addWindow.getCheckBoxSat().isSelected()){
            addWindow.getPanSat().setVisible(true);
            addWindow.getPanEtoile().setVisible(false);
            addWindow.getJtLocation().setEnabled(true);
            addWindow.getJtLocation().setVisible(true);
        }
        else{
            addWindow.getPanSat().setVisible(false);
            addWindow.getPanEtoile().setVisible(true);
            addWindow.getJtLocation().setEnabled(false);
            addWindow.getJtLocation().setVisible(false);
        }
    }

    /**
     *   Permet d'ouvrir un explorateur pour sélectionner une image
     */
    private void selectAnImage(){
        JFileChooser choix = new JFileChooser("image");
        int retour = choix.showOpenDialog(addWindow);
        if(retour == JFileChooser.APPROVE_OPTION){
            File file = choix.getSelectedFile();
            addWindow.getPathImg().setText(file.getName());
        }
    }

    /**
     *  Méthode pour ajouter un astre au modèle.
     */
    private void add(){
        String nom = addWindow.getTfs().get(0).getText();
        String imgPath = addWindow.getPathImg().getText();

        /* Vérification */
        if(addWindow.getTfs().get(0).getText().equals("")){
            JOptionPane.showMessageDialog(addWindow, "Champ vide", "Création", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(addWindow.getPanEtoile().isVisible()){
            if(addWindow.getTfs().get(4).getText().equals("")  ||addWindow.getTfs().get(5).getText().equals("") ){
                JOptionPane.showMessageDialog(addWindow, "Champ vide", "Création", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }else{
            if(addWindow.getTfs().get(1).getText().equals("")  || addWindow.getTfs().get(2).getText().equals("") ||
                addWindow.getTfs().get(3).getText().equals("") ){
                JOptionPane.showMessageDialog(addWindow, "Champ vide", "Création", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }


        if (addWindow.getCheckBoxSat().isSelected()){
            DefaultMutableTreeNode dmtn = (DefaultMutableTreeNode) addWindow.getJtLocation().getLastSelectedPathComponent();
            Astre astre = (Astre) dmtn.getUserObject();
            int demiGrandAxe = Integer.parseInt(addWindow.getTfs().get(1).getText());
            int demiPetiteAxe = Integer.parseInt(addWindow.getTfs().get(2).getText());
            int periodeRotation = Integer.parseInt(addWindow.getTfs().get(3).getText());

            try {
                astre.addSatellite(model.generateId(),nom,imgPath,demiGrandAxe,demiPetiteAxe,periodeRotation);
            } catch (ExceptionUnknowAstre exceptionUnknowAstre) {
                exceptionUnknowAstre.printStackTrace();
            }
        }
        else{
            int x = Integer.parseInt(addWindow.getTfs().get(4).getText());
            int y = Integer.parseInt(addWindow.getTfs().get(5).getText());
            Astre ast=null;

            try {
                ast = new Etoile(model.generateId(),nom,imgPath,x,y);
            } catch (ExceptionUnknowAstre exceptionUnknowAstre) {
                exceptionUnknowAstre.printStackTrace();
            }
            model.addAstre(ast);


        }

        addWindow.dispose();
    }

}

