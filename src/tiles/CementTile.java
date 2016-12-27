package tiles;

import java.awt.image.BufferedImage;
import java.io.Serializable;

import model.PokemonGame;

public class CementTile extends Tile implements Serializable{

	public CementTile(BufferedImage tileImage) {
		super(tileImage);
	}

	@Override
	public void playerIsOnTile(PokemonGame game) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "c";
	}

}
