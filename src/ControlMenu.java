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
        try {
            AddWindow nouv = new AddWindow(model);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
