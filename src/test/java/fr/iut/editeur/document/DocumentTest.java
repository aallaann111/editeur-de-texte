package fr.iut.editeur.document;

import junit.framework.TestCase;
import org.junit.Test;

public class DocumentTest extends TestCase {

    @Test
    public void testAjouter() {
        Document document = new Document();
        document.ajouter("Bonjour");
        assertEquals("Bonjour", document.getTexte());
    }

    @Test
    public void testRemplacer() {
        Document document = new Document();
        document.setTexte("Hello, world!");
        document.remplacer(0, 5, "Hi");
        assertEquals("Hi, world!", document.getTexte());
    }

    @Test
    public void testMajuscules() {
        Document document = new Document();
        document.setTexte("hello");
        document.majuscules(0, 3);
        assertEquals("HELlo", document.getTexte());
    }

    @Test
    public void testMinuscule() {
        Document document = new Document();
        document.setTexte("HELLO");
        document.minuscule(1, 4);
        assertEquals("HellO", document.getTexte());
    }

    @Test
    public void testEffacer() {
        Document document = new Document();
        document.setTexte("Hello, world!");
        document.effacer(5, 12);
        assertEquals("Hello!", document.getTexte());
    }

    @Test
    public void testClear() {
        Document document = new Document();
        document.setTexte("Hello");
        document.clear();
        assertEquals("", document.getTexte());
    }

    @Test
    public void testInserer() {
        Document document = new Document();
        document.setTexte("Hello");
        document.inserer(2, ", world!");
        assertEquals("He, world!llo", document.getTexte());
    }


}