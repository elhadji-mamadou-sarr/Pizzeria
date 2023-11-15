package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Commande;

public class ValiderCommandeJdbc {
	
	Connection con = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultat = null;

	
	public void acceAlabase() {
		DatabaseConnectionManager dbManager = DatabaseConnectionManager.getInstance();
        con = dbManager.getConnection();
	}
	
	
	public List<Commande> validerCommande(){
		List<Commande> plats = new ArrayList<Commande>();
		
		acceAlabase();
		try {	
			
			String sql = "SELECT c.*, cc.* FROM carte c INNER JOIN carte_commande cc ON c.id_plat = cc.id_plat;";
			preparedStatement = con.prepareStatement(sql);
			
			resultat  = preparedStatement.executeQuery();;
	
			while (resultat.next()) {
				Integer id_plat = resultat.getInt("id");
				String nom_plat	 = resultat.getString("nom_plat");
				Float prix = resultat.getFloat("prix");
				String image = resultat.getString("image");
				String statut	 = resultat.getString("statut");
				
				Commande carte = new Commande();
		
				carte.setId_plat(id_plat);
				carte.setNom_plat(nom_plat);  
				carte.setPrix(prix);
				carte.setImage(image);
				carte.setStatut(statut);
				
				plats.add(carte);
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	return plats;
	
	}
	
	
	public void valider(Integer id) {
		acceAlabase();
		
		try {
			 String sql = "UPDATE `carte_commande` SET `statut` = 'Validé' WHERE `carte_commande`.`id` = ?;";
			
			 preparedStatement = con.prepareStatement(sql);
			 preparedStatement.setInt(1, id);
			
			 preparedStatement.executeUpdate();
		} catch (Exception e) {
			  e.printStackTrace();
			   throw new RuntimeException("Erreur lors de la validation de la commande.", e);

		}
		
	}
	
	

}
