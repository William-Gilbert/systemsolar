package fr.system.solar;

/**
 * Exception indiquant une erreur dans la cr�ation ou l'appel d'un astre
 *
 * @author Gilbert William, Tournoux Corentin
 * @version 1.0
 */
public class ExceptionUnknowAstre extends Exception {
    public ExceptionUnknowAstre(String s) {
        super(s);
    }
}
