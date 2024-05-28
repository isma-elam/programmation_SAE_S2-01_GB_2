package modele;

import java.util.LinkedList;
import java.util.List;

public class LigneFacture{

    private Fromage fromage;
    private String cle;
    private float prixUnitaire;
    private int quantite;
    private double total;

    public LigneFacture(ArticleSelectionne a, int quantite, double total) {
        this.fromage = a.get.getFromage();
        this.cle = a.getCle();
        this.prixUnitaire = a.getPrixTTC();
        this.quantite = quantite;
        this.total = total;
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
