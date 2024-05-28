package modele;

import java.util.LinkedList;
import java.util.List;

public class LigneFacture{

    private Fromage fromage;
    private String cle;
    private float prixUnitaire;
    private int quantite;
    private double total;

    public LigneFacture(ArticleSelectionne a) {
        this.fromage = a.getArticle().getFromage();
        this.cle = a.getArticle().getCle();
        this.prixUnitaire = a.getArticle().getPrixTTC();
        this.quantite = a.getQuantite();
        this.total = a.total();
    }

    public Fromage getFromage() {
        return fromage;
    }

    public String getCle() {
        return cle;
    }

    public float getPrixUnitaire() {
        return prixUnitaire;
    }

    public int getQuantite() {
        return quantite;
    }

    public double getTotal() {
        return total;
    }
}
