package modele;

public class FromageALUnitePlusieursChoix extends Fromage {

	public FromageALUnitePlusieursChoix(String designation) {
		super(designation);
	}

	@Override
	public String toString() {
		return super.toString() + ", vendu à l'unite avec plusieurs choix";
	}

}
