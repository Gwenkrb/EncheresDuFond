package fr.eni.encheresdufond.dal;

import java.util.List;

import fr.eni.encheresdufond.bo.Utilisateur;

public interface UtilisateurDAO {
	
	public Utilisateur read(long id);

	List<Utilisateur> findAll();

}
