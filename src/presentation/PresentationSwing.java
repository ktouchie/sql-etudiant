package presentation;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PresentationSwing extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2263738995207462212L;

	// Components
	private JLabel lNom = new JLabel("Nom:");
	private JTextField nom = new JTextField(12);
	private JLabel lPrenom = new JLabel("Prenom:");
	private JTextField prenom = new JTextField(12);
	private JLabel lAge = new JLabel("Age:");
	private JTextField age = new JTextField(4);
	private JButton jb1 = new JButton("Valider");

	// Constructor
	public PresentationSwing() {
		this.setLayout(new BorderLayout());

		// First line
		JPanel row1 = new JPanel();
		row1.setLayout(new FlowLayout());
		row1.add(lNom);
		row1.add(nom);
		row1.add(lPrenom);
		row1.add(prenom);
		row1.add(lAge);
		row1.add(age);

		// ajout 1ere JPanel à la fenetre
		this.add(row1, BorderLayout.NORTH);

		// 2nd line
		JPanel row2 = new JPanel();
		row2.add(jb1);

		// ajout 2eme JPanel à ma fenetre
		this.add(row2, BorderLayout.CENTER);

		// make visible
		this.setBounds(10, 10, 500, 500);
		this.setVisible(true);
	}

	public static void main(String[] args) {

		PresentationSwing f = new PresentationSwing();
		f.setVisible(true);

	}

}
