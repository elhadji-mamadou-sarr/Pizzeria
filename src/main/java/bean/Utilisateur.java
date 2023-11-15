package bean;

public class Utilisateur {
	
	private Integer id_user;
	protected String nom;
	protected String prenom;
	protected String email;
	protected String telephone;
	protected String profil;
	protected String password;
	protected String confPassword;
	
	public Utilisateur() {
		
	}

	public Utilisateur(Integer id_user, String nom, String prenom, String email, String telephone, String profil,
			String password, String confPassword) {
		super();
		this.id_user = id_user;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.profil = profil;
		this.password = password;
		this.confPassword = confPassword;
	}


	public Integer getId_user() {
		return id_user;
	}

	public void setId_user(Integer id_user) {
		this.id_user = id_user;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProfil() {
		return profil;
	}

	public void setProfil(String profil) {
		this.profil = profil;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfPassword() {
		return confPassword;
	}

	public void setConfPassword(String confPassword) {
		this.confPassword = confPassword;
	}
	
	
	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public String validationPassword(String password) {
		this.password = password;
		if (this.password != null || !this.password.isEmpty()){
			if (verifieMot(this.password)) {
				return null;
			}else
			return "Le mot de passe doit avoir une majuscule et un chiffre";
		}else
			return "Password obligatoire";
	}
	
	
	public String confPassword(String confPassword) {
		this.confPassword = confPassword;
		if (this.confPassword != null || !this.confPassword.isEmpty()) {
			if (this.confPassword.equals(this.password)) {
				return null;		
			}else
			return "Mot de passe non conforme";
		}
		return "Confirmer votre mot de passe";
	}
	
	
	public static Boolean verifieMot(String mot) {	
		int maj=0, chiffre=0;
		for (int i = 0; i < mot.length(); i++) {
			if (Character.isUpperCase(mot.charAt(i)) ) {
				maj+=1;
			}
			if (Character.isDigit(mot.charAt(i))) {
				chiffre +=1;
			}
		}
		if (maj >= 1 && chiffre >= 1) {
			return true;
		}
		return false;
	}


}
