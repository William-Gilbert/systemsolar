package fr.system.solar;

/**
 * Exception indiquant une erreur dans la création ou l'appel d'un astre
 *
 * @author Gilbert William, Tournoux Corentin
 * @version 1.0
 */
public class ExceptionUnknowAstre extends Exception {
    public ExceptionUnknowAstre(String s) {
        super(s);
    }
}
