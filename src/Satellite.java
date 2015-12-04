/**
 * Created by william on 04/12/2015.
 */
public class Satellite extends Astre {
    private Astre astreReferent;
    private int demiGrandAxe;
    private int demiPetitAxe;
    private int periodeRotation;


    public Satellite(String nom, String pathImg, Astre referent, int demiGrandAxe, int demiPetitAxe, int periodeRotation){
        super(nom,pathImg);
        // TODO Initialisation
        // TODO Exception
    }


    public Astre getAstreReferent() {
        return astreReferent;
    }

    public void setAstreReferent(Astre astreReferent) {
        this.astreReferent = astreReferent;
    }

    public int getDemiGrandAxe() {
        return demiGrandAxe;
    }

    public void setDemiGrandAxe(int demiGrandAxe) {
        this.demiGrandAxe = demiGrandAxe;
    }

    public int getDemiPetitAxe() {
        return demiPetitAxe;
    }

    public void setDemiPetitAxe(int demiPetitAxe) {
        this.demiPetitAxe = demiPetitAxe;
    }

    public int getPeriodeRotation() {
        return periodeRotation;
    }

    public void setPeriodeRotation(int periodeRotation) {
        this.periodeRotation = periodeRotation;
    }


}
