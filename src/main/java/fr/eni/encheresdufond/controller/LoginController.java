package fr.eni.encheresdufond.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import fr.eni.encheresdufond.bll.UtilisateurService;
import fr.eni.encheresdufond.bo.Utilisateur;
import jakarta.validation.Valid;

@Controller
@SessionAttributes({"membreSession"})
public class LoginController {
	
	private UtilisateurService utilisateurService;

	public LoginController(UtilisateurService utilisateurService) {
		this.utilisateurService = utilisateurService;
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/logout")
	public String logout() {
		return "index";
	}
	
	@GetMapping("/connexion")
	public String connexion(@ModelAttribute("membreSession") Utilisateur membreSession, Principal principal) {
		
		String pseudo = principal.getName();
		
		Utilisateur utilisateur = this.utilisateurService.consulterUtilisateurParPseudo(pseudo);
		
		if (utilisateur != null) {
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
		} else {
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
		
		return "redirect:/";
	}

	@GetMapping("/inscription")
	public String afficherInscriptionUtilisateur(Model model) {
		
		Utilisateur u = new Utilisateur();
		model.addAttribute("utilisateur", u);
		
		return "inscription";
	}
	
	@PostMapping("/inscription")
	public String inscrireUnUtilisateur(@Valid @ModelAttribute("utilisateur") Utilisateur utilisateur, BindingResult bindingResult) {
		utilisateurService.creerUtilisateur(utilisateur);
		return "redirect:/connexion";
	}
	
	@ModelAttribute("membreSession")
	public Utilisateur chargerMembreSession() {
		return new Utilisateur();
	}
	
}
