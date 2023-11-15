package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SupprimerProdJdbc {
	
	Connection con = null;
	Statement stmt = null;
	ResultSet resultat = null;
    PreparedStatement preparedStatement = null;




	private void acceAlabase() {
		DatabaseConnectionManager dbManager = DatabaseConnectionManager.getInstance();
        con = dbManager.getConnection();		
	}


	public void deleteProduit(String id_produit) {
		acceAlabase();
		
		try {
			String deleteCommandeSql = "DELETE FROM carte_commande WHERE id_plat = ?";
	        preparedStatement = con.prepareStatement(deleteCommandeSql);
	        preparedStatement.setString(1, id_produit);
	        preparedStatement.executeUpdate();
	        
	        String deleteProduitSql = "DELETE FROM carte WHERE id_plat = ?";
	        preparedStatement = con.prepareStatement(deleteProduitSql);
	        preparedStatement.setString(1, id_produit);
	        preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}



}
