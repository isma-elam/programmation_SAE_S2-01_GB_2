package modele;

import java.util.List;

public class FiltreTypeDeLait extends Filtre{
    private TypeLait typeDeLait;

    public FiltreTypeDeLait(TypeLait typeDeLait) {
        this.typeDeLait = typeDeLait;
    }

    @Override
    public void appliquerFiltre(List<Article> articles) {

    }
}
