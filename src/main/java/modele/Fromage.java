package modele;

import java.util.LinkedList;
import java.util.List;

public class Fromage implements Comparable<Fromage> {

    private final String designation;
    private String nomImage;
    private String description;
    private TypeLait typeFromage;
    private List<Article> articles;

    public Fromage(String designation) {
        this.designation = designation;
        this.articles = new LinkedList<Article>();
    }

    public String getDesignation() {
        return this.designation;
    }

    public String getNomImage() {
        return this.nomImage;
    }

    public String getNomImagePath40() {
        return ("src\\main\\resources\\images\\fromages\\hauteur40\\" + this.nomImage + ".jpg");
    }

    public String getNomImagePath200() {
        return ("src\\main\\resources\\images\\fromages\\hauteur200\\" + this.nomImage + ".jpg");
    }

    public String getDescription() {
        assert !(this.description == null);
        if (this.description == null) {
            return "Pas de description de ce fromage pour le moment. Nous en sommes desoles";
        }
        return this.description;
    }

    public void addDescription(String description) {
        this.description = description;
    }

    public void addNomImage(String nomImage) {
        this.nomImage = nomImage;
    }

    public void updateTypeFromage(TypeLait type) {
        this.typeFromage = type;
    }

    public TypeLait getTypeFromage() {
        return this.typeFromage;
    }

    @Override
    public String toString() {
        return this.getDesignation() + ", Fromage au lait de "
                + this.typeFromage.getTypeDeLait();
    }

    public void addArticle(String cle, float prixTTC) {
        this.articles.add(new Article(this, cle, prixTTC));
    }

    public int nombreArticles() {
        return this.articles.size();
    }

    public List<Article> getArticles() {
        return this.articles;
    }

    public String getPrixs() {
        float prixmin = 1000000;
        float prixmax = 0;
        if (this.nombreArticles() > 1) {
            for (Article article : this.getArticles()) {
                if (article.getPrixTTC() < prixmin) {
                    prixmin = article.getPrixTTC();
                } else if (article.getPrixTTC() > prixmax) {
                    prixmax = article.getPrixTTC();
                }
            }
            return prixmin + " - " + prixmax;
        } else {
            return this.getArticles().get(0).getPrixTTC() + "";
        }
    }

    @Override
    public int compareTo(Fromage f) {
        return this.designation.compareTo(f.designation);
    }

    @Override
    public boolean equals(Object obj) {
        Fromage other = (Fromage) obj;
        return this.designation.equals(other.designation);
    }

}
