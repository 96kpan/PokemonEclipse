package model;

import java.awt.Image;
import java.io.Serializable;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import item.Cookies;
import item.Item;
import item.Pokeball;
import item.SuperCookies;
import pokemons.Pokemon;

public class PokemonGame extends JFrame implements Serializable {

	public static void main(String[] args) {
		PokemonGame gameWindow = new PokemonGame();
		gameWindow.setVisible(true);
	}

	private Trainer trainer;
	private boolean isBattling;

	public PokemonGame() {
		isBattling = false;
		trainer = new Trainer();
		trainer.setTrainerName(JOptionPane.showInputDialog(this, "Hey there buddy, I'd like to know your name."));
		String[] starters = { "Squirtle", "Charmander", "Bulbasaur", "PEEKACHU;)"};
		int starterPokeNum = JOptionPane.showOptionDialog(null, "I found some Pokemon and I'd like to share. Choose one! Go ahead!",
				"Choose your starter",JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, starters, starters[0]);
		
		trainer.getMyBag();//.addPokemon(change to actual individual pokemon class later)
		
		
	}

	public Item acquireItem() {
		Random rand = new Random();
		int randomNum = rand.nextInt(100) + 1;

		if (randomNum < 25) {
			return new Cookies("Cookies");
		} else if (randomNum < 35) {
			return new SuperCookies("SuperCookies");
		} else {
			return new Pokeball("Pokeball");
		}

	}

	public void launchBattle() {
		isBattling = true; // will need to make separate window for battles.

	}
}
