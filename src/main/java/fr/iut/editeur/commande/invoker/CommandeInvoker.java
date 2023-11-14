package fr.iut.editeur.commande.invoker;

import fr.iut.editeur.commande.Commande;

import java.util.Stack;

/**
 * La classe CommandeInvoker est un invocateur (invoker) qui est responsable de l'exécution des commandes.
 * Elle suit le modèle de conception Singleton pour garantir une seule instance de l'invocateur.
 */
public class CommandeInvoker {

    /** L'instance unique de l'invocateur. */
    private static CommandeInvoker instance;

    /**
     * Obtient l'instance unique de l'invocateur en suivant le modèle de conception Singleton.
     *
     * @return L'instance unique de l'invocateur.
     */
    public static synchronized CommandeInvoker getInstance() {
        if(instance == null) {
            instance = new CommandeInvoker();
        }
        return instance;
    }

    /** Constructeur privé pour empêcher l'instanciation directe de l'invocateur. */
    private CommandeInvoker() {}

    /**
     * Exécute une commande donnée.
     *
     * @param commande La commande à exécuter.
     */
    public void executer(Commande commande) {
        commande.executer();
    }
}
