package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bean.Carte;
import bean.Utilisateur;

public class ModifierProduitJdbc {
	
	Connection con = null;
	Statement stmt = null;
	ResultSet resultat = null;
    PreparedStatement preparedStatement = null;




	private void acceAlabase() {
		DatabaseConnectionManager dbManager = DatabaseConnectionManager.getInstance();
        con = dbManager.getConnection();		
	}


	public Carte produit_a_mod(Integer id) {
		Carte plat = new Carte();
		acceAlabase();
	    String sql = "SELECT * FROM `carte` WHERE `id_plat` = ?";
	   
	    try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
	        preparedStatement.setInt(1, id);

	        ResultSet resultSet = preparedStatement.executeQuery();
	        if (resultSet.next()) {
	        	String nom_plat = resultSet.getString("nom_plat");
	        	String description = resultSet.getString("description");
	        	Float prix = resultSet.getFloat("prix");
	        	Boolean disponibilité = resultSet.getBoolean("disponibilite");
	        	String image = resultSet.getString("image");
	        	
	        	plat.setId_plat(id);
	        	plat.setNom_plat(nom_plat);
	        	plat.setPrix(prix);
	        	plat.setDescription(description);
	        	plat.setDisponibilité(disponibilité);
	        	plat.setImage(image);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

		return plat;
	}


	public void updateProduit(Carte bean) {
		acceAlabase();
		
		try {
			 String sql = "UPDATE `carte` SET `nom_plat`=?,`description`=?,`prix`=?, `disponibilite`=?, `image`=? WHERE id_plat = ?";
			
			 preparedStatement = con.prepareStatement(sql);
			 preparedStatement.setString(1, bean.getNom_plat());
			 preparedStatement.setString(2, bean.getDescription());
			 preparedStatement.setFloat(3, bean.getPrix());
			 preparedStatement.setBoolean(4, bean.getDisponibilité());
			 preparedStatement.setString(5, bean.getImage());
			 preparedStatement.setInt(6, bean.getId_plat());
			
			 preparedStatement.executeUpdate();
		} catch (Exception e) {
			  e.printStackTrace();
			   throw new RuntimeException("Erreur lors de la mise à jour de la carte.", e);

		}
		
	}
	

}
