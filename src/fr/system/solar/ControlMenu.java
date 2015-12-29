package fr.system.solar;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 * Réagit aux actions de l'utilisateur
 *
 * @author Gilbert William, Tournoux Corentin
 * @version 1.0
 */

public class ControlMenu implements ActionListener {
    /**
     *
     */
    MainWindow mainWindow;
    /**
     *
     */
    Model model;


    /**
     * Constructeur
     *
     * @param mainWindow
     *      Fenêtre principale de l'application
     * @param m
     *      Modèle de donnée de l'application
     */
    public ControlMenu(MainWindow mainWindow, Model m) {
        this.mainWindow = mainWindow;
        this.model = m;
    }

    public void actionPerformed(ActionEvent a) {
        if(a.getSource() == mainWindow.itemAdd){
            add();
        }
        else if(a.getSource() == mainWindow.itemSuppr){
            DelWindow del = new DelWindow(model);
        }
        else if(a.getSource() == mainWindow.itemSave){
            sauvegarde();
        }
        else if(a.getSource() == mainWindow.itemOpen){
            open();
        }
        else if(a.getSource() == mainWindow.itemExit){
            System.exit(0);
        }
    }

    /**
     * Permet d'ouvrir une fenêtre de gestion d'ajout des astres
     */
    private void add(){
        try {
            AddWindow nouv = new AddWindow(model);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Permet d'ouvrir un astre enregistré sur le disque
     */
    private void open(){
        JFileChooser choix = new JFileChooser("dat");
        int retour = choix.showOpenDialog(mainWindow);
        if(retour == JFileChooser.APPROVE_OPTION){

            if(model.open(choix.getSelectedFile().getAbsolutePath()) == 1) {
                JOptionPane.showMessageDialog(null, "L'étoile est ouverte dans l'application", "Ouverture", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "L'étoile est déjà ouverte", "Ouverture", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    /**
     * Permet de sauvegarder un astre sur le disque
     */
    private void sauvegarde(){

        try{
            Astre astreASauvegarder = whichAstreToSave();
            while(secureSave(astreASauvegarder)); // Faire réapparaître la fenêtre dans les cas d'échec de sauvegarde

        }catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Problèmes\nLa sauvegarde à échoué.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }


    /**
     * Permet de choisir quel Astre l'utilisateur veut sauvegarder
     *
     * @return
     *      L'astre que l'utilisateur a choisi
     */
    private Astre whichAstreToSave(){

        /* Select box pour savoir quel astre enregistrer */
        int size =  model.getListOfAstre().size();
        String[] label = new String[size];
        for(int i = 0 ; i < size ; i++){
            label[i] = model.getAstre(i).getId() + " "+model.getAstre(i).getNom();
        }
        JOptionPane jop = new JOptionPane();
        String nom = (String)jop.showInputDialog(null,"Veuillez sélectionner l'étoile à enregistrer","Enregistrement",
                JOptionPane.QUESTION_MESSAGE,null, label, label[0]);

        return model.getAstre(Integer.parseInt(nom.split(" ")[0]));
    }

    /**
     * Sauvegarde sécuriser, avec demande d'écrasement de fichier ou non
     *
     * @param toSave
     *      Astre à sauvegarder
     * @return
     *      Un booléen indiquant si la sauvegarde c'est bien passé ou non
     * @throws ArrayIndexOutOfBoundsException
     */
    private boolean secureSave(Astre toSave) throws ArrayIndexOutOfBoundsException{
        JFileChooser choix = new JFileChooser("dat");
        choix.setSelectedFile(new File(toSave.getNom().toLowerCase()));

        if(choix.showSaveDialog(mainWindow) == JFileChooser.APPROVE_OPTION){                          // validation du fichier
            String filename = choix.getSelectedFile().getAbsolutePath();
            if(!choix.getSelectedFile().getName().contains(".dat"))             // O ajoute .dat s'il n'y ai pas déjà
                filename+=".dat";

            if(new File(filename).exists()  ) { // si le fichier n'existe pas déjà
                if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(mainWindow, "Voulez vous écraser "
                        + choix.getSelectedFile().getAbsolutePath()+" ?", "Écraser", JOptionPane.YES_NO_OPTION) ) {
                    if(!toSave.save(filename)){
                        JOptionPane.showMessageDialog(mainWindow, "La sauvegarde de \"" + filename   + "\" a échoué.", "Échec de sauvegarde", JOptionPane.ERROR_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(null, "Sauvegarde de \"" + filename + "\" réussie.", "Sauvegarde", JOptionPane.INFORMATION_MESSAGE);
                    }
                    return false;
                } // On reboucle si l'utilisateur ne veut pas écraser
            }else{
                // Sauvegarde si le fichier n'existe pas
                if(!toSave.save(filename)){
                    JOptionPane.showMessageDialog(mainWindow, "La sauvegarde de \"" + filename   + "\" a échoué.", "Échec de sauvegarde", JOptionPane.ERROR_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, "Sauvegarde de \"" + filename + "\" réussie.", "Sauvegarde", JOptionPane.INFORMATION_MESSAGE);
                }
                return false;
            }

        }
        else{
            // clique sur la croix rouge ou annuler
            return false;
        }

        return true;
    }


}
