package com.mathmaurer.jeu;

import javax.swing.JFrame;

public class Main {

	//création de la variable scéne
	public static Scene scene;
	
	public static void main(String[] args) {
		// TODO Stub de la méthode généré automatiquement
		
		 
		
		// création de la fenetre du jeu 
		JFrame fenetre = new JFrame("Jeu Mario");
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setSize(700,360);
		fenetre.setLocationRelativeTo(null);
		fenetre.setResizable(false);
		fenetre.setAlwaysOnTop(true);
		
		//initialisation de l'objet scene
		scene = new Scene();
		
		fenetre.setContentPane(scene); // association de la fenetre d'application à la scene 
		fenetre.setVisible(true); // rendre la fenetre visible 

	}

}
