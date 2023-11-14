package fr.iut.editeur.commande;

import fr.iut.editeur.document.Document;

/**
 * La classe CommandeInserer est une commande qui insère une chaîne de caractères à une position spécifique
 * dans le texte d'un document.
 */
public class CommandeInserer extends CommandeDocument {

    /**
     * Constructeur de la commande CommandeInserer.
     *
     * @param document Le document sur lequel la commande sera exécutée.
     * @param parameters Les paramètres de la commande, attendus sous la forme : inserer;depart;insertion.
     */
    public CommandeInserer(Document document, String[] parameters) {
        super(document, parameters);
    }

    /**
     * Exécute la commande en insérant une chaîne de caractères à une position spécifiée dans le texte du document.
     * Affiche un message d'erreur si le format des paramètres est incorrect ou si l'indice de départ est invalide.
     */
    @Override
    public void executer() {
        if (parameters.length < 3) {
            System.err.println("Format attendu : inserer;depart;insertion");
            return;
        }

        try {
            int depart = Integer.parseInt(parameters[1]);
            String insertion = parameters[2];

            if (depart < 0 || depart > this.document.getTexte().length()) {
                System.err.println("Indice de départ invalide.");
                return;
            }

            this.document.inserer(depart, insertion);
            super.executer();
        } catch (NumberFormatException e) {
            System.err.println("L'indice de départ doit être un entier.");
        }
    }
}
