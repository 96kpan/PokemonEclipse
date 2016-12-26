package item;

import java.util.ArrayList;
import java.util.HashMap;

import model.Pokemon;


public class Bag {
	
	HashMap <String, Integer> myBag;
	ArrayList<Pokemon> pokeDex;
	
	public Bag(){
		myBag = new HashMap();
		
		//init categories
//		1. Pokeballs
//		2. Cookies -> restore the pokemon's HP level by 15 HPs
//		3. SuperCookies -> restore the pokemon's HP level fully
		
		myBag.put("Pokeballs", 30);
		myBag.put("Cookies", 0);
		myBag.put("SuperCookies", 0);
		
	}
	
	public void addItemToBag(String name){
		int temp = myBag.get(name);
		myBag.put(name, temp + 1);
	}
	
	public void removeItemToBag(String name, int num){
		int temp = myBag.get(name);
		myBag.put(name, temp - num);
	}
	
	public void addPokemon(Pokemon p){
		pokeDex.add(p);
	}
	
	public HashMap getMyBag(){
		return this.myBag;
	}
	
	public ArrayList getMyPokeDex(){
		return this.pokeDex;
	}

}
