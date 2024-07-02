package fr.eni.encheresdufond.bll;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import fr.eni.encheresdufond.bo.Utilisateur;
import fr.eni.encheresdufond.dal.UtilisateurDAO;

@Service
@Profile("dev")
public class UtilisateurServiceImpl implements UtilisateurService {

	private UtilisateurDAO utilisateurDAO;

	/**
	 * @param utilisateurDAO
	 */
	public UtilisateurServiceImpl(UtilisateurDAO utilisateurDAO) {
		this.utilisateurDAO = utilisateurDAO;
	}

	/**
	 * 
	 * Cette méthode retourne tout les utilisateurs
	 */
	@Override
	public List<Utilisateur> consulterUtilisateurs() {
		return utilisateurDAO.findAll();
	}

	@Override
	public Utilisateur searchByPseudo(String Pseudo) {
		
		return utilisateurDAO.readByPseudo(Pseudo);
	}

	@Override
	public Utilisateur searchByEmail(String Email) {
		
		return utilisateurDAO.readByEmail(Email);
	}

	
}
