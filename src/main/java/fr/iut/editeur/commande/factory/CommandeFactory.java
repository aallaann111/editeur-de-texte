package fr.iut.editeur.commande.factory;

import fr.iut.editeur.commande.*;
import fr.iut.editeur.document.Document;

/**
 * La classe CommandeFactory est une fabrique (factory) qui crée des instances de classes de commande
 * en fonction du nom de la commande fourni.
 */
public class CommandeFactory {

    /** L'instance unique de la fabrique. */
    private static CommandeFactory instance;

    /**
     * Obtient l'instance unique de la fabrique en suivant le modèle de conception Singleton.
     *
     * @return L'instance unique de la fabrique.
     */
    public static CommandeFactory getInstance() {
        if (instance == null) {
            instance = new CommandeFactory();
        }
        return instance;
    }

    /** Constructeur privé pour empêcher l'instanciation directe de la fabrique. */
    private CommandeFactory() {}

    /**
     * Crée une instance de classe de commande en fonction du nom de la commande et des paramètres fournis.
     *
     * @param name Le nom de la commande.
     * @param document Le document sur lequel la commande sera exécutée.
     * @param parameters Les paramètres de la commande.
     * @return Une instance de la classe de commande correspondante, ou null si le nom de la commande est inconnu.
     */
    public Commande createCommand(String name, Document document, String[] parameters) {
        switch (name) {
            case "clear":
                return new CommandeClear(document, parameters);
            case "effacer":
                return new CommandeEffacer(document, parameters);
            case "ajouter":
                return new CommandeAjouter(document, parameters);
            case "remplacer":
                return new CommandeRemplacer(document, parameters);
            case "majuscules":
                return new CommandeMajuscules(document, parameters);
            case "inserer":
                return new CommandeInserer(document, parameters);
            case "minuscule":
                return new CommandeMinuscule(document, parameters);
            default:
                return null;
        }
    }
}
