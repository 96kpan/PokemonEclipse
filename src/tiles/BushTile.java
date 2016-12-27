package tiles;

import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.Random;

import javax.swing.JOptionPane;

import model.PokemonGame;

public class BushTile extends Tile implements Serializable{

	public BushTile(BufferedImage tileImage) {
		super(tileImage);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void playerIsOnTile(PokemonGame game) {
		Random rand = new Random();
		int  randomNum = rand.nextInt(100);
		if(randomNum < 10) {
			game.launchBattle();
		}
		else if(randomNum >= 10 && randomNum <= 15) {
			game.acquireItem();
			JOptionPane.showMessageDialog(null, "Acquiring Item: " + game.getItemAdded());
		}
		
	}
	

}
