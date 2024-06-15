package modele;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestPanier {
    Fromages fromages;
    Panier panier;
    Article article1;

    @Before
    public void setUp() {
        panier = new Panier();
        fromages = GenerationFromages.generationBaseFromages();
        article1 = new Article(fromages.getFromages().get(1), "250g", 10.0f);
        article1.setQuantiteEnStock(10);
    }

    @After
    public void tearDown() {
        panier = null;
        article1 = null;
    }

    @Test
    public void testAddArticleToPanier() {
        // Add an item to the cart
        panier.addArticle(article1,1);

        // Check if the item has been added to the cart
        assertTrue(panier.contient(article1));
    }

    @Test
    public void testRemoveArticleFromPanier() {
        // Add an item to the cart
        panier.addArticle(article1,1);

        // Remove the item from the cart
        panier.removeArticle(article1);

        // Check if the item has been removed from the cart
        assertFalse(panier.contient(article1));
    }

    @Test
    public void testRemoveArticleSelectionneFromPanier() {
        // Add an item to the cart
        panier.addArticle(article1,1);

        // Remove the item from the cart
        panier.removeArticle(panier.getArticle(article1.getFromage()));

        // Check if the item has been removed from the cart
        assertFalse(panier.contient(article1));
    }

    @Test
    public void testAddArticleToPanierWithInvalidQuantity() {
        // Add an item to the cart with an invalid quantity
        try {
            panier.addArticle(article1,-1);
            fail("An IllegalArgumentException should have been thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Quantité invalide", e.getMessage());
        }
    }

    @Test
    public void testAddArticleToPanierWithInsufficientStock() {
        // Add an item to the cart with an insufficient stock
        try {
            panier.addArticle(article1,11);
            fail("An IllegalArgumentException should have been thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Quantité en stock insuffisante", e.getMessage());
        }
    }

    @Test
    public void testAddArticleToPanierWithExistingArticle() {
        // Add an item to the cart
        panier.addArticle(article1,1);

        // Add the same item to the cart
        panier.addArticle(article1,1);

        // Check if the quantity of the item has been increased
        assertEquals(2, panier.getArticle(article1.getFromage()).getQuantite());
    }

    @Test
    public void testAddArticleToPanierWithExistingArticleAndInsufficientStock() {
        // Add an item to the cart
        panier.addArticle(article1,1);

        // Add the same item to the cart with an insufficient stock
        try {
            panier.addArticle(article1,10);
            fail("An IllegalArgumentException should have been thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Quantite en stock insuffisante", e.getMessage());
        }
    }

    @Test
    public void testAddArticleToPanierWithExistingArticleAndInvalidQuantity() {
        // Add an item to the cart
        panier.addArticle(article1,1);

        // Add the same item to the cart with an invalid quantity
        try {
            panier.addArticle(article1,-1);
            fail("An IllegalArgumentException should have been thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Quantité invalide", e.getMessage());
        }
    }

    @Test
    public void testRemoveArticleFromPanierWithNonExistingArticle() {
        // Remove an item from the cart
        try {
            panier.removeArticle(article1);
            fail("An IllegalArgumentException should have been thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Article non présent dans le panier", e.getMessage());
        }
    }

    @Test
    public void testRemoveArticleFromPanierWithNonExistingArticleSelectionne() {
        // Remove an item from the cart
        try {
            panier.removeArticle(new ArticleSelectionne(article1,1));
            fail("An IllegalArgumentException should have been thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Article non présent dans le panier", e.getMessage());
        }
    }

    @Test
    public void testRemoveArticleSelectionneFromPanierWithNonExistingArticleSelectionne() {
        // Remove an item from the cart
        try {
            panier.removeArticle(new ArticleSelectionne(article1,1));
            fail("An IllegalArgumentException should have been thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Article non présent dans le panier", e.getMessage());
        }
    }

    @Test
    public void testGetArticleFromPanier() {
        // Add an item to the cart
        panier.addArticle(article1,1);

        // Get the item from the cart
        ArticleSelectionne articleSelectionne = panier.getArticle(article1.getFromage());

        // Check if the item has been retrieved from the cart
        assertEquals(article1, articleSelectionne.getArticle());
    }
}