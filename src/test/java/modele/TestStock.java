package modele;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.xml.ws.soap.Addressing;

import static org.junit.Assert.*;

public class TestStock {

    private Article article1;
    private ArticleSelectionne articleSelectionne1;

    @Before
    public void setUp() {
        article1 = new Article(new Fromage("Fromage1"), "200g", 5);
        articleSelectionne1 = new ArticleSelectionne(article1, 1);
    }

    @After
    public void tearDown() {
        article1 = null;
    }

    @Test
    public void testStockCreation() {
        assertEquals(0, article1.getQuantiteEnStock());
    }

    @Test
    public void testStockAjout() {
        article1.setQuantiteEnStock(5);
        assertEquals(5, article1.getQuantiteEnStock());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testStockNegatif() {
        article1.setQuantiteEnStock(5);
        article1.setQuantiteEnStock(-2);
        assertEquals(5, article1.getQuantiteEnStock());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAjouterPlusQueStock() {
        article1.setQuantiteEnStock(5);
        articleSelectionne1.ajouter(8);
        assertEquals(0, articleSelectionne1.getQuantite());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetQuantitePlusQueStock() {
        article1.setQuantiteEnStock(5);
        articleSelectionne1.setQuantite(8);
        assertEquals(0, articleSelectionne1.getQuantite());
    }

    @Test
    public void testSetQuantite() {
        article1.setQuantiteEnStock(5);
        articleSelectionne1.setQuantite(3);
        assertEquals(3, articleSelectionne1.getQuantite());
    }

    @Test
    public void testAjouter() {
        article1.setQuantiteEnStock(5);
        articleSelectionne1.ajouter(3);
        assertEquals(4, articleSelectionne1.getQuantite());
    }
}