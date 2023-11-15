package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Carte;

public class CommandeUserJdbc {
	
	Connection con = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultat = null;

	
	public void acceAlabase() {
		DatabaseConnectionManager dbManager = DatabaseConnectionManager.getInstance();
        con = dbManager.getConnection();
	}
	
	public List<Carte> listerCommande(Integer id_user){
		List<Carte> plats = new ArrayList<Carte>();
		
		acceAlabase();
		try {	
			
			String sql = "SELECT c.*, cc.* FROM carte c INNER JOIN carte_commande cc ON c.id_plat = cc.id_plat WHERE cc.id_user = ?;";
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, id_user);
			
			resultat  = preparedStatement.executeQuery();;
	
			while (resultat.next()) {
				Integer id_plat = resultat.getInt("id");
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
