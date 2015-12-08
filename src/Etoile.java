/**
 * Created by william on 04/12/2015.
 */
public class Etoile extends Astre {

    public Etoile(String name, String pathImg, int posX, int posY){
        super(name, pathImg);
        this.posX = posX-(image.getIconWidth()/2);
        this.posY = posY+(image.getIconHeight()/2);
    }


    @Override
    public int getPosX() {
        return posX;
    }

    @Override
    public int getPosY() {
        return posY;
    }
}
