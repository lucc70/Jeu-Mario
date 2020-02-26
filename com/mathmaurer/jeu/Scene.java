package com.mathmaurer.jeu;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Scene extends JPanel {
	
	//pour stocker l'image du fond 
	private ImageIcon icoFond;
	private Image imgFond1;  
	private Image imgFond2; // création de l'image 2 pour créé la boucle 
	
	// stocker l'image de mario 
	private ImageIcon icoMario; // code provisoire
	private Image imgMario; // code provisoire 
	
	// craetion de la varible pour la taille du fond 
	private int xFond1; 
	private int xFond2; // position de l'image2
	
	private int dx; // variable pour deplacement de l'ecran
	
	
	
	// CONSTRUCTEUR de l'objet scene
	public Scene() {
		
		super();
	// initialisation des variables
	this.xFond1=-50; // taille du fond dans la fenetre
	this.xFond2= 750; // taille de fond 2 a la suite de fond 1 (Imgae 800 de large - 50 de fond 1 donc 750)
	this.dx = 0; // valeur que prendra l'action à soustraire a l'affichage
	icoFond = new ImageIcon(getClass().getResource("/images/fondEcran.png")); // "src/images/fondEcran.png"
	this.imgFond1 = this.icoFond.getImage(); // associer img fond à ico fond
	this.imgFond2 = this.icoFond.getImage(); // associer img fond à ico fond
	icoMario = new ImageIcon(getClass().getResource("/images/marioMarcheDroite.png")); // "src/images/fondEcran.png"
	this.imgMario = this.icoMario.getImage(); // associer img mario à ico mario
	
	this.setFocusable(true); // premiere condition pour recupérer le listerner clavier
	this.requestFocusInWindow(); // deuxieme condition pour recupérer le listener clavier
	this.addKeyListener(new Clavier()); // relie la classe clavier à la class scene grace à addKeyListener
	
	Thread chronoEcran = new Thread(new Chrono()); // 2) Instance de notre chrono grace à thread
	chronoEcran.start(); // touneras en fond en permamnance 
	}
	
	//*****METHODE*******
	
	//Methodes GET ET SET
	
	public void setDx(int dx) {this.dx = dx;}
	public int getDx() {return dx;}
	
	// création de la methode du changeemnt de fond

	public void deplacementFond () {
		
//		this.xFond1 = this.xFond1 - this.dx; // deplacement dans le sens contraire de mario
//		this.xFond1 = this.xFond1 - this.dx; // deplacement dans le sens contraire de mario
		//this.xFond2 = this.xFond2 - this.dx;// déplacer fond 2 en meme temps que fond 1 
		System.out.println("ok");
	}
	
	// création de la methode d'affichage 


	public void paintComponent(Graphics g) {
		
		
		super.paintComponent(g);
		// amélioration du rendu graphic avec la classe Graphic 2D
		Graphics g2 = (Graphics2D)g;
		
		this.deplacementFond();
		
		g2.drawImage(this.imgFond1, this.xFond1, 0, null); //Dessin de l'image de fond avec la fonction drawImage (ingFond1 = img qu'on va dessiner, en posiiton xFond, observable = null)
		g2.drawImage(this.imgFond2, this.xFond2, 0, null); 
		g2.drawImage(imgMario, 300, 245, null); //Dessin de l'image de mario avec la fonction drawImage (ce qu'on dessine = imgMario, position horizontal= 300, vertical=245, observable=0
	}

}
