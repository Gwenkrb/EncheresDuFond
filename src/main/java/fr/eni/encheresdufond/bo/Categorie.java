package fr.eni.encheresdufond.bo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Categorie {

	 private long noCategorie;
	 private String libelle;
	 private List<ArticleVendu> listeArticlesVendus;
	
	 
	 public Categorie(long noCategorie, String libelle) {
		
		this.noCategorie = noCategorie;
		this.libelle = libelle;
		listeArticlesVendus = new ArrayList<ArticleVendu>();
	}


	/**
	 * @return the noCategorie
	 */
	public long getNoCategorie() {
		return noCategorie;
	}


	/**
	 * @param noCategorie the noCategorie to set
	 */
	public void setNoCategorie(long noCategorie) {
		this.noCategorie = noCategorie;
	}


	/**
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}


	/**
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


	@Override
	public String toString() {
		return String.format("Categorie [noCategorie=%s, libelle=%s]", noCategorie, libelle);
	}


	@Override
	public int hashCode() {
		return Objects.hash(libelle, noCategorie);
	}


	/**
	 * @return the listeArticlesVendus
	 */
	public List<ArticleVendu> getListeArticlesVendus() {
		return listeArticlesVendus;
	}


	/**
	 * @param listeArticlesVendus the listeArticlesVendus to set
	 */
	public void setListeArticlesVendus(List<ArticleVendu> listeArticlesVendus) {
		this.listeArticlesVendus = listeArticlesVendus;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categorie other = (Categorie) obj;
		return Objects.equals(libelle, other.libelle) && noCategorie == other.noCategorie;
	}
	 
	 
}
