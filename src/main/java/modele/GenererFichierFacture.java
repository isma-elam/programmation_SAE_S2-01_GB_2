package modele;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class GenererFichierFacture {

    public static void main(String[] args) {
        Facture facture = new Facture("Client XYZ", "123 Rue Exemple, Ville", "28/05/2024");
        facture.ajouterLigne(new LigneFacture("Produit A", 2, 50.0));
        facture.ajouterLigne(new LigneFacture("Produit B", 1, 100.0));
        facture.ajouterLigne(new LigneFacture("Produit C", 5, 20.0));

        try {
            genererHtml(facture, "facture.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void genererHtml(Facture facture, String chemin) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(chemin));

        writer.write("<html>");
        writer.write("<head><title>Facture</title></head>");
        writer.write("<body>");
        writer.write("<h1>Facture</h1>");
        writer.write("<p><strong>Client:</strong> " + facture.getClient() + "</p>");
        writer.write("<p><strong>Adresse:</strong> " + facture.getAdresse() + "</p>");
        writer.write("<p><strong>Date:</strong> " + facture.getDate() + "</p>");

        writer.write("<table border='1'>");
        writer.write("<tr><th>Description</th><th>Quantité</th><th>Prix Unitaire</th><th>Total</th></tr>");
        for (LigneFacture ligne : facture.getLignes()) {
            writer.write("<tr>");
            writer.write("<td>" + ligne.getDescription() + "</td>");
            writer.write("<td>" + ligne.getQuantite() + "</td>");
            writer.write("<td>" + ligne.getPrixUnitaire() + "</td>");
            writer.write("<td>" + ligne.getTotal() + "</td>");
            writer.write("</tr>");
        }
        writer.write("</table>");

        writer.write("</body>");
        writer.write("</html>");

        writer.close();
    }
}
