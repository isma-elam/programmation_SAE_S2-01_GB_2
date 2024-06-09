package modele;

public abstract class Transporteur {
    private String nom;

    public Transporteur(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public abstract double getFraisPort(double prixTotal);

    @Override
    public String toString() {
        return nom;
    }
}
