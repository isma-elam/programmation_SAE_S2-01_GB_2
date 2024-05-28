package modele;

import java.util.LinkedList;
import java.util.List;

public class Panier {

    private List<ArticleSelectionne> articles;

    public Panier() {
        this.articles = new LinkedList<ArticleSelectionne>();
    }

    /**
     * Ajoute un article au panier
     * si l'article est déjà présent, la quantité est augmentée
     * @param article Artible à ajouter
     * @param qte Quantité à ajouter
     */
    public void addArticle(Article article, int qte) {
        if (this.contient(article.getFromage())) {
            this.getArticle(article.getFromage()).ajouter(qte);
        }
        this.articles.add(new ArticleSelectionne(article, qte));
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
        StringBuffer enForme = new StringBuffer();
        for (ArticleSelectionne article : this.articles) {
            enForme.append(article.toString() + '\n');
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
            prixTotal += article.getPrixTTC();
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
}
