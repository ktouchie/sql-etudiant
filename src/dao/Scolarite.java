package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import metier.Etudiant;

public class Scolarite {

	public void ajouterEtudiant(Etudiant e) {
		try {
			// chargement du pilote
			Class.forName("com.mysql.jdbc.Driver");

			// connexion à la base de données
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/etudiants", "root", "");

			// création de la requête
			PreparedStatement ps = conn.prepareStatement("insert into etudiant(nom,prenom,age) " + "VALUES('"
					+ e.getNom() + "','" + e.getPrenom() + "','" + e.getAge() + "')");

			// execution de la requête
			ps.executeUpdate();
		}

		catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	public void supprimerEtudiant(int id) {
		try {
			// chargement du pilote
			Class.forName("com.mysql.jdbc.Driver");

			// connexion à la base de données
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/etudiants", "root", "");

			// création de la requête
			PreparedStatement ps = conn.prepareStatement("DELETE FROM etudiant WHERE id=" + id);

			// execution de la requête
			ps.executeUpdate();
		}

		catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	public void modifierEtudiant(int id, String nom, String prenom) {
		try {
			// chargement du pilote
			Class.forName("com.mysql.jdbc.Driver");

			// connexion à la base de données
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/etudiants", "root", "");

			// création de la requête
			PreparedStatement ps = conn
					.prepareStatement("UPDATE etudiant SET nom='" + nom + "', prenom='" + prenom + "' WHERE id=" + id);

			// execution de la requête
			ps.executeUpdate();
		}

		catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	public List<Etudiant> listerEtudiants() {
		List<Etudiant> etds = new ArrayList<Etudiant>();
		try {
			// chargement du pilote
			Class.forName("com.mysql.jdbc.Driver");

			// connexion à la base de données
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/etudiants", "root", "");

			// création de la requête
			PreparedStatement ps = conn.prepareStatement("select * from etudiant");

			// execution de la requête
			ResultSet rs = ps.executeQuery();

			// récuperation des résultats
			while (rs.next()) {
				Etudiant et = new Etudiant();
				et.setId(rs.getInt("id"));
				et.setNom(rs.getString("nom"));
				et.setPrenom(rs.getString("prenom"));
				et.setAge(rs.getInt("age"));

				etds.add(et);
			}
		}

		catch (Exception e1) {
			e1.printStackTrace();
		}
		return etds;
	}

	public List<Etudiant> chercherEtudiants(String mc) {
		List<Etudiant> result = new ArrayList<Etudiant>();
		try {
			// chargement du pilote
			Class.forName("com.mysql.jdbc.Driver");

			// connexion à la base de données
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/etudiants", "root", "");

			// création de la requête
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM etudiant WHERE nom LIKE ?");
			ps.setString(1, "%" + mc + "%");

			// execution de la requête
			ResultSet rs = ps.executeQuery();

			// récuperation des résultats
			while (rs.next()) {
				Etudiant et = new Etudiant();
				et.setId(rs.getInt("id"));
				et.setNom(rs.getString("nom"));
				et.setPrenom(rs.getString("prenom"));
				et.setAge(rs.getInt("age"));

				result.add(et);
			}
		}

		catch (Exception e1) {
			e1.printStackTrace();
		}
		return result;
	}
}
