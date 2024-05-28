package modele;

import java.util.ArrayList;
import java.util.List;

public class Facture {

    private List<ArticleSelectionne> panier;

    public Facture(Panier panier) {
        this.panier = panier.getArticles();
    }

    @Override
    public String toString () {
        String res = "";
        for (ArticleSelectionne a : panier) {
            res += a.toString() + "\n";
        }

        return res;
    }
}
