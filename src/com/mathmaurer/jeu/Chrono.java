package com.mathmaurer.jeu;

public class Chrono implements Runnable{

	private final int PAUSE = 3; // temps de pause entre 2 tour de boucle avant de repindre l'écran 
	
	@Override
	public void run() {
		
		while(true) {
			Main.scene.repaint(); // passer par classe main pour accéder par la methode scene
			try {
				Thread.sleep(PAUSE);
			} catch (InterruptedException e) {}// tour de boucle toute les 3000ms = 25 img/s
			
		}
		
	}
	

}
