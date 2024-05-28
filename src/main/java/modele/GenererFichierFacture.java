package modele;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class GenererFichierFacture {
    private Facture facture;
    private String nomFichierFacture;

    public GenererFichierFacture (Facture facture, String nomFichierFacture) {
        this.facture = facture;
        this.nomFichierFacture = nomFichierFacture + ".html";
        try {
            genererHtml(facture, nomFichierFacture);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void genererHtml(Facture facture, String chemin) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(chemin));

        writer.write("<html>");
        writer.write("<head><title>Facture</title></head>");
        writer.write("<body>");
        writer.write("<h1 style=\"color: blue; font-size: 36px; text-align: center;\">Fromagerie *nom* pour vous servir et resservir en fromages</h1>");
        writer.write("<br>");
        writer.write("<p><strong><em>" + facture.getPrenom() + " " + facture.getNom() + "</em></strong></p>");
        writer.write("<p>Adresse : <em> " + facture.getAdresse1() + " " + facture.getCodePostal() + " " + facture.getVille() + "</em></p>");
        writer.write("<p>Téléphone : <em> " + facture.getTel() + "</em></p>");
        writer.write("<p>Mèl : <em> " + facture.getMail() + "</em></p>");

        writer.write("<table border='1'>");
        writer.write("<th>Produit</th><th>Prix Unitaire</th><th>Quantité</th><th>PrixTTC</th>");
        for (LigneFacture ligne : facture.getLignes()) {
            writer.write("<tr>");
            writer.write("<td>" + ligne.getFromage().getDesignation() + "</td>");
            writer.write("<td>" + ligne.getPrixUnitaire() + "</td>");
            writer.write("<td>" + ligne.getQuantite() + "</td>");
            writer.write("<td>" + ligne.getTotal() + "</td>");
            writer.write("</tr>");
        }
        writer.write("</table>");

        writer.write("TOTAL TTC COMMANDE :      " + facture.getTotalSansLivraison() + " par " + facture.getTypePaiment());
        writer.write("FRAIS DE TRANSPORT :      " + facture.getFraisTransport() + " par " + facture.getLivreur());
        writer.write("PRIX TOTAL TTC :          " + facture.getTotalAvecLivraison());

        writer.write("</body>");
        writer.write("</html>");

        writer.close();
    }
}
