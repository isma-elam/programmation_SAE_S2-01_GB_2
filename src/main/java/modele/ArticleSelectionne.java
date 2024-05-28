package modele;

public class ArticleSelectionne {
    private Article article;

    private int quantite;

    public ArticleSelectionne(Article article, int quantite) {
        this.article = article;
        this.quantite = quantite;

    }

    public double getPrixTTC() {
        return this.article.getPrixTTC() * this.quantite;
    }

    public Object getFromage() {
        return this.article.getFromage();
    }

    public String toString() {
        return this.article.toString() + ", Quantite : " + this.quantite;
    }

    public int getQuantite() {
        return this.quantite;
    }

    public void setQuantite(int quantite) {
        if (article.getQuantiteEnStock() < quantite) {
            throw new IllegalArgumentException("Quantite en stock insuffisante");
        }
        this.quantite = quantite;
    }

    public void ajouter(int quantite) {
        if (article.getQuantiteEnStock() < this.quantite + quantite) {
            throw new IllegalArgumentException("Quantite en stock insuffisante");
        }
        this.quantite += quantite;
    }
}
