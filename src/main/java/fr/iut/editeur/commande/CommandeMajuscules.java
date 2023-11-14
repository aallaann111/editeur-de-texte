package fr.iut.editeur.commande;

import fr.iut.editeur.document.Document;

/**
 * La classe CommandeMajuscules est une commande qui convertit en majuscules une portion spécifique
 * du texte d'un document.
 */
public class CommandeMajuscules extends CommandeDocument {

    /**
     * Constructeur de la commande CommandeMajuscules.
     *
     * @param document Le document sur lequel la commande sera exécutée.
     * @param parameters Les paramètres de la commande, attendus sous la forme : majuscules;depart;fin.
     */
    public CommandeMajuscules(Document document, String[] parameters) {
        super(document, parameters);
    }

    /**
     * Exécute la commande en convertissant en majuscules la portion spécifiée du texte du document.
     * Affiche un message d'erreur si le format des paramètres est incorrect.
     */
    @Override
    public void executer() {
        if (parameters.length < 3) {
            System.err.println("Format attendu : majuscules;depart;fin");
            return;
        }

        try {
            int start = Integer.parseInt(parameters[1]);
            int end = Integer.parseInt(parameters[2]);
            document.majuscules(start, end);
            super.executer();
        } catch (NumberFormatException e) {
            System.err.println("Les indices de départ et de fin doivent être des nombres entiers.");
        }
    }
}
