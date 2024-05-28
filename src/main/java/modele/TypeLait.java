package modele;

public enum TypeLait {
	VACHE("Vache"), CHEVRE("Chèvre"), BREBIS("Brebis");

	private String typeDeLait;

	private TypeLait(String typeDeLait) {
		this.typeDeLait = typeDeLait;
	}

	public String getTypeDeLait() {
		return this.typeDeLait;
	}

	public static TypeLait getTypeLait(String denomination) {
		for (TypeLait t : TypeLait.values()) {
			if (t.getTypeDeLait().equals(denomination)) {
				return t;
			}
		}
		return null;
	}

}
