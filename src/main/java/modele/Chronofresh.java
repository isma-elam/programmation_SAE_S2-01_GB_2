package modele;

public class Chronofresh extends Transporteur{
    public Chronofresh() {
        super("Chronofresh");
    }

    @Override
    public double getFraisPort(double prixTotal) {
        if (prixTotal < 60) {
            return 23.80;
        } else if (prixTotal < 90) {
            return 17.80;
        } else if (prixTotal < 120) {
            return 9.90;
        } else {
            return 0;
        }
    }
}
