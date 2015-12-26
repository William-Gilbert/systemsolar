package fr.system.solar;


/**
 * Etoile est une classe permettant de repr�senter un astre fixe sur l'application
 *
 * @author Gilbert William, Tournoux Corentin
 * @version 1.0
 * @see Astre
 */
public class Etoile extends Astre {

    /**
     * Constructeur de l'�toile
     *
     * @param id
     *      Identifiant de l'astre
     * @param name
     *      Nom de l'astre
     * @param pathImg
     *      Chemin vers l'image
     * @param posX
     *      Coordonn�e x de l'astre
     * @param posY
     *      Coordonn�e y de l'astre
     */
    public Etoile(int id,String name, String pathImg, int posX, int posY) throws ExceptionUnknowAstre{
        super(id,name, pathImg);
        this.posX = posX;
        this.posY = posY;
    }


    /**
     * R�cup�re la position en x de l'�toile
     *
     * @return
     *      Position en x de l'�toile
     */
    @Override
    public int getPosX() {
        return posX;
    }

    /**
     * R�cup�re la position en y de l'�toile
     * @return
     *      Position en Y de l'�toile
     */
    @Override
    public int getPosY() {
        return posY;
    }

    @Override
    public boolean isSatellite() {
        return false;
    }
}
