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
    private String fraisTransport;
    private String totalAvecLivraison;
    private String typePaiment;
    private String livreur;

    public Facture (String nom, String prenom, String adresse1, String adresse2, String codePostal, String ville, String tel, String mail, String fraisTransport, String typePaiment, String livreur, Panier panier){
        this.nom = nom;
        this.prenom = prenom;
        this.adresse1 = adresse1;
        this.adresse2 = adresse2;
        this.codePostal = codePostal;
        this.ville = ville;
        this.tel = tel;
        this.mail = mail;
        this.lignes = new ArrayList<>();

        double totalSLTmp = 0;
        for (ArticleSelectionne a : panier.getArticles()) {
            this.lignes.add(new LigneFacture(a));
            totalSLTmp += a.total();
        }

        this.totalSansLivraison = String.valueOf(totalSLTmp);
        this.fraisTransport = fraisTransport;
        this.totalAvecLivraison = String.valueOf(totalSLTmp + Integer.parseInt(fraisTransport));

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
    public String getFraisTransport() {
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
}
