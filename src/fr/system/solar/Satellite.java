package fr.system.solar;

/**
 * Satellite est une classe permettant de représenter un astre en orbite autour d'une étoile
 *
 * @author Gilbert William, Tournoux Corentin
 * @version 1.0
 * @see Astre
 */
public class Satellite extends Astre {
    /**
     * Astre référant du satellite
     */
    private Astre astreReferent;
    /**
     * Longueur du demi-grand axe de l'ellipse formé par le satellite
     */
    private int demiGrandAxe;
    /**
     * Longueur du demi-petit axe de l'ellipse formé par le satellite
     */
    private int demiPetitAxe;
    /**
     * Période de rotation du satellite
     */
    private int periodeRotation;


    /**
     * Constructeur de satellite
     *
     * @param id
     *      Identifiant du satellite
     * @param nom
     *      Nom du satellite
     * @param pathImg
     *      Chemin absolu ou relatif vers l'image représentant le satellite
     * @param referent
     *      Astre de référence autour duquel le sattelite sera en orbite
     * @param demiGrandAxe
     *      Longueur du demi-grand axe de l'ellipse formé par le satellite
     * @param demiPetitAxe
     *      Longueur du demi-petit axe de l'ellipse formé par le satellite
     * @param periodeRotation
     *      Période de rotation du satellite
     */
    public Satellite(int id, String nom, String pathImg, Astre referent, int demiGrandAxe, int demiPetitAxe, int periodeRotation) throws ExceptionUnknowAstre{
        super(id,nom,pathImg);
        astreReferent = referent;
        this.demiGrandAxe = demiGrandAxe;
        this.demiPetitAxe = demiPetitAxe;
        this.periodeRotation = periodeRotation;
    }



    /**
     * Récupère la position en x du satellite en fonction du temps système
     * @return
     *      Coordonnée x du sattelite
     */
    @Override
    public int getPosX() {
       return (int)(demiGrandAxe * Math.cos(2*Math.PI*System.currentTimeMillis()/1000.0/periodeRotation) + astreReferent.getPosX());
}

    /**
     * Récupère la position en y du satellite en fonction du temps système
     * @return
     *      Coordonnée y du satellite
     */
    @Override
    public int getPosY() {
        return (int)(demiPetitAxe * Math.sin(2*Math.PI*System.currentTimeMillis()/1000.0/periodeRotation) + astreReferent.getPosY());
    }
}
