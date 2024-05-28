package modele;

public class FromageEntierOuMoitie extends Fromage {

	public static final String MOITIE = "moitie";
	public static final String ENTIER = "entier";

	public FromageEntierOuMoitie(String designation) {
		super(designation);
	}

	@Override
	public String toString() {
		return super.toString() + ", vendu entier ou par moitie";
	}

}
