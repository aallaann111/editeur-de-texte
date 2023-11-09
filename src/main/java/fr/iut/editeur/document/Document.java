package fr.iut.editeur.document;

public class Document {

    private String texteDocument;

    public Document() {
        this.texteDocument = "";
    }
	
    public String getTexte() {
        return texteDocument;
    }

    public void setTexte(String texte) {
        this.texteDocument = texte;
    }

    public void ajouter(String texte) {
        this.texteDocument += texte;
    }

    @Override
    public String toString() {
        return this.texteDocument;
    }

    public void remplacer(int start, int end, String remplacement) {
        String leftPart = texteDocument.substring(0, start);
        String rightPart = texteDocument.substring(end);
        texteDocument = leftPart + remplacement + rightPart;
    }

    public void majuscules(int start, int end) {
        String leftPart = texteDocument.substring(0, start);
        String uppercasePart = texteDocument.substring(start, end).toUpperCase();
        String rightPart = texteDocument.substring(end);
        texteDocument = leftPart + uppercasePart + rightPart;
    }

    public void minuscule(int start, int end) {
        String leftPart = texteDocument.substring(0, start);
        String lowerCase = texteDocument.substring(start, end).toLowerCase();
        String rightPart = texteDocument.substring(end);
        texteDocument = leftPart + lowerCase + rightPart;
    }


    public void effacer(int start, int end) {
        if (start < 0 || end > texteDocument.length() || start >= end) {
            throw new IllegalArgumentException("Indices de dépar ou de fin invalides.");
        }

        String leftPart = texteDocument.substring(0, start);
        String rightPart = texteDocument.substring(end);
        texteDocument = leftPart + rightPart;
    }

    public void clear() {
        texteDocument = "";
    }

    public void inserer(int start, String insertion) {
        String leftPart = texteDocument.substring(0, start);
        String rightPart = texteDocument.substring(start);

        texteDocument = leftPart + insertion + rightPart;
    }
}
