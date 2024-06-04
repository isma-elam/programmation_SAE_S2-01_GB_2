package modele;

import java.util.ArrayList;
import java.util.List;

public class Recherche {
    private String key;
    private List<Fromage> fromages;
    private List<Filtres> filtres;

    public Recherche(String key, List<Fromage> fromages, List<Filtres> filtres) {
        this.key = key;
        this.fromages = fromages;
        this.filtres = filtres;
    }

    public List<Fromage> getResultat (){
//        List<Fromage> resultat = new ArrayList<Fromage>();
//
//        for (Fromage fromage : fromages) {
//            if ()
//        }
//
//        return resultat;
        return null;
    }
}
