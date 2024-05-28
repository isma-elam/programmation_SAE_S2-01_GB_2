package modele;

public class ArticleSelectionne {
    private final Article article;

    private int quantite;

    public ArticleSelectionne(Article article, int quantite) {
        this.article = article;
        this.quantite = quantite;
    }

    /**
     * Retourne le montant total de l'article selectionné
     * @return Montant total de l'article selectionné (prix TTC * quantité)
     */
    public double total() {
        return this.article.getPrixTTC() * this.quantite;
    }

    /**
     * Retourne le fromage de l'article selectionné
     * @return Fromage de l'article selectionné
     */
    public Object getFromage() {
        return this.article.getFromage();
    }


    @Override
    public String toString() {
        return this.article.toString() + ", Quantite : " + this.quantite;
    }

    /**
     * Retourne la quantité de l'article selectionné
     * @return Quantité de l'article selectionné
     */
    public int getQuantite() {
        return this.quantite;
    }

    /**
     * Modifie la quantité de l'article selectionné
     * @param quantite Nouvelle quantité
     */
    public void setQuantite(int quantite) {
        if (article.getQuantiteEnStock() < quantite) {
            throw new IllegalArgumentException("Quantite en stock insuffisante");
        }
        this.quantite = quantite;
    }

    /**
     * Ajoute une quantité à l'article selectionné si la quantité en stock est suffisante
     * @param quantite Quantité à ajouter
     */
    public void ajouter(int quantite) {
        if (article.getQuantiteEnStock() < this.quantite + quantite) {
            throw new IllegalArgumentException("Quantite en stock insuffisante");
        }
        this.quantite += quantite;
    }
}
