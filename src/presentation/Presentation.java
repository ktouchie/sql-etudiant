package presentation;

import java.util.ArrayList;
import java.util.List;

import dao.Scolarite;
import metier.Etudiant;

public class Presentation {

	public static void main(String[] args) {

		Scolarite metier = new Scolarite();
		// Etudiant e1 = new Etudiant("Simpson", "Homer", 38);

		// metier.modifierEtudiant(6, "Flintstone", "Fred");

		/*
		 * List<Etudiant> l = new ArrayList<Etudiant>(); l =
		 * metier.listerEtudiants(); for (int i = 0; i < l.size(); i++) {
		 * System.out.println(l.get(i)); }
		 */

		List<Etudiant> l = new ArrayList<Etudiant>();
		l = metier.chercherEtudiants("son");
		for (int i = 0; i < l.size(); i++) {
			System.out.println(l.get(i));
		}

	}

}
