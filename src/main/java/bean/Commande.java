package bean;


public class Commande {
	
	private Integer id_plat;
	private String nom_plat;
	private String nom;
	private Float prix;
	private String quantite;
	private String image;
	private String statut;
	
	
	public Commande(Integer id_plat, String nom_plat, String nom, Float prix, String quantite, String image) {
		super();
		this.id_plat = id_plat;
		this.nom_plat = nom_plat;
		this.nom = nom;
		this.prix = prix;
		this.quantite = quantite;
		this.image = image;
	}


	public Commande() {

	}


	public Integer getId_plat() {
		return id_plat;
	}


	public void setId_plat(Integer id_plat) {
		this.id_plat = id_plat;
	}


	public String getNom_plat() {
		return nom_plat;
	}


	public void setNom_plat(String nom_plat) {
		this.nom_plat = nom_plat;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public Float getPrix() {
		return prix;
	}


	public void setPrix(Float prix) {
		this.prix = prix;
	}


	public String getQuantite() {
		return quantite;
	}


	public void setQuantite(String quantite) {
		this.quantite = quantite;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}	
	
	
	public void setStatut(String statut) {
		this.statut = statut;
	}
	
	
	public String getStatut() {
		return statut;
	}
	
	
	

}
