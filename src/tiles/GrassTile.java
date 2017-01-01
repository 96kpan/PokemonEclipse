package tiles;

import java.awt.image.BufferedImage;
import java.io.Serializable;

import model.PokemonGame;
import model.Trainer;

public class GrassTile extends Tile implements Serializable{

	public GrassTile(BufferedImage tileImage) {
		super(tileImage);
		super.canMove = true;
	}

	@Override
	public void playerIsOnTile(Trainer t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return " [g] ";
	}

}
