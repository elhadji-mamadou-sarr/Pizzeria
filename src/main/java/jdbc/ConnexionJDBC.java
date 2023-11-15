package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnexionJDBC {
	Connection con = null;
	Statement stmt = null;
	ResultSet resultat = null;
	PreparedStatement preparedStatement = null;
	
	
	 private String status;
	    private String userId;
	    private String name;

	    public  ConnexionJDBC() {
	    }
	    
	    public  ConnexionJDBC(String status, String userId, String name) {
	        this.status = status;
	        this.userId = userId;
	        this.name = name;
	    }

	    // Getters
	    public String getStatus() {
	        return status;
	    }

	    public String getUserId() {
	        return userId;
	    }
	    
	   
	
	public String getName() {
			return name;
		}


	public ConnexionJDBC authentification(String email, String password) {
		ConnexionJDBC authentifie = null;
	    
	    DatabaseConnectionManager dbManager = DatabaseConnectionManager.getInstance();
        con = dbManager.getConnection();
	    
	    try {
	    	String profil = null ;
	    	String id = null;
	    	String nameUser = null;
	    	String sql = "SELECT * FROM `utilisateurs` WHERE email = ? AND password = ?";
	    	preparedStatement = con.prepareStatement(sql);
	        preparedStatement.setString(1, email);
	        preparedStatement.setString(2, password);
	        resultat = preparedStatement.executeQuery();
	        if (resultat.next()) {
	            profil = resultat.getString("profil");
	            id = resultat.getString("id_user");
	            nameUser = resultat.getString("nom");
	        }
	       
	    	String query = "SELECT * FROM `utilisateurs` WHERE email = ? AND password = ? AND profil = ?";
	        
	        preparedStatement = con.prepareStatement(query);
	        preparedStatement.setString(1, email);
	        preparedStatement.setString(2, password);
	        preparedStatement.setString(3, profil);
	        
	        resultat = preparedStatement.executeQuery();
	        
	        if (resultat.next()) {
	        	profil = resultat.getString("profil");
	        	if ("admin".equals(profil)) {
	        	    authentifie = new ConnexionJDBC("admin", id, nameUser);
	        	} else if ("client".equals(profil)) {
	        	    authentifie = new ConnexionJDBC("client", id, nameUser);
	        	}         
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    
	    }
	    
	    return authentifie;
	}

	


}
