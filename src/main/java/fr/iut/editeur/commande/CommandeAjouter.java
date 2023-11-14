package fr.iut.editeur.commande;

import fr.iut.editeur.document.Document;

/**
 * La classe CommandeAjouter est une commande qui ajoute une chaîne de caractères à la fin du texte d'un document.
 */
public class CommandeAjouter extends CommandeDocument {

    /**
     * Constructeur de la commande CommandeAjouter.
     *
     * @param document Le document sur lequel la commande sera exécutée.
     * @param parameters Les paramètres de la commande, attendus sous la forme : ajouter;texte.
     */
    public CommandeAjouter(Document document, String[] parameters) {
        super(document, parameters);
    }

    /**
     * Exécute la commande en ajoutant une chaîne de caractères à la fin du texte du document.
     * Affiche un message d'erreur si le format des paramètres est incorrect.
     */
    @Override
    public void executer() {
        if(parameters.length < 2) {
            System.err.println("Format attendu : ajouter;texte");
            return;
        }
        String texte = parameters[1];
        this.document.ajouter(texte);
        super.executer();
    }
}
