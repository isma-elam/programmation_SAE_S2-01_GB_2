package modele;

import java.util.LinkedList;
import java.util.List;

public class Panier {

    private final List<ArticleSelectionne> articles;

    private Transporteur transporteur;

    public Panier() {
        this.articles = new LinkedList<>();
    }

    /**
     * Ajoute un article au panier
     * si l'article est déjà présent, la quantité est augmentée
     * @param article Artible à ajouter
     * @param qte Quantité à ajouter
     */
    public void addArticle(Article article, int qte) {

        if (qte <= 0) {
            throw new IllegalArgumentException("Quantité invalide");
        }
        // qte positive
        if (this.contient(article)) {
            // si l'article est déjà présent
            this.getArticle(article.getFromage()).ajouter(qte);
            // on ajoute la quantité (vérification de quantité en stock dans la méthode ajouter)
        } else {

            if (article.getQuantiteEnStock() < qte) {
                // si la quantité en stock est insuffisante
                throw new IllegalArgumentException("Quantité en stock insuffisante");
                // on lève une exception
            } else {

                this.articles.add(new ArticleSelectionne(article, qte));
                // sinon on ajoute l'article au panier
            }
        }
    }

    /**
     * Supprime un article du panier
     * @param article Article à supprimer
     */
    public void removeArticle(Article article) {
        this.articles.remove(this.getArticle(article.getFromage()));
    }

    /**
     * Supprime un article du panier
     * @param articleSelectionne Article à supprimer
     */
    public void removeArticle(ArticleSelectionne articleSelectionne) {
        this.articles.remove(articleSelectionne);
    }

    /**
     * Retourne une représentation textuelle du panier
     * @return Représentation textuelle du panier
     */
    public String toString() {
        StringBuilder enForme = new StringBuilder();
        for (ArticleSelectionne article : this.articles) {
            enForme.append(article.toString()).append('\n');
        }
        return enForme.toString();
    }

    /**
     * Retourne le prix total du panier
     * @return Prix total du panier
     */
    public double prixTotal() {
        double prixTotal = 0;
        for (ArticleSelectionne article : this.articles) {
            prixTotal += article.total();
        }
        return prixTotal;
    }

    /**
     * Retourne le nombre d'articles dans le panier
     * @return Nombre d'articles dans le panier
     */
    public int nombreArticles() {
        return this.articles.size();
    }

    /**
     * Retourne la liste des articles du panier
     * @return Liste des articles du panier
     */
    public List<ArticleSelectionne> getArticles() {
        return this.articles;
    }

    /**
     * Retourne l'article à l'index donné
     * @param index Index de l'article
     * @return Article à l'index donné
     */
    public ArticleSelectionne getArticle(int index) {
        return this.articles.get(index);
    }

    /**
     * Vide le panier
     */
    public void vider() {
        this.articles.clear();
    }

    /**
     * Retourne vrai si le panier contient l'article donné
     * @param fromage Fromage à chercher
     * @return Vrai si le panier contient l'article donné
     */
    public boolean contient(Fromage fromage) {
        for (ArticleSelectionne article : this.articles) {
            if (article.getFromage().equals(fromage)) {
                return true;
            }
        }
        return false;
    }

    public boolean contient(Article article) {
        for (ArticleSelectionne articleSelectionne : this.articles) {
            if (articleSelectionne.getArticle().equals(article)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Retourne l'article correspondant au fromage donné
     * @param fromage Fromage à chercher
     * @return Article correspondant au fromage donné
     */
    public ArticleSelectionne getArticle(Fromage fromage) {
        for (ArticleSelectionne article : this.articles) {
            if (article.getFromage().equals(fromage)) {
                return article;
            }
        }
        return null;
    }

    public void setTransporteur(Transporteur transporteur) {
        this.transporteur = transporteur;
    }

    public Transporteur getTransporteur() {
        return this.transporteur;
    }

    public double fraisPort() {
        if (this.transporteur == null) {
            throw new IllegalStateException("Transporteur non défini");
        }
        return this.transporteur.getFraisPort(this.prixTotal());
    }

    public double total() {
        return this.prixTotal() + this.fraisPort();
    }
}
