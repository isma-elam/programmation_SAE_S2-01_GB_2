package modele;

import java.util.ArrayList;
import java.util.List;

public class Facture {
    private String nom_client;
    private String prenom_client;
    private String adresse_livraison_client;
    private String numero_client;
    private String numero_comande;

    private List<ArticleSelectionne> panier;

    public Facture(String nom_client, String prenom_client, String adresse_livraison_client, String numero_client, String numero_comande, Panier panier) {
        this.nom_client = nom_client;
        this.prenom_client = prenom_client;
        this.adresse_livraison_client = adresse_livraison_client;
        this.numero_client = numero_client;
        this.numero_comande = numero_comande;

        this.panier = panier.getArticles();
    }

    @Override
    public String toString () {
        String res = "";
        res += "Nom: " + nom_client + "\n" + "Prenom: " + prenom_client + "\n"
                + "Adresse livraison: " + adresse_livraison_client + "\n" + "Numero: " + numero_client + "\n" + "Numero: " + numero_comande + "\n";
        res += "\n" + "Commande : " + "\n";
        for (ArticleSelectionne a : panier) {
            res += a.toString() + "\n";
        }

        return res;
    }
}
