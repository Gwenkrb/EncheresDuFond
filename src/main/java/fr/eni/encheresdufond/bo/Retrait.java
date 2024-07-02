package fr.eni.encheresdufond.bo;

import java.util.Objects;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Retrait {

	
	 @NotBlank
	 @Size(max = 30)
	 private String rue;
	
	
	 @NotBlank
	 @Size(max = 15)
	 private String codePostal;
	 
	 
	 
	 
	 @NotBlank
	 @Size(max = 30)
	 private String ville;
	 
	 
	 
	 
	 private ArticleVendu articleVendu;
	
	 
	 public Retrait(String rue, String codePostal, String ville) {
		
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
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


	/**
	 * @return the rue
	 */
	public String getRue() {
		return rue;
	}


	/**
	 * @param rue the rue to set
	 */
	public void setRue(String rue) {
		this.rue = rue;
	}


	/**
	 * @return the codePostal
	 */
	public String getCodePostal() {
		return codePostal;
	}


	/**
	 * @param codePostal the codePostal to set
	 */
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}


	/**
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}


	/**
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}


	@Override
	public String toString() {
		return String.format("Retrait [rue=%s, codePostal=%s, ville=%s]", rue, codePostal, ville);
	}


	@Override
	public int hashCode() {
		return Objects.hash(codePostal, rue, ville);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Retrait other = (Retrait) obj;
		return Objects.equals(codePostal, other.codePostal) && Objects.equals(rue, other.rue)
				&& Objects.equals(ville, other.ville);
	}

	 
	 
}
