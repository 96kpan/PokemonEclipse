package pokemons;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;

public class Bulbasaur extends Pokemon implements Serializable {
	
	static int thisLevel = (int) (Math.random() * 10);
	static int thisHealth = (int) (Math.random() * 200)+100;
	static int thisRunProbs = (int) (Math.random() * 50);
	static transient BufferedImage thisPic = null; //NIVEN INSERT IMAGE HERE
	
	public Bulbasaur(){
		this(thisLevel, thisHealth, "Bulbasaur", "Grass", false, thisRunProbs, insertImage());
	}

	public Bulbasaur(int level, int totalHealth, String pokemonName, String pokemonType, boolean capturedOrNot,
			int runProbs, Image pokemonPic) {
		super(level, totalHealth, pokemonName, pokemonType, capturedOrNot, runProbs, pokemonPic);
	}
	
	public String toString() {
		return "Bulbasaur HP: " + this.thisHealth;
	}

	private static BufferedImage insertImage() {
		try {
			thisPic = ImageIO.read(new File("images" + File.separator + "pokemon.png"));
		} catch (IOException e) {
			System.out.println("Can't find image");
		}
		return thisPic.getSubimage(0, 1*32 , 32, 32);
	}

}
