package modele;

public class FromagePourXPersonnes extends Fromage {

	public FromagePourXPersonnes(String designation) {
		super(designation);
	}

	@Override
	public String toString() {
		return super.toString() + ", vendu par nombre de personnes";
	}

}
