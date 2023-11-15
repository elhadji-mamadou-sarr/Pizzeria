package jdbc.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Utilisateur;
import jdbc.DatabaseConnectionManager;

public class InsererJDBC {
	
	Connection con = null;
	ResultSet resultat = null;
    PreparedStatement preparedStatement = null;
	
	
	public void inserer(Utilisateur user) {

		acceAlabase();
		try {
			 String sql = "INSERT INTO `utilisateurs`(`nom`, `prenom`, `telephone`, `email`, `password`, `profil`)"
			 		+ " VALUES(?, ?, ?, ?, ?, ?)";
			 preparedStatement = con.prepareStatement(sql);
			 
			 preparedStatement.setString(1, user.getNom());
			 preparedStatement.setString(2, user.getPrenom());
			 preparedStatement.setString(3, user.getTelephone());
			 preparedStatement.setString(4, user.getEmail());
			 preparedStatement.setString(5, user.getPassword());
			 preparedStatement.setString(6, user.getProfil());
			 
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




	public boolean emailExiste(String email) {
		acceAlabase();
	    String sql = "SELECT email FROM `utilisateurs` WHERE `email` = ?";
	    
	    boolean emailTrouve = false;

	    try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
	        preparedStatement.setString(1, email);

	        ResultSet resultSet = preparedStatement.executeQuery();
	        if (resultSet.next()) {
	            emailTrouve = true; 
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return emailTrouve;
	}


	private void acceAlabase() {
		DatabaseConnectionManager dbManager = DatabaseConnectionManager.getInstance();
        con = dbManager.getConnection();		
	}

}
