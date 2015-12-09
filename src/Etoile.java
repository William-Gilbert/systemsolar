/**
 * Created by william on 04/12/2015.
 */
public class Etoile extends Astre {

    public Etoile(String name, String pathImg, int posX, int posY){
        super(name, pathImg);
        this.posX = posX;
        this.posY = posY;
    }

    public boolean addSatellite(String nom, String pathImg, int demiGrandAxe, int demiPetitAxe, int periodeRotation){

        return listOfSatellites.add(new Satellite(nom,pathImg,this,demiGrandAxe,demiPetitAxe,periodeRotation));
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
