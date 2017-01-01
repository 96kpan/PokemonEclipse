package tiles;

import java.awt.image.BufferedImage;

import model.PokemonGame;
import model.Trainer;

public class TrainerTile extends Tile {

	public TrainerTile(BufferedImage tileImage) {
		super(tileImage);
	}

	@Override
	public void playerIsOnTile(Trainer t) {
		// TODO Auto-generated method stub

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return " [T] ";
	}

}
