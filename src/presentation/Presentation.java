package presentation;

import dao.Scolarite;
import metier.Etudiant;

public class Presentation {

	public static void main(String[] args) {
		
		Scolarite metier = new Scolarite();
		Etudiant e1 = new Etudiant("Simpson", "Homer", 38);
		metier.AjouterEtudiant(e1);

	}

}
