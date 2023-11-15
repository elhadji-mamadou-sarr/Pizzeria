package bean;

public class CarteCommande {
	
	private Integer id;
	private Integer id_user;
	private Integer id_plat;
	private Float prix_total;
	
	
	public CarteCommande(Integer id, Integer id_user, Integer id_plat,  Float prix_total) {
		super();
		this.id = id;
		this.id_user = id_user;
		this.id_plat = id_plat;
		this.prix_total = prix_total;
	}


	public CarteCommande() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Integer getId() {
		return id;
	}
	
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	public Integer getId_user() {
		return id_user;
	}
	
	
	public void setId_commande(Integer id_commande) {
		this.id_user = id_commande;
	}
	
	
	public Integer getId_plat() {
		return id_plat;
	}
	
	
	public void setId_plat(Integer id_plat) {
		this.id_plat = id_plat;
	}
	
	
	public Float getPrix_total() {
		return prix_total;
	}
	
	
	public void setPrix_total(Float prix_total) {
		this.prix_total = prix_total;
	}


	public void setId_user(Integer id_user) {
		this.id_user = id_user;
	}
	
	

}
