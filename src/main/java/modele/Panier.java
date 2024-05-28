package modele;

import java.util.LinkedList;
import java.util.List;

public class Panier {
    private List<ArticleSelectionne> articles;

    public Panier() {

    }

    public void addArticle(Article article, int qte) {
        this.articles.add(new ArticleSelectionne(article, qte));
    }

    public void removeArticle(Article article) {
        this.articles.remove(article);
    }

    public String toString() {
        StringBuffer enForme = new StringBuffer();
        for (ArticleSelectionne article : this.articles) {
            enForme.append(article.toString() + '\n');
        }
        return enForme.toString();
    }

    public double prixTotal() {
        double prixTotal = 0;
        for (ArticleSelectionne article : this.articles) {
            prixTotal += article.getPrixTTC();
        }
        return prixTotal;
    }

    public int nombreArticles() {
        return this.articles.size();
    }

    public List<ArticleSelectionne> getArticles() {
        return this.articles;
    }

    public ArticleSelectionne getArticle(int index) {
        return this.articles.get(index);
    }

    public void vider() {
        this.articles.clear();
        for (ArticleSelectionne article : this.articles) {
            article.getFromage().resetStock();
        }
    }

    public boolean contient(Fromage fromage) {
        for (Article article : this.articles) {
            if (article.getFromage().equals(fromage)) {
                return true;
            }
        }
        return false;
    }

    public Article getArticle(Fromage fromage) {
        for (ArticleSelectionne article : this.articles) {
            if (article.getFromage().equals(fromage)) {
                return article;
            }
        }
        return null;
    }
}
