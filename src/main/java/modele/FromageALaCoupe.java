package modele;

public class FromageALaCoupe extends Fromage {

	public FromageALaCoupe(String designation) {
		super(designation);
	}

	@Override
	public String toString() {
		return super.toString() + ", vendu à la coupe ou au poids";
	}

}
