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
	private Image imgFond2;
	private ImageIcon icoDepart;
	private Image imgDepart;
	private ImageIcon icoChateau1;
	private Image imgChateau1;
	
	
	// stocker l'image de mario 
	private ImageIcon icoMario; // code provisoire
	private Image imgMario; // code provisoire 
	
	
	
	// craetion de la varible pour la taille du fond 
	private int xFond1; 
	private int xFond2;
	private int xPos; // position des �l�ment du jeu 
	private int dx; // variable pour deplacement de l'ecran
	
	
	// CONSTRUCTEUR de l'objet scene
	public Scene() {
		
		super();
	
	this.xFond1=-50;// taille du fond dans la fenetre
	this.xFond2 = 750; // taille de fond 2 = fond 1 -50 - taille fenetre 800
	this.dx = 0; // valeur que prendra l'action � soustraire a l'affichage
	this.xPos = -1; // initialisation de xPos � -1
	
	icoFond = new ImageIcon(getClass().getResource("/images/fondEcran.png")); // "src/images/fondEcran.png"
	this.imgFond1 = this.icoFond.getImage(); // associer img fond � ico fond
	this.imgFond2 = this.icoFond.getImage(); // associer img fond � ico fond
	
	icoMario = new ImageIcon(getClass().getResource("/images/marioMarcheDroite.png")); // "src/images/fondEcran.png"
	this.imgMario = this.icoMario.getImage(); // associer img mario � ico mario
	
	
	icoDepart = new ImageIcon(getClass().getResource("/images/depart.png"));
	this.imgDepart = this.icoDepart.getImage();
	
	icoChateau1 = new ImageIcon(getClass().getResource("/images/chateau1.png"));
	this.imgChateau1 = this.icoChateau1.getImage();
	
	
	this.setFocusable(true); // premiere condition pour recup�rer le listerner clavier
	this.requestFocusInWindow(); // deuxieme condition pour recup�rer le listener clavier
	this.addKeyListener(new Clavier()); // relie la classe clavier � la class scene grace � addKeyListener
	
	Thread chronoEcran = new Thread(new Chrono()); // 2) Instance de notre chrono grace � thread
	chronoEcran.start(); // touneras en fond en permamnance 
	}
	
	//*****METHODE*******
	
	//Methodes GET ET SET
	
	public int getxPos() {return xPos;}
	public void setxPos(int xPos) {this.xPos = xPos;}

	public void setDx(int dx) {this.dx = dx;}
	public int getDx() {return dx;}
	
	public void setxFond1(int i) {}
	public void setxFond2(int i) {}
	
	// cr�ation de la methode du changeemnt de fond

	public void deplacementFond () {
		
		if (this.xPos>= 0) {
			this.xPos = this.xPos + this.dx;
			
			this.xFond1 = this.xFond1 - this.dx; // deplacement dans le sens contraire de mario
			this.xFond2 = this.xFond2 - this.dx;// deplacement dans le sens contraire de mario pour l'image fond 2

		} 
		
				
		if (this.xFond1 == -800) { // pour remettre le fond � 0 et que les image se remmette a l'affichage
			this.xFond1 = 800;
		} else if (this.xFond2 == -800){
			this.xFond2 = 800;
		} else if (this.xFond1 == 800) {
			this.xFond1=-800;
		} else if (this.xFond2 == 800) {
			this.xFond2 = -800;
		}
	}
	
	// cr�ation de la methode d'affichage 


	public void paintComponent(Graphics g) {
		
		
		super.paintComponent(g);
		// am�lioration du rendu graphic avec la classe Graphic 2D
		Graphics g2 = (Graphics2D)g;
		
		this.deplacementFond();
		
		
		g2.drawImage(this.imgFond1, this.xFond1, 0, null); //Dessin de l'image de fond avec la fonction drawImage (ingFond1 = img qu'on va dessiner, en posiiton xFond, observable = null)
		g2.drawImage(this.imgFond2, this.xFond2, 0, null); //Dessin de l'image de fond avec la fonction drawImage (ingFond1 = img qu'on va dessiner, en posiiton xFond, observable = null)
		
		g2.drawImage(imgChateau1, 10 - this.xPos, 95, null);
		g2.drawImage(imgDepart, 220 - this.xPos, 234, null);
		
		g2.drawImage(imgMario, 300, 245, null); //Dessin de l'image de mario avec la fonction drawImage (ce qu'on dessine = imgMario, position horizontal= 300, vertical=245, observable=0
		
	}

}
