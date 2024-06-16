package modele;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Facture {
    private String nom;
    private String prenom;
    private String adresse1;
    private String adresse2;
    private String codePostal;
    private String ville;
    private String tel;
    private String mail;
    private List<LigneFacture> lignes = new LinkedList<LigneFacture>();
    private String totalSansLivraison;
    private double fraisTransport;
    private String totalAvecLivraison;
    private String typePaiment;
    private String livreur;
    private Panier panier;

    public Facture (String nom, String prenom, String adresse1, String adresse2, String codePostal, String ville, String tel, String mail, double fraisTransport, String typePaiment, String livreur, Panier panier){
        this.nom = nom;
        this.prenom = prenom;
        this.adresse1 = adresse1;
        this.adresse2 = adresse2;
        this.codePostal = codePostal;
        this.ville = ville;
        this.tel = tel;
        this.mail = mail;
        this.lignes = new ArrayList<>();
        this.panier = panier;

        double totalSLTmp = 0;
        for (ArticleSelectionne a : panier.getArticles()) {
            this.lignes.add(new LigneFacture(a));
            totalSLTmp += a.total();
        }

        this.totalSansLivraison = String.valueOf(totalSLTmp);
        this.fraisTransport = fraisTransport;
        this.totalAvecLivraison = String.valueOf(totalSLTmp + fraisTransport);

        this.typePaiment = typePaiment;
        this.livreur = livreur;
    }

    public String getNom() {
        return nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public String getAdresse1() {
        return adresse1;
    }
    public String getAdresse2() {
        return adresse2;
    }
    public String getCodePostal() {
        return this.codePostal;
    }
    public String getVille() {
        return ville;
    }
    public String getTel() {
        return tel;
    }
    public String getMail() {
        return mail;
    }
    public List<LigneFacture> getLignes() {
        return lignes;
    }
    public String getTotalSansLivraison(){
        return totalSansLivraison;
    }
    public double getFraisTransport() {
        return fraisTransport;
    }
    public String getTotalAvecLivraison(){
        return totalAvecLivraison;
    }
    public String getTypePaiment() {
        return typePaiment;
    }
    public String getLivreur() {
        return livreur;
    }
    
    public String generateHTML() {
        StringBuilder invoice = new StringBuilder();
        invoice.append("<html><head><title>FACTURE</title>");
        invoice.append("<style>");
        invoice.append("body { font-family: Arial, sans-serif; background-color: #fff; color: #333; margin: 20px; }");
        invoice.append("h1, h2 { text-align: center; color: #ff8c00; }");
        invoice.append("table { width: 100%; border-collapse: collapse; margin-bottom: 20px; }");
        invoice.append("th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }");
        invoice.append("th { background-color: #f2f2f2; }");
        invoice.append("ul { list-style-type: none; padding: 0; }");
        invoice.append("</style>");
        invoice.append("</head><body>");
        invoice.append("<h1>FACTURE</h1>");
        invoice.append("<h2>Coordonnées</h2>");
        invoice.append("<p><strong>Nom:</strong> ").append(nom).append("</p>");
        invoice.append("<p><strong>Adresse:</strong> ").append(adresse1).append("</p>");
        invoice.append("<p><strong>Téléphone:</strong> ").append(tel).append("</p>");
        invoice.append("<p><strong>Email:</strong> ").append(mail).append("</p>");
        invoice.append("<p><strong>Mode de paiement:</strong> ").append(typePaiment).append("</p>");
        invoice.append("<h2>Détails de la commande</h2>");
        invoice.append("<table>");
        invoice.append("<tr><th>Fromage</th><th>Quantité</th><th>Prix unitaire</th></tr>");
        for (ArticleSelectionne article : panier.getArticles()) {
            invoice.append("<tr>");
            invoice.append("<td>").append(article.getFromage().getDesignation()).append(" (").append(article.getArticle().getCle()).append(")").append("</td>");
            invoice.append("<td>").append(article.getQuantite()).append("</td>");
            invoice.append("<td>").append(String.format("%.2f €", article.getArticle().getPrixTTC())).append("</td>");
            invoice.append("</tr>");
        }
        invoice.append("<tr><td colspan='2'><strong>Total fromage:</strong></td><td>").append(String.format("%.2f €", panier.prixTotal())).append("</td></tr>");
        invoice.append("<tr><td colspan='2'><strong>Livraison:</strong></td><td>").append(String.format("%.2f €", panier.fraisPort())).append("</td></tr>");
        invoice.append("<tr><td colspan='2'><strong>Total:</strong></td><td>").append(String.format("%.2f €", panier.total())).append("</td></tr>");
        invoice.append("</table>");
        invoice.append("</body></html>");
        return invoice.toString();
    }
}
