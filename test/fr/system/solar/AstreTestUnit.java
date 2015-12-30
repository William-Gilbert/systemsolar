package fr.system.solar;

import junit.framework.TestCase;

/**
 * Exception indiquant une erreur dans la cr�ation ou l'appel d'un astre
 *
 * @author Gilbert William, Tournoux Corentin
 * @version 1.0
 */
public class AstreTestUnit extends TestCase{

    public void testNewAstreCorrectPath() throws ExceptionUnknowAstre{
        Astre etoile = new Etoile(0,"Sun","asteroide.png",200,200);
        assertEquals("Sun", etoile.toString());
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
