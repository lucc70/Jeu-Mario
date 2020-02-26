package com.mathmaurer.jeu;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Clavier implements KeyListener{

	@Override
	public void keyPressed(KeyEvent e) { // appuie sur la touche 
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) { // quand on appuie sur la fleche droit 
			Main.scene.setDx(1); // dx = 1 et bouge de 1
		}
		
		if (e.getKeyCode() == KeyEvent.VK_LEFT) { // quand on appuie sur la fleche droit 
			Main.scene.setDx(-1); // dx = 1 et bouge de 1
		}
	}

	@Override
	public void keyReleased(KeyEvent e) { // relache la touche
		Main.scene.setDx(0); // dx vaut 0 pour et ne bouge plus 
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	

}
