package fr.eni.encheresdufond.bll;

import java.util.List;

import fr.eni.encheresdufond.bo.Utilisateur;


public interface UtilisateurService {
	
	List<Utilisateur> consulterUtilisateurs();
	Utilisateur searchByPseudo(String Pseudo);
	Utilisateur searchByEmail(String Email);

	
	

}
