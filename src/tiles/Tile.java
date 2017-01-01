package tiles;

import java.awt.image.BufferedImage;
import java.io.Serializable;

import model.controller;

public abstract class Tile implements Serializable {
	private transient BufferedImage tileImage;
	private boolean hasTrainer;
	private boolean hasPokemon;
	protected boolean canMove;
	public Tile(BufferedImage tileImage) {
		this.tileImage = tileImage;
		this.hasTrainer = false;
		this.hasPokemon = false;
		canMove = true;
	}
	
	public boolean canMove() {
		return this.canMove;
	}
	
	public boolean getHasTrainer() {
		return hasTrainer;
	}
	
	public boolean getHasPokemon() {
		return false;
	}
	
	public void setHasTrainer(boolean hasHunter) {
		this.hasTrainer = hasHunter;
	}
	
<<<<<<< HEAD
	public BufferedImage getImage() {
		return this.tileImage;
	}
	public abstract void playerIsOnTile(PokemonGame game);
=======
	public abstract void playerIsOnTile(controller game);
>>>>>>> 07eb9c5b9905ee67a67c5cc5a242484dd5ada992
	
	public abstract String toString();
	
}
	

