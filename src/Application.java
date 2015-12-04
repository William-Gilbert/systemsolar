import java.io.IOException;

/**
 * Created by william on 01/12/2015.
 */
public class Application {
    public static void main(String[] args){
        Model m = new Model();
        try {
            Window w = new Window(m);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
