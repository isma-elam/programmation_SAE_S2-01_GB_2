package modele;

public class Article {

	private Fromage fromage;
	private String cle;
	private float prixTTC;
	private int quantiteEnStock;

	public Article(Fromage fromage, String cle, float prixTTC) {
		this.fromage = fromage;
		this.cle = cle;
		this.prixTTC = prixTTC;
		this.quantiteEnStock = 0;
	}

	public Fromage getFromage() {
		return this.fromage;
	}

	public float getPrixTTC() {
		return this.prixTTC;
	}

	public int getQuantiteEnStock() {
		return this.quantiteEnStock;
	}

	public String getCle() {
		return this.cle;
	}

	public void setQuantiteEnStock(int quantiteEnStock) {
		if (quantiteEnStock < 0) {
			throw new IllegalArgumentException("Quantite en stock negative");
		}
		this.quantiteEnStock = quantiteEnStock;
	}

	@Override
	public String toString() {
		if (this.cle.isEmpty()) {
			return this.fromage.getDesignation() + ", Prix TTC : "
			        + this.getPrixTTC() + " €";
		} else {
			return this.fromage.getDesignation() + ", " + this.cle
			        + ", Prix TTC : " + this.getPrixTTC() + " €";
		}
	}

	public String toStringAvecStock() {
		return this.toString() + ", Quantite en stock : "
		        + this.quantiteEnStock;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Article)) {
			return false;
		}
		Article other = (Article) obj;
		return (this.fromage.equals(other.fromage)
		        && this.cle.equals(other.cle));
	}

}
