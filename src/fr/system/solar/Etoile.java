package fr.system.solar;


/**
 * Etoile est une classe permettant de représenter un astre fixe sur l'application
 *
 * @author Gilbert William, Tournoux Corentin
 * @version 1.0
 * @see Astre
 */
public class Etoile extends Astre {

    /**
     * Constructeur de l'étoile
     *
     * @param id
     *      Identifiant de l'astre
     * @param name
     *      Nom de l'astre
     * @param pathImg
     *      Chemin vers l'image
     * @param posX
     *      Coordonnée x de l'astre
     * @param posY
     *      Coordonnée y de l'astre
     */
    public Etoile(int id,String name, String pathImg, int posX, int posY) throws ExceptionUnknowAstre{
        super(id,name, pathImg);
        this.posX = posX;
        this.posY = posY;
    }


    /**
     * Récupère la position en x de l'étoile
     *
     * @return
     *      Position en x de l'étoile
     */
    @Override
    public int getPosX() {
        return posX;
    }

    /**
     * Récupère la position en y de l'étoile
     * @return
     *      Position en Y de l'étoile
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
