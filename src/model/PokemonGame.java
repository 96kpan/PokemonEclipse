package model;

import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.Serializable;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import item.Cookies;
import item.Item;
import item.Pokeball;
import item.SuperCookies;
import pokemons.Bulbasaur;
import pokemons.Charmander;
import pokemons.Pikachu;
import pokemons.Pokemon;
import pokemons.Squirtle;

public class PokemonGame extends JFrame implements Serializable {

	public static void main(String[] args) {
		PokemonGame gameWindow = new PokemonGame();
		gameWindow.setVisible(true);
	}

	private Trainer trainer;
	private boolean isBattling;
	private boolean isPaused;
	private JPanel pauseMenu;

	public PokemonGame() {
		isBattling = false;
		isPaused = false;
		pauseMenu = new JPanel(new GridLayout(6,1));
		pauseMenu.setSize(150, 368);
		pauseMenu.setLocation(218, 0);
		pauseMenu.add(new JButton("Pokedex"));
		pauseMenu.add(new JButton("Pokemon"));
		pauseMenu.add(new JButton("Bag"));
		pauseMenu.add(new JButton("Trainer Card"));
		pauseMenu.add(new JButton("Save"));
		pauseMenu.add(new JButton("Options"));
		
		trainer = new Trainer();
		trainer.setTrainerName(JOptionPane.showInputDialog(this, "Hey there buddy, I'd like to know your name."));
		trainer.getMyBag().addPokemon(setStarter());
		this.setSize(368, 368);
		this.setLocation(420, 369);
		this.setLayout(null);
		this.add(new JPanel());// some jpanel to hold game window
		// TODO add keybindings using inputmap and actionmap
	}

	private Pokemon setStarter() {
		String[] starters = { "Squirtle", "Charmander", "Bulbasaur", "PEEKACHU;)" };
		Pokemon starter = null;
		int starterPokeNum = JOptionPane.showOptionDialog(null,
				"I found some Pokemon and I'd like to share. Choose one! Go ahead!", "Choose your starter",
				JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, starters, starters[0]);
		switch (starterPokeNum){
			case 0:
				starter = new Squirtle();
				break;
			case 1:
				starter = new Charmander();
				break;
			case 2:
				starter = new Bulbasaur();
				break;
			case 3:
				starter = new Pikachu();
				break;
		}
		starter.setLevel(5);
		starter.setTotalHealth(20);
		return starter;
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

	private void toggleMenu() {
		if (!isPaused) {
			isPaused = true;
			this.add(pauseMenu);
			
		} else {
			isPaused = false;
			this.remove(pauseMenu);
		}
		
	}

	
}
