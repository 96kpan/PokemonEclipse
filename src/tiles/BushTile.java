package tiles;

import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.Random;

import javax.swing.JOptionPane;

import model.PokemonGame;
import model.Trainer;

public class BushTile extends Tile implements Serializable{

	public BushTile(BufferedImage tileImage) {
		super(tileImage);
		super.canMove = true;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void playerIsOnTile(Trainer t) {
		Random rand = new Random();
		int  randomNum = rand.nextInt(100);
		if(randomNum < 10) {
			t.launchBattle();
		}
		else if(randomNum >= 10 && randomNum <= 12) {
			t.acquireItem();
			JOptionPane.showMessageDialog(null, "Acquiring Item: " + t.acquireItem().getName());
		}
		
	}
	
	public String toString() {
		return " [b] ";
	}

	

}
