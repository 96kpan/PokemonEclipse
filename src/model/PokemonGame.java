package model;

import java.util.Random;

import item.*;
import item.Item;

public class PokemonGame {
	
	private Trainer trainer;
	private boolean isBattling;
	
	public PokemonGame(){
		isBattling = false;
	}

	public Item acquireItem() {
		Random rand = new Random();
		int randomNum = rand.nextInt(100) + 1;
		
		if((int) randomNum < 25){
			return new Cookies("Cookies");
		} else if((int) randomNum < 35){
			return new SuperCookies("SuperCookies");
		} else {
			return new Pokeball("Pokeball");
		}
		
	}

	public void launchBattle() {
		isBattling = true; //will need to make seperate window for battles.
	}

	
	
	

}
