package fr.iut.editeur.commande;

import fr.iut.editeur.document.Document;

/**
 * La classe CommandeEffacer est une commande qui efface une portion spécifique du texte d'un document.
 */
public class CommandeEffacer extends CommandeDocument {

    /**
     * Constructeur de la commande CommandeEffacer.
     *
     * @param document Le document sur lequel la commande sera exécutée.
     * @param parameters Les paramètres de la commande, attendus sous la forme : effacer;depart;fin.
     */
    public CommandeEffacer(Document document, String[] parameters) {
        super(document, parameters);
    }

    /**
     * Exécute la commande en effaçant une portion spécifiée du texte du document.
     * Affiche un message d'erreur si le format des paramètres est incorrect.
     */
    @Override
    public void executer() {
        if (parameters.length < 3) {
            System.err.println("Format attendu : effacer;depart;fin");
            return;
        }

        try {
            int start = Integer.parseInt(parameters[1]);
            int end = Integer.parseInt(parameters[2]);
            document.effacer(start, end);
            super.executer();
        } catch (NumberFormatException e) {
            System.err.println("Les indices de départ et de fin doivent être des nombres entiers.");
        }
    }
}
