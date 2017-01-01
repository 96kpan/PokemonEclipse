package tiles;

import java.awt.image.BufferedImage;
import java.io.Serializable;

import model.PokemonGame;
import model.Trainer;

public class SmallTreeTile extends Tile implements Serializable{
	

	public SmallTreeTile(BufferedImage tileImage) {
		super(tileImage);
		super.canMove = false;
	}


	@Override
	public void playerIsOnTile(Trainer t) {
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return " [t] ";
	}
	

}
