package fr.system.solar;

import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by william on 21/12/2015.
 */
public class ControlAddWindow /*implements ActionListener */{
    private AddWindow window;
    private Model m;


    public ControlAddWindow(Model m, AddWindow a){
        window = a;
        this.m = m;
    }


   /*@Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == window.getCreateAstre()){
            // TODO AJOUT

            for(JTextField tfAjout : window.getTfAdd()){
                if(tfAjout.getText().equals("")){
                    JOptionPane.showMessageDialog(window, "Champ vide", "Création", JOptionPane.ERROR_MESSAGE);
                    break;
                }
            }


        }

        else if(e.getSource() == window.getChSatellite()){
            if(window.getChSatellite().isSelected()){
                window.getPanSat().setVisible(true);
            }else{
                window.getPanSat().setVisible(false);
            }
        }
    }*/
}

