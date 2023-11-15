package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.Carte;
import bean.Utilisateur;

public class ListePlat_jdbc {
	
	Connection con = null;
	Statement stmt = null;
	ResultSet resultat = null;

	
	public void acceAlabase() {
		DatabaseConnectionManager dbManager = DatabaseConnectionManager.getInstance();
        con = dbManager.getConnection();
	}
	
	
	public List<Carte> lister(){
		List<Carte> plats = new ArrayList<Carte>();
		
		acceAlabase();
		try {	
			stmt = con.createStatement();
			resultat = stmt.executeQuery("SELECT * FROM `carte`;");
			
			while (resultat.next()) {
				Integer id_plat = resultat.getInt("id_plat");
				String nom_plat	 = resultat.getString("nom_plat");
				String description = resultat.getString("description");
				Float prix = resultat.getFloat("prix");
				Boolean disponibilité = resultat.getBoolean("disponibilite");
				String image = resultat.getString("image");
				
				Carte carte = new Carte();
		
				carte.setId_plat(id_plat);
				carte.setNom_plat(nom_plat);
				carte.setDescription(description);
				carte.setPrix(prix);
				carte.setDisponibilité(disponibilité);
				carte.setImage(image);
				
				plats.add(carte);
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	return plats;
	
	}
	

}
