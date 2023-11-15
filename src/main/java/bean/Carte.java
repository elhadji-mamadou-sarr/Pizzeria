package bean;

import javax.servlet.http.Part;

public class Carte {
	
	private Integer id_plat;
	private String nom_plat;
	private String description;
	private Float prix;
	private Boolean disponibilité;
	private String image;
	public Carte() {
		super();
	}
	
	
	public Carte(Integer id_plat, String nom_plat, String description, Float prix, Boolean disponibilité) {
		super();
		this.id_plat = id_plat;
		this.nom_plat = nom_plat;
		this.description = description;
		this.prix = prix;
		this.disponibilité = disponibilité;
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


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Float getPrix() {
		return prix;
	}


	public void setPrix(Float prix) {
		this.prix = prix;
	}


	public Boolean getDisponibilité() {
		return disponibilité;
	}


	public void setDisponibilité(Boolean disponibilité) {
		this.disponibilité = disponibilité;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public String extractFileName(Part part) {
	    String contentDisp = part.getHeader("content-disposition");
	    String[] items = contentDisp.split(";");
	    for (String s : items) {
	        if (s.trim().startsWith("filename")) {
	            return s.substring(s.indexOf("=") + 2, s.length()-1);
	        }
	    }
	    return "";
	}

	
	
	
	
	
	
	

}
