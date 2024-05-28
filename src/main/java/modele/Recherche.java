package modele;

import java.util.ArrayList;
import java.util.List;

public class Recherche {
    private String key;
    private List<Fromage> fromages;

    public Recherche(String key, List<Fromage> fromages, List<Filtres>) {
        this.key = key;
        this.fromages = fromages;
    }

    public List<Fromage> getResultat (){
        List<Fromage> resultat = new ArrayList<Fromage>();

        for (Fromage fromage : fromages) {
            if ()
        }
    }
}
