package tiles;

import java.awt.image.BufferedImage;
import java.io.Serializable;

import model.PokemonGame;

public class TrainerTile extends Tile implements Serializable{

	public TrainerTile(BufferedImage tileImage) {
		super(tileImage);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void playerIsOnTile(PokemonGame game) {
		// TODO Auto-generated method stub

	}

	@Override
	public String toString() {
		return " [TRAINERRR] ";
	}

}
