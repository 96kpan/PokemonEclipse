package tiles;

import java.awt.image.BufferedImage;
import java.io.Serializable;

import model.PokemonGame;

public class SmallTreeTile extends Tile implements Serializable{
	

	public SmallTreeTile(BufferedImage tileImage) {
		super(tileImage);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canMove() {
		return false;
	}

	@Override
	public void playerIsOnTile(PokemonGame game) {
		// TODO Auto-generated method stub
		
	}
	

}