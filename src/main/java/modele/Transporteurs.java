package modele;

public class Transporteurs {
    public Transporteur[] TRANSPORTEURS = new Transporteur[3];

    public Transporteurs() {
        TRANSPORTEURS[0] = new Chronofresh();
        TRANSPORTEURS[1] = new Colissimo();
        TRANSPORTEURS[2] = new Chronorelais();
    }

    public Transporteur getTransporteur(int i) {
        return TRANSPORTEURS[i];
    }
}
