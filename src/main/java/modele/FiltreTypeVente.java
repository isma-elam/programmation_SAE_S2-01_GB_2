package modele;

import java.util.List;

public class FiltreTypeVente extends Filtre{
    private TypeVente typeVente;

    public FiltreTypeVente(TypeVente typeVente) {
        this.typeVente = typeVente;
    }

    @Override
    public void appliquerFiltre(List<Article> articles) {

    }
}
