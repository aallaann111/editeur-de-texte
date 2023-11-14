package fr.iut.editeur.document;

/**
 * La classe Document représente un document texte avec des opérations de manipulation de texte.
 * Elle permet d'ajouter, remplacer, convertir en majuscules, convertir en minuscules,
 * effacer, effacer complètement le texte et insérer du texte à différentes positions.
 */
public class Document {

    /** Le texte du document. */
    private String texteDocument;

    /**
     * Constructeur par défaut qui initialise le texte du document à une chaîne vide.
     */
    public Document() {
        this.texteDocument = "";
    }

    /**
     * Obtient le texte actuel du document.
     *
     * @return Le texte actuel du document.
     */
    public String getTexte() {
        return texteDocument;
    }

    /**
     * Modifie le texte du document.
     *
     * @param texte Le nouveau texte du document.
     */
    public void setTexte(String texte) {
        this.texteDocument = texte;
    }

    /**
     * Ajoute du texte à la fin du document.
     *
     * @param texte Le texte à ajouter.
     */
    public void ajouter(String texte) {
        this.texteDocument += texte;
    }

    /**
     * Remplace une portion du texte par une nouvelle chaîne.
     *
     * @param start L'indice de début de la portion à remplacer.
     * @param end L'indice de fin de la portion à remplacer.
     * @param remplacement La nouvelle chaîne de remplacement.
     */
    public void remplacer(int start, int end, String remplacement) {
        String leftPart = texteDocument.substring(0, start);
        String rightPart = texteDocument.substring(end);
        texteDocument = leftPart + remplacement + rightPart;
    }

    /**
     * Convertit en majuscules une portion spécifique du texte.
     *
     * @param start L'indice de début de la portion à convertir en majuscules.
     * @param end L'indice de fin de la portion à convertir en majuscules.
     */
    public void majuscules(int start, int end) {
        String leftPart = texteDocument.substring(0, start);
        String uppercasePart = texteDocument.substring(start, end).toUpperCase();
        String rightPart = texteDocument.substring(end);
        texteDocument = leftPart + uppercasePart + rightPart;
    }

    /**
     * Convertit en minuscules une portion spécifique du texte.
     *
     * @param start L'indice de début de la portion à convertir en minuscules.
     * @param end L'indice de fin de la portion à convertir en minuscules.
     */
    public void minuscule(int start, int end) {
        String leftPart = texteDocument.substring(0, start);
        String lowerCase = texteDocument.substring(start, end).toLowerCase();
        String rightPart = texteDocument.substring(end);
        texteDocument = leftPart + lowerCase + rightPart;
    }

    /**
     * Efface une portion spécifique du texte.
     *
     * @param start L'indice de début de la portion à effacer.
     * @param end L'indice de fin de la portion à effacer.
     * @throws IllegalArgumentException Si les indices de début ou de fin sont invalides.
     */
    public void effacer(int start, int end) throws IllegalArgumentException {
        if (start < 0 || end > texteDocument.length() || start >= end) {
            throw new IllegalArgumentException("Indices de départ ou de fin invalides.");
        }

        String leftPart = texteDocument.substring(0, start);
        String rightPart = texteDocument.substring(end);
        texteDocument = leftPart + rightPart;
    }

    /**
     * Efface complètement le texte du document.
     */
    public void clear() {
        texteDocument = "";
    }

    /**
     * Insère du texte à une position spécifique dans le document.
     *
     * @param start L'indice d'insertion du texte.
     * @param insertion Le texte à insérer.
     */
    public void inserer(int start, String insertion) {
        String leftPart = texteDocument.substring(0, start);
        String rightPart = texteDocument.substring(start);

        texteDocument = leftPart + insertion + rightPart;
    }

    /**
     * Renvoie une représentation sous forme de chaîne du document.
     *
     * @return Une représentation sous forme de chaîne du document.
     */
    @Override
    public String toString() {
        return texteDocument;
    }
}
