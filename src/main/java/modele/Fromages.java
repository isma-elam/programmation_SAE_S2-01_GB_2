package modele;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Fromages {

	private List<Fromage> fromages;

	public Fromages() {
		this.fromages = new LinkedList<Fromage>();
	}

	public void addFromages(List<Fromage> fromages) {
		this.fromages.addAll(fromages);
	}

	public String toStringFromagesEtArticles() {
		StringBuffer enForme = new StringBuffer();
		for (Fromage f : this.fromages) {
			enForme.append(f.toString() + '\n');
			if (f.nombreArticles() > 0) {
				for (Article article : f.getArticles()) {
					enForme.append(article.toString() + '\n');
				}
			}
		}
		return enForme.toString();
	}

	public String toStringArticlesEtStock() {
		StringBuffer enForme = new StringBuffer();
		for (Fromage f : this.fromages) {
			if (f.nombreArticles() > 0) {
				for (Article article : f.getArticles()) {
					enForme.append(article.toStringAvecStock() + '\n');
				}
			}
		}
		return enForme.toString();
	}

	public List<Fromage> fromagesAuLaitDe(TypeLait lait) {
		List<Fromage> fromagesAuLaitDe = new LinkedList<Fromage>();
		for (Fromage f : this.fromages) {
			if (f.getTypeFromage().equals(lait)) {
				fromagesAuLaitDe.add(f);
			}
		}
		return fromagesAuLaitDe;
	}

	public List<Fromage> getFromages() {
		Collections.sort(this.fromages);
		return this.fromages;
	}

	public Fromage getFromage(String designation) {
		for (Fromage f : this.fromages) {
			if (f.getDesignation().equals(designation)) {
				return f;
			}
		}
		return null;
	}

	public void regenerationDuStock() {
		for (Fromage f : this.fromages) {
			if (f.nombreArticles() > 0) {
				for (Article article : f.getArticles()) {
					article.setQuantiteEnStock(
					        (int) Math.round(Math.random() * 100));
				}
			}
		}
	}

	public String verificationSaisie() {
		StringBuffer enForme = new StringBuffer();
		for (Fromage f : this.fromages) {
			if (f.nombreArticles() == 0) {
				enForme.append("Pas d'articles pour " + f.toString() + '\n');
			}
			if (f.getDescription() == null) {
				enForme.append(
				        "Pas de description pour " + f.toString() + '\n');
			}
			if (f.getNomImage() == null) {
				enForme.append(
				        "Pas de nom d'image pour " + f.toString() + '\n');
			}
		}
		return enForme.toString();
	}

	public Article getArticle(String designation, String cle) {
		for (Fromage f : this.fromages) {
			if (f.getDesignation().equals(designation)) {
				for (Article article : f.getArticles()) {
					if (article.getCle().equals(cle)) {
						return article;
					}
				}
			}
		}
		return null;
	}

	public List<Fromage> Recherche(String recherche) {
		List<Fromage> fromagesRecherches = new LinkedList<Fromage>();
		for (Fromage f : this.fromages) {
			if (f.getDesignation().toLowerCase().contains(recherche)) {
				fromagesRecherches.add(f);
			}
		}
		return fromagesRecherches;
	}
}
