package fr.eni.encheresdufond.controller;

import java.security.Principal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import fr.eni.encheresdufond.bll.UtilisateurService;
import fr.eni.encheresdufond.bo.Utilisateur;

@Controller
@SessionAttributes({ "membreSession" })
public class LoginController {

	private UtilisateurService utilisateurService;

	public LoginController(UtilisateurService utilisateurService) {
		this.utilisateurService = utilisateurService;
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/connexion")
	public String connexion(@ModelAttribute("membreSession") Utilisateur membreSession, Principal principal) {
		if (principal == null) {
			resetMembreSession(membreSession);
			return "index";
		}

		String var = principal.getName();
		Utilisateur utilisateur = this.utilisateurService.searchByPseudo(var);
		if (utilisateur == null) {
			utilisateur = this.utilisateurService.searchByEmail(var);
		}
		if (utilisateur != null) {
			updateMembreSession(membreSession, utilisateur);
		} else {
			resetMembreSession(membreSession);
		}

		return "index";
	}

	private void updateMembreSession(Utilisateur membreSession, Utilisateur utilisateur) {
		membreSession.setNoUtilisateur(utilisateur.getNoUtilisateur());
		membreSession.setPseudo(utilisateur.getPseudo());
		membreSession.setPrenom(utilisateur.getPrenom());
		membreSession.setEmail(utilisateur.getEmail());
		membreSession.setTelephone(utilisateur.getTelephone());
		membreSession.setRue(utilisateur.getRue());
		membreSession.setCodePostale(utilisateur.getCodePostale());
		membreSession.setVille(utilisateur.getVille());
		membreSession.setMotDePasse(utilisateur.getMotDePasse());
		membreSession.setCredit(0);
		membreSession.setAdminisatrateur(utilisateur.isAdminisatrateur());
	}

	private void resetMembreSession(Utilisateur membreSession) {
		membreSession.setNoUtilisateur(0);
		membreSession.setPseudo(null);
		membreSession.setPrenom(null);
		membreSession.setEmail(null);
		membreSession.setTelephone(null);
		membreSession.setRue(null);
		membreSession.setCodePostale(null);
		membreSession.setVille(null);
		membreSession.setMotDePasse(null);
		membreSession.setCredit(0);
		membreSession.setAdminisatrateur(false);
	}

	@ModelAttribute("membreSession")
	public Utilisateur chargerMembreSession() {
		return new Utilisateur();
	}

}
