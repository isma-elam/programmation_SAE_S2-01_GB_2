package modele;

import java.util.List;

public abstract class Filtre {
    public Filtre() {

    }

    public abstract void appliquerFiltre(List<Article> articles);
}
