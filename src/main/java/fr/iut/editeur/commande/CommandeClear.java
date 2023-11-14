package fr.iut.editeur.commande;

import fr.iut.editeur.document.Document;

/**
 * La classe CommandeClear est une commande qui efface complètement le texte d'un document.
 */
public class CommandeClear extends CommandeDocument {

    /**
     * Constructeur de la commande CommandeClear.
     *
     * @param document Le document sur lequel la commande sera exécutée.
     * @param parameters Les paramètres de la commande, aucun paramètre n'est attendu.
     */
    public CommandeClear(Document document, String[] parameters) {
        super(document, parameters);
    }

    /**
     * Exécute la commande en effaçant complètement le texte du document.
     * Affiche un message d'erreur si le format des paramètres est incorrect.
     */
    @Override
    public void executer() {
        if (parameters.length < 1) {
            System.err.println("Format attendu : clear");
            return;
        }
        document.clear();
        super.executer();
    }
}
