package fr.eni.encheresdufond.dal;

import java.util.List;

import fr.eni.encheresdufond.bo.Utilisateur;

public interface UtilisateurDAO {
	
	Utilisateur readByPseudo(String pseudo);
	Utilisateur readByEmail(String email);

	List<Utilisateur> findAll();

}
