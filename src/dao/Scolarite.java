package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import metier.Etudiant;

public class Scolarite {
	
	public void ajouterEtudiant (Etudiant e){
		try {
			// chargement du pilote
			Class.forName("com.mysql.jdbc.Driver");
			
			// connexion � la base de donn�es
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/etudiants", "root", "");
			
			// cr�ation de la requ�te
			PreparedStatement ps=conn.prepareStatement
					("insert into etudiant(nom,prenom,age) "
					+ "VALUES('" + e.getNom() + "','" + e.getPrenom() + "','"
					+ e.getAge() + "')");
			
			// execution de la requ�te
			ps.executeUpdate();
		}
		
		catch (Exception e1) {e1.printStackTrace();}
	}
	
	public void supprimerEtudiant (int id){
		try {
			// chargement du pilote
			Class.forName("com.mysql.jdbc.Driver");
			
			// connexion � la base de donn�es
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/etudiants", "root", "");
			
			// cr�ation de la requ�te
			PreparedStatement ps=conn.prepareStatement
					("DELETE FROM etudiant WHERE id=" + id);
			
			// execution de la requ�te
			ps.executeUpdate();
		}
		
		catch (Exception e1) {e1.printStackTrace();}
	}

}
