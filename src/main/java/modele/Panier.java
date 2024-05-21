package modele;

import java.util.LinkedList;
import java.util.List;

public class Panier {
    private List<Article> articles;

    public Panier() {
        this.articles = new LinkedList<Article>();
    }

    public void addArticle(Article article) {
        this.articles.add(article);
    }

    public void removeArticle(Article article) {
        this.articles.remove(article);
    }

    public String toString() {
        StringBuffer enForme = new StringBuffer();
        for (Article article : this.articles) {
            enForme.append(article.toString() + '\n');
        }
        return enForme.toString();
    }

    public double prixTotal() {
        double prixTotal = 0;
        for (Article article : this.articles) {
            prixTotal += article.getPrixTTC();
        }
        return prixTotal;
    }

    public int nombreArticles() {
        return this.articles.size();
    }

    public List<Article> getArticles() {
        return this.articles;
    }

    public Article getArticle(int index) {
        return this.articles.get(index);
    }

    public void vider() {
        this.articles.clear();
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
        for (Article article : this.articles) {
            if (article.getFromage().equals(fromage)) {
                return article;
            }
        }
        return null;
    }
}
