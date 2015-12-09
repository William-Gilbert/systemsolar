import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by coren_000 on 08/12/2015.
 */
public class ControlMenu implements ActionListener {
    MainWindow mainWindow;
    Model model;
    public ControlMenu(MainWindow mainWindow,Model m) {
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

            int size =  model.getListOfAstre().size();
            String[] label = new String[size];
            for(int i = 0 ; i < size ; i++){
                label[i] = model.getAstre(i).getNom();
            }
            JOptionPane jop = new JOptionPane(), jop2 = new JOptionPane();
            String nom = (String)jop.showInputDialog(null,
                    "Veuillez sélectionner l'étoile à enregistrer",
                    "Enregistrement",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    label,
                    label[0]);

            try{
                Astre toSave = model.getAstre(nom);
                toSave.save(toSave.getNom()+".dat");
            }catch (ExceptionUnknowAstre e){
                System.out.println(e.getMessage());
            }


        }
        else if(a.getSource() == mainWindow.itemOpen){

            JFileChooser choix = new JFileChooser();
            int retour=choix.showOpenDialog(mainWindow);
            if(retour==JFileChooser.APPROVE_OPTION){
                try {
                    String name = choix.getSelectedFile().getName();
                     model.open(name);

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                ;
                // chemin absolu du fichier choisi
                //choix.getSelectedFile().getAbsolutePath();
            }
        }

        else if(a.getSource() == mainWindow.itemExit){
            System.exit(0);
        }


    }
}
