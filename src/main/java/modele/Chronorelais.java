package modele;

public class Chronorelais extends Transporteur{
    public Chronorelais() {
        super("Chronorelais");
    }

    @Override
    public double getFraisPort(double prixTotal) {
        if (prixTotal < 60) {
            return 14.90;
        } else if (prixTotal < 90) {
            return 9.90;
        } else if (prixTotal < 120) {
            return 4.90;
        } else {
            return 0;
        }
    }
}
