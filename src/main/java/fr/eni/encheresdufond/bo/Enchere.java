package fr.eni.encheresdufond.bo;

import java.time.LocalDate;
import java.util.Objects;

public class Enchere {

	 private LocalDate dateEnchere;
	 private int montantEnchere;

	 private Utilisateur utilisateur;
	 private ArticleVendu articleVendu;
	
	 
	 public Enchere(LocalDate dateEnchere, int montantEnchere, Utilisateur utilisateur, ArticleVendu articleVendu) {
		
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
		this.utilisateur = utilisateur;
		this.articleVendu = articleVendu;
	}


	/**
	 * @return the dateEnchere
	 */
	public LocalDate getDateEnchere() {
		return dateEnchere;
	}


	/**
	 * @param dateEnchere the dateEnchere to set
	 */
	public void setDateEnchere(LocalDate dateEnchere) {
		this.dateEnchere = dateEnchere;
	}


	/**
	 * @return the montantEnchere
	 */
	public int getMontantEnchere() {
		return montantEnchere;
	}


	/**
	 * @param montantEnchere the montantEnchere to set
	 */
	public void setMontantEnchere(int montantEnchere) {
		this.montantEnchere = montantEnchere;
	}


	/**
	 * @return the utilisateur
	 */
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}


	/**
	 * @param utilisateur the utilisateur to set
	 */
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}


	/**
	 * @return the articleVendu
	 */
	public ArticleVendu getArticleVendu() {
		return articleVendu;
	}


	/**
	 * @param articleVendu the articleVendu to set
	 */
	public void setArticleVendu(ArticleVendu articleVendu) {
		this.articleVendu = articleVendu;
	}


	@Override
	public String toString() {
		return String.format("Enchere [dateEnchere=%s, montantEnchere=%s, utilisateur=%s, articleVendu=%s]",
				dateEnchere, montantEnchere, utilisateur, articleVendu);
	}


	@Override
	public int hashCode() {
		return Objects.hash(articleVendu, dateEnchere, montantEnchere, utilisateur);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Enchere other = (Enchere) obj;
		return Objects.equals(articleVendu, other.articleVendu) && Objects.equals(dateEnchere, other.dateEnchere)
				&& montantEnchere == other.montantEnchere && Objects.equals(utilisateur, other.utilisateur);
	}




}
