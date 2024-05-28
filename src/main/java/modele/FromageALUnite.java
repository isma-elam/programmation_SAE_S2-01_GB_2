package modele;

public class FromageALUnite extends Fromage {

	public FromageALUnite(String designation) {
		super(designation);
	}

	@Override
	public String toString() {
		return super.toString() + ", vendu à l'unite";
	}

}
