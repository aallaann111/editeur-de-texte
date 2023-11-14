package fr.iut.editeur.commande;

import fr.iut.editeur.document.Document;

/**
 * La classe CommandeRemplacer est une commande qui remplace une portion spécifique du texte d'un document
 * par une nouvelle chaîne de caractères.
 */
public class CommandeRemplacer extends CommandeDocument {

    /**
     * Constructeur de la commande CommandeRemplacer.
     *
     * @param document Le document sur lequel la commande sera exécutée.
     * @param parameters Les paramètres de la commande, attendus sous la forme : remplacer;depart;fin;chaine.
     */
    public CommandeRemplacer(Document document, String[] parameters) {
        super(document, parameters);
    }

    /**
     * Exécute la commande en remplaçant une portion spécifiée du texte du document par une nouvelle chaîne.
     * Affiche un message d'erreur si le format des paramètres est incorrect.
     */
    @Override
    public void executer() {
        if (parameters.length < 4) {
            System.err.println("Format attendu : remplacer;depart;fin;chaine");
            return;
        }

        try {
            int depart = Integer.parseInt(parameters[1]);
            int fin = Integer.parseInt(parameters[2]);
            String chaine = parameters[3];

            this.document.remplacer(depart, fin, chaine);
            super.executer();
        } catch (NumberFormatException e) {
            System.err.println("Les indices de départ et de fin doivent être des nombres entiers.");
        }
    }
}
