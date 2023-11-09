package fr.iut.editeur.commande;

import fr.iut.editeur.document.Document;

public class CommandeMinuscules extends CommandeDocument {

    public CommandeMinuscules(Document document, String[] parameters) {
        super(document, parameters);
    }

    @Override
    public void executer() {
        if (parameters.length < 3) {
            System.err.println("Format attendu : minuscules;depart;fin");
            return;
        }

        try {
            int start = Integer.parseInt(parameters[1]);
            int end = Integer.parseInt(parameters[2]);
            document.minuscules(start, end);
            super.executer();
        } catch (NumberFormatException e) {
            System.err.println("Les indices de départ et de fin doivent être des nombres entiers.");
        }
    }
}