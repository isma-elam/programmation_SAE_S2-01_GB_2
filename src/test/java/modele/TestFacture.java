package modele;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestFacture {

    @Test
    public void testFactureCreation() {
        Facture facture = new Facture("John Doe", "", "123 Main St", "", "", "", "1234567890", "john.doe@example.com", 5.0, "Carte de crédit", "Transporteur", null);

        assertEquals("John Doe", facture.getNom());
        assertEquals("123 Main St", facture.getAdresse1());
        assertEquals("1234567890", facture.getTel());
        assertEquals("john.doe@example.com", facture.getMail());
        assertEquals(5.0, facture.getFraisTransport(), 0.01);
        assertEquals("Carte de crédit", facture.getTypePaiment());
        assertEquals("Transporteur", facture.getLivreur());
    }
}