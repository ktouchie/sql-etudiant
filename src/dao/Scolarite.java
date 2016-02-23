package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import metier.Etudiant;

public class Scolarite {
	
	public void AjouterEtudiant (Etudiant e){
		try {
			// chargement du pilote
			Class.forName("com.mysql.jdbc.Driver");
			
			// connexion à la base de données
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/etudiants", "root", "");
			
			// création de la requête
			PreparedStatement ps=conn.prepareStatement
					("insert into etudiant(nom,prenom,age) "
					+ "VALUES('" + e.getNom() + "','" + e.getPrenom() + "','"
					+ e.getAge() + "')");
			
			// execution de la requête
			ps.executeUpdate();
		}
		
		catch (Exception e1) {e1.printStackTrace();}
	}

}
