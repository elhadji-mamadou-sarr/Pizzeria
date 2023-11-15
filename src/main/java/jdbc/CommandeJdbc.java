package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.CarteCommande;

public class CommandeJdbc {
	
	Connection con = null;
	ResultSet resultat = null;
    PreparedStatement preparedStatement = null;
	
    private void acceAlabase() {
		DatabaseConnectionManager dbManager = DatabaseConnectionManager.getInstance();
        con = dbManager.getConnection();		
	}
	
	public void commander(CarteCommande plat) {

		acceAlabase();
		try {
			
			String carte = "SELECT * FROM `carte` WHERE `id_plat` = ?";
			
			PreparedStatement pstmt = con.prepareStatement(carte);
			pstmt.setInt(1, plat.getId_plat());
			Float prix = null;
			ResultSet resultSet = pstmt.executeQuery();
	        if (resultSet.next()) {;
	        	prix = resultSet.getFloat("prix");
	        	String nom = resultSet.getString("nom_plat");
	        }
	        
			 String sql = "INSERT INTO `carte_commande`(`id_user`, `id_plat`, `prix_total`, `statut`)"
			 		+ " VALUES(?, ?, ?, ?)";
			 preparedStatement = con.prepareStatement(sql);
			 
			 preparedStatement.setInt(1, plat.getId_user());
			 preparedStatement.setInt(2, plat.getId_plat());
			 preparedStatement.setFloat(3, prix);
			 preparedStatement.setString(4, "En attente");
			 
			 preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException e) {	
				e.printStackTrace();
			}
		}
		
	}

	public void deleteCommande(String id_commande) {
		acceAlabase();
		try {
			String sql = "DELETE FROM `carte_commande` WHERE id = ?";
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, id_commande);
			
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
