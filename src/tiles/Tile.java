package tiles;

import java.awt.image.BufferedImage;
import java.io.Serializable;

import model.PokemonGame;
import model.Trainer;

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
	
	public BufferedImage getImage() {
		return this.tileImage;
	}
	
	public abstract void playerIsOnTile(Trainer trainer);
	
	public abstract String toString();
	
}
	

