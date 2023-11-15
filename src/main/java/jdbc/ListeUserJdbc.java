package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.Utilisateur;


public class ListeUserJdbc {
	
	Connection con = null;
	Statement stmt = null;
	ResultSet resultat = null;

	
	public void acceAlabase() {
		DatabaseConnectionManager dbManager = DatabaseConnectionManager.getInstance();
        con = dbManager.getConnection();
	}
	
	
	public List<Utilisateur> lister(){
		List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
		
		acceAlabase();
		try {	
			stmt = con.createStatement();
			resultat = stmt.executeQuery("SELECT * FROM `utilisateurs`;");
			
			while (resultat.next()) {
				int id = resultat.getInt("id_user");
				String nom = resultat.getString("nom");
				String prenom = resultat.getString("prenom");
				String email = resultat.getString("email");
				String profil = resultat.getString("profil");
				String telephone = resultat.getString("telephone");
				
				Utilisateur personne = new Utilisateur();
		
				personne.setId_user(id);
				personne.setEmail(email);
				personne.setNom(nom);
				personne.setPrenom(prenom);
				personne.setProfil(profil);
				personne.setTelephone(telephone);
				
				utilisateurs.add(personne);
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	return utilisateurs;
}
	

}
