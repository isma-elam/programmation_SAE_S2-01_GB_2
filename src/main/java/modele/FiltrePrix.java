package modele;

import java.util.List;

public class FiltrePrix extends Filtre{
    private float min;
    private float max;

    public FiltrePrix(float min, float max) {
        this.min = min;
        this.max = max;
    }

    public float getMin() {
        return min;
    }

    public float getMax() {
        return max;
    }

    @Override
    public void appliquerFiltre(List<Article> articles) {

    }
}
