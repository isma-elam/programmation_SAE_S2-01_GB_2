package modele;

public class SaisieFromage {

	private String designation;
	private String nomImage;
	private String description;
	private TypeVente vente;
	private String[] cleArticle;
	private float[] prixArticle;

	public SaisieFromage(String designation, String nomImage,
	        String description, TypeVente vente) {
		this.designation = designation;
		this.nomImage = nomImage;
		this.description = description;
		this.vente = vente;
	}

	public SaisieFromage(String designation, String nomImage,
	        String description, TypeVente vente, String[] cleArticle,
	        float[] prixArticle) {
		this(designation, nomImage, description, vente);
		this.cleArticle = cleArticle;
		this.prixArticle = prixArticle;
	}

	public Fromage builderFromage() {
		Fromage f = null;
		switch (this.vente) {
		case A_LA_COUPE_AU_POIDS:
			f = new FromageALaCoupe(this.designation);
			if (this.prixArticle != null && this.prixArticle.length > 1
			        && this.cleArticle != null && this.cleArticle.length > 1
			        && this.cleArticle.length == this.prixArticle.length) {
				for (int i = 0; i < this.cleArticle.length; i++) {
					f.addArticle(this.cleArticle[i], this.prixArticle[i]);
				}
			}
			break;
		case A_L_UNITE:
			f = new FromageALUnite(this.designation);
			if (this.prixArticle != null) {
				f.addArticle("", this.prixArticle[0]);
			}
			break;
		case ENTIER_OU_MOITIE:
			f = new FromageEntierOuMoitie(this.designation);
			if (this.prixArticle != null && this.prixArticle.length == 2) {
				f.addArticle(FromageEntierOuMoitie.MOITIE, this.prixArticle[0]);
				f.addArticle(FromageEntierOuMoitie.ENTIER, this.prixArticle[1]);
			}
			break;
		case A_L_UNITE_PlUSIEURS_CHOIX:
			f = new FromageALUnitePlusieursChoix(this.designation);
			if (this.prixArticle != null && this.prixArticle.length == 1
			        && this.cleArticle != null && this.cleArticle.length > 1) {
				for (String cle : this.cleArticle) {
					f.addArticle(cle, this.prixArticle[0]);
				}
			}
			break;
		case POUR_X_PERSONNES:
			f = new FromagePourXPersonnes(this.designation);
			if (this.prixArticle != null && this.prixArticle.length > 1
			        && this.cleArticle != null && this.cleArticle.length > 1
			        && this.cleArticle.length == this.prixArticle.length) {
				for (int i = 0; i < this.cleArticle.length; i++) {
					f.addArticle("pour " + this.cleArticle[i] + " personnes",
					        this.prixArticle[i]);
				}
			}
			break;
		}
		f.addDescription(this.description);
		f.addNomImage(this.nomImage);
		return f;
	}

}
