package fr.iut.editeur.document;

public class Document {

    private String texte;

    public Document() {
        this.texte = "";
    }
	
    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public void ajouter(String texte) {
        this.texte += texte;
    }

    @Override
    public String toString() {
        return this.texte;
    }

    public void remplacer(int start, int end, String remplacement) {
        String leftPart = texte.substring(0, start);
        String rightPart = texte.substring(end);
        texte = leftPart + remplacement + rightPart;
    }

    public void majuscules(int start, int end) {
        String leftPart = texte.substring(0, start);
        String uppercasePart = texte.substring(start, end).toUpperCase();
        String rightPart = texte.substring(end);
        texte = leftPart + uppercasePart + rightPart;
    }

    public void minuscule(int start, int end) {
        String leftPart = texte.substring(0, start);
        String lowerCase = texte.substring(start, end).toLowerCase();
        String rightPart = texte.substring(end);
        texte = leftPart + lowerCase + rightPart;
    }


    public void effacer(int start, int end) {
        if (start < 0 || end > texte.length() || start >= end) {
            throw new IllegalArgumentException("Indices de dépar ou de fin invalides.");
        }

        String leftPart = texte.substring(0, start);
        String rightPart = texte.substring(end);
        texte = leftPart + rightPart;
    }

    public void clear() {
        texte = "";
    }

    public void inserer(int start, String insertion) {
        String leftPart = texte.substring(0, start);
        String rightPart = texte.substring(start);

        texte = leftPart + insertion + rightPart;
    }
}
