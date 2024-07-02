package fr.eni.encheresdufond.bo;

import java.util.List;
import java.util.Objects;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;

public class Utilisateur {

	@NotNull
	private long noUtilisateur;
	
	@NotBlank
	@Size(max = 30)
	private String pseudo;
	
	
	@NotBlank
	@Size(max = 30)
	private String nom;
	
	
	@NotBlank
	@Size(max = 30)
	private String prenom;
	
	
	@NotBlank
	@Size(max = 20)
	private String email;
	
	
	@NotBlank
	@Size(max = 15)
	private String telephone;
	
	
	@NotBlank
	@Size(max = 30)
	private String rue;
	
	
	@NotBlank
	@Size(max = 10)
	private String codePostale;
	
	
	
	@NotBlank
	@Size(max = 30)
	private String ville;
	
	
	
	@NotBlank
	@Size(max = 30)
	private String motDePasse;
	
	
	
	@NotNull
	private int credit = 0;
	
	
	
	@NotNull
	private boolean isAdminisatrateur;
	
	private List<ArticleVendu> listeArticlesVendus;
    
	private List<Enchere> listeEncheres;
    
    public Utilisateur() {

	}

	public Utilisateur(long noUtilisateur, String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String codePostale, String ville, String motDePasse, int credit, boolean adminisatrateur) {
		
		this.noUtilisateur = noUtilisateur;
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.codePostale = codePostale;
		this.ville = ville;
		this.motDePasse = motDePasse;
		this.credit = credit;
		this.isAdminisatrateur = adminisatrateur;
		this.listeArticlesVendus = new ArrayList<ArticleVendu>();
		this.listeEncheres = new ArrayList<Enchere>();
	}

	/**
	 * @return the noUtilisateur
	 */
	public long getNoUtilisateur() {
		return noUtilisateur;
	}

	/**
	 * @param noUtilisateur the noUtilisateur to set
	 */
	public void setNoUtilisateur(long noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}

	/**
	 * @return the pseudo
	 */
	public String getPseudo() {
		return pseudo;
	}

	/**
	 * @param pseudo the pseudo to set
	 */
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * @param telephone the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
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
	 * @return the codePostale
	 */
	public String getCodePostale() {
		return codePostale;
	}

	/**
	 * @param codePostale the codePostale to set
	 */
	public void setCodePostale(String codePostale) {
		this.codePostale = codePostale;
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

	/**
	 * @return the motDePasse
	 */
	public String getMotDePasse() {
		return motDePasse;
	}

	/**
	 * @param motDePasse the motDePasse to set
	 */
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	/**
	 * @return the credit
	 */
	public int getCredit() {
		return credit;
	}

	/**
	 * @param credit the credit to set
	 */
	public void setCredit(int credit) {
		this.credit = credit;
	}

	/**
	 * @return the adminisatrateur
	 */
	public boolean isAdminisatrateur() {
		return isAdminisatrateur;
	}

	/**
	 * @param adminisatrateur the adminisatrateur to set
	 */
	public void setAdminisatrateur(boolean adminisatrateur) {
		this.isAdminisatrateur = adminisatrateur;
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

	/**
	 * @return the listeEncheres
	 */
	public List<Enchere> getListeEncheres() {
		return listeEncheres;
	}

	/**
	 * @param listeEncheres the listeEncheres to set
	 */
	public void setListeEncheres(List<Enchere> listeEncheres) {
		this.listeEncheres = listeEncheres;
	}

	@Override
	public String toString() {
		return String.format(
				"Utilisateur [noUtilisateur=%s, pseudo=%s, nom=%s, prenom=%s, email=%s, telephone=%s, rue=%s, codePostale=%s, ville=%s, motDePasse=%s, credit=%s, adminisatrateur=%s, listeArticlesVendus=%s, listeEncheres=%s]",
				noUtilisateur, pseudo, nom, prenom, email, telephone, rue, codePostale, ville, motDePasse, credit,
				isAdminisatrateur, listeArticlesVendus, listeEncheres);
	}

	@Override
	public int hashCode() {
		return Objects.hash(isAdminisatrateur, codePostale, credit, email, listeArticlesVendus, listeEncheres, motDePasse,
				noUtilisateur, nom, prenom, pseudo, rue, telephone, ville);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Utilisateur other = (Utilisateur) obj;
		return isAdminisatrateur == other.isAdminisatrateur && Objects.equals(codePostale, other.codePostale)
				&& credit == other.credit && Objects.equals(email, other.email)
				&& Objects.equals(listeArticlesVendus, other.listeArticlesVendus)
				&& Objects.equals(listeEncheres, other.listeEncheres) && Objects.equals(motDePasse, other.motDePasse)
				&& noUtilisateur == other.noUtilisateur && Objects.equals(nom, other.nom)
				&& Objects.equals(prenom, other.prenom) && Objects.equals(pseudo, other.pseudo)
				&& Objects.equals(rue, other.rue) && Objects.equals(telephone, other.telephone)
				&& Objects.equals(ville, other.ville);
	}

	

	
}
