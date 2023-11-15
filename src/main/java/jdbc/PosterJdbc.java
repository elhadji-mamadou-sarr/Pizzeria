package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Carte;
import bean.Utilisateur;

public class PosterJdbc {
	
	Connection con = null;
	ResultSet resultat = null;
    PreparedStatement preparedStatement = null;
	
    private void acceAlabase() {
		DatabaseConnectionManager dbManager = DatabaseConnectionManager.getInstance();
        con = dbManager.getConnection();		
	}
	
	public void Poster(Carte plat) {

		acceAlabase();
		try {
			 String sql = "INSERT INTO `carte`(`nom_plat`, `description`, `prix`, `disponibilite`, `image`)"
			 		+ " VALUES(?, ?, ?, ?, ?)";
			 preparedStatement = con.prepareStatement(sql);
			 
			 preparedStatement.setString(1, plat.getNom_plat());
			 preparedStatement.setString(2, plat.getDescription());
			 preparedStatement.setFloat(3, plat.getPrix());
			 preparedStatement.setBoolean(4, plat.getDisponibilité());
			 preparedStatement.setString(5, plat.getImage());
			 
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


}
