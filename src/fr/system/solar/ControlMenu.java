package fr.system.solar;

import fr.system.solar.AddWindow;
import fr.system.solar.MainWindow;



import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 * Created by coren_000 on 08/12/2015.
 */
public class ControlMenu implements ActionListener {
    MainWindow mainWindow;
    Model model;
    public ControlMenu(MainWindow mainWindow, Model m) {
        this.mainWindow = mainWindow;
        model = m;
    }
    public void actionPerformed(ActionEvent a) {
        if(a.getSource() == mainWindow.itemAdd){
            try {
                AddWindow nouv = new AddWindow(model);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        else if(a.getSource() == mainWindow.itemSave){
            sauvegarde();
        }
        else if(a.getSource() == mainWindow.itemOpen){

            JFileChooser choix = new JFileChooser();
            int retour=choix.showOpenDialog(mainWindow);
            if(retour==JFileChooser.APPROVE_OPTION){
                int checkUp = model.open(choix.getSelectedFile().getAbsolutePath());
                if(checkUp==1) {
                    JOptionPane.showMessageDialog(null, "L'étoile est ouverte dans l'application", "Ouverture", JOptionPane.INFORMATION_MESSAGE);
                }else if(checkUp==0){
                    JOptionPane.showMessageDialog(null, "L'étoile est déjà ouverte", "Ouverture", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }

        else if(a.getSource() == mainWindow.itemExit){
            System.exit(0);
        }


    }

    private void sauvegarde(){
        int size =  model.getListOfAstre().size();
        String[] label = new String[size];
        for(int i = 0 ; i < size ; i++){
            label[i] = model.getAstre(i).getId() + " "+model.getAstre(i).getNom();
        }
        JOptionPane jop = new JOptionPane(), jop2 = new JOptionPane();
        String nom = (String)jop.showInputDialog(null,
                "Veuillez sélectionner l'étoile à enregistrer",
                "Enregistrement",
                JOptionPane.QUESTION_MESSAGE,
                null,
                label,
                label[0]);

        int id = Integer.parseInt(nom.split(" ")[0]);
        String n = nom.split(" ")[1];

        try{
            Astre toSave = model.getAstre(id);
            while(true){
                JFileChooser choix = new JFileChooser("dat");
                choix.setSelectedFile(new File(toSave.getNom().toLowerCase()));
                int retour=choix.showSaveDialog(mainWindow);
                if(retour==JFileChooser.APPROVE_OPTION){
                    if(new File(choix.getSelectedFile().getAbsolutePath()+".dat").exists()) {
                        if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(mainWindow, "Voulez vous écraser "
                                + choix.getSelectedFile().getName() + ".dat ?", "Écraser", JOptionPane.YES_NO_OPTION)) {
                            toSave.save(choix.getSelectedFile().getAbsolutePath() + ".dat");
                            JOptionPane.showMessageDialog(null, "Sauvegarde de" + n + ".dat réussie.", "Sauvegarde", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        }
                    }
                }
            }

        }catch (ArrayIndexOutOfBoundsException e){
            JOptionPane.showMessageDialog(null, "Astre inexistant.\nLa sauvegarde à échoué.", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }
}
