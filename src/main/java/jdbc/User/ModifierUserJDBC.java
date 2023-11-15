package jdbc.User;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;

import com.mysql.cj.protocol.x.ReusableOutputStream;

import bean.Utilisateur;
import jdbc.DatabaseConnectionManager;

public class ModifierUserJDBC {
	
	Connection con = null;
	Statement stmt = null;
	ResultSet resultat = null;
    PreparedStatement preparedStatement = null;




	private void acceAlabase() {
		DatabaseConnectionManager dbManager = DatabaseConnectionManager.getInstance();
        con = dbManager.getConnection();		
	}


	public Utilisateur personne_a_modifier(Integer id) {
		Utilisateur user = new Utilisateur();
		acceAlabase();
	    String sql = "SELECT * FROM `utilisateurs` WHERE `id_user` = ?";
	   
	    try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
	        preparedStatement.setInt(1, id);

	        ResultSet resultSet = preparedStatement.executeQuery();
	        if (resultSet.next()) {
	        	String nom = resultSet.getString("nom");
	        	String prenom = resultSet.getString("prenom");
	        	String email = resultSet.getString("email");
	        	String telephone = resultSet.getString("telephone");
	        	String password = resultSet.getString("password");
	        	String profil = resultSet.getString("profil");
	        	
	        	user.setId_user(id);
	        	user.setNom(nom);
	        	user.setPrenom(prenom);
	        	user.setEmail(email);
	        	user.setProfil(profil);
	        	user.setTelephone(telephone);
	        	user.setPassword(password);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

		return user;
	}


	public void update(Utilisateur bean) {
		acceAlabase();
		
		try {
			 String sql = "UPDATE `utilisateurs` SET `nom`=?,`prenom`=?,`telephone`=?,`email`=?,"
			 		+ "`profil`=?, `password`=? WHERE `id_user`=?";
			
			 preparedStatement = con.prepareStatement(sql);
			 preparedStatement.setString(1, bean.getNom());
			 preparedStatement.setString(2, bean.getPrenom());
			 preparedStatement.setString(3, bean.getTelephone());
			 preparedStatement.setString(4, bean.getEmail());
			 preparedStatement.setString(5, bean.getProfil());
			 preparedStatement.setString(6, bean.getPassword());
			 preparedStatement.setInt(7, bean.getId_user());
			
			int count = preparedStatement.executeUpdate();
			 
		} catch (Exception e) {
			
		}
		
	}
	
	
	
	

}
