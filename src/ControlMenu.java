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
            model.save("mod");
        }
        else if(a.getSource() == mainWindow.itemOpen){
            try {
                model = Model.open("mod");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }
}
