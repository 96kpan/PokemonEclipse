package model;

import javax.swing.JPanel;

import pokemons.Pokemon;

public class Battle extends JPanel {
	private final static int WINDOW_SIZE = 384;
	
	public Battle() {
		this.setSize(WINDOW_SIZE, WINDOW_SIZE);
		this.setLocation(0, 0);
	}
	public Battle(Pokemon opponent) {
		
	}
}
