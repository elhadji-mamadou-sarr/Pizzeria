package form;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import bean.Utilisateur;


public class FormInscription {
	
	protected Map<String,String> erreurs = new HashMap<>();
	private String resultat;
	public Utilisateur inscrire(HttpServletRequest requet) {
		 
	
		String password = requet.getParameter("password");
		String confPassword= requet.getParameter("confPassword");

		Utilisateur bean = new Utilisateur();
		
		String erreur_password = bean.validationPassword(password);
		String erreur_confPassword = bean.confPassword(confPassword);

		
		if (erreur_password != null) {
			erreurs.put("password", erreur_password);
		}
		if (erreur_confPassword != null) {
			erreurs.put("confPassword", erreur_confPassword);
		}
		
		
		if (erreurs.isEmpty()) {
			 resultat = "Inscription valider";
		}else
			resultat = "Echec de l'inscription ";
		
		return bean;
	}

	public Map<String, String> getErreurs() {
		return erreurs;
	}

	public void setErreurs(Map<String, String> erreurs) {
		this.erreurs = erreurs;
	}

	public String getResultat() {
		return resultat;
	}

	public void setResultat(String resultat) {
		this.resultat = resultat;
	}
	
	

}
