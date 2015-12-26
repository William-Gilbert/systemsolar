package fr.system.solar;

import junit.framework.Assert;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by william on 26/12/2015.
 */
public class AstreTestUnit extends TestCase{

    public void testNewAstreCorrectPath() throws ExceptionUnknowAstre{
        Astre etoile = new Etoile(0,"Sun","asteroide.png",200,200);
        assertEquals("Sun", etoile.getNom());
        assertEquals("image/asteroide.png", etoile.getImage().toString());
    }

    public void testNewAstreWrong(){
        try {
            Astre etoile = new Etoile(0, "Sun", "../../../ima.png",200,200);
        } catch (ExceptionUnknowAstre exceptionUnknowAstre) {
            assertTrue(true);
            return;
        }
        assertTrue(false);

    }

    public void testAddSattellite()throws ExceptionUnknowAstre {
        Etoile a = new Etoile(0,"Sun","soleil.png",450,375);
        a.addSatellite(0,"Terre","terre.png",300,200,20);
        assertEquals(1, a.getListOfSatellites().size());
        assertEquals(0, a.getListOfSatellites().get(0).getId());
    }

    public void testAddFakeSattellite() {
        Etoile a = null;
        try {
            a = new Etoile(0, "Sun", "soleil.png", 450, 375);
            a.addSatellite(0, "Terre", "../../terre.png", 300, 200, 20);
        } catch (ExceptionUnknowAstre exceptionUnknowAstre){
            assertEquals(0, a.getListOfSatellites().size());
        }

    }

}
