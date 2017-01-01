package item;

import java.util.ArrayList;
import java.util.HashMap;

import pokemons.Pokemon;


public class Bag {
	
	HashMap <String, Integer> myBag;
	ArrayList<Pokemon> party;
	
	public Bag(){
		myBag = new HashMap();
		party = new ArrayList<Pokemon>();
		//init categories
//		1. Pokeballs
//		2. Cookies -> restore the pokemon's HP level by 15 HPs
//		3. SuperCookies -> restore the pokemon's HP level fully
		
		myBag.put("Pokeball", 30);
		myBag.put("Cookies", 5);
		myBag.put("SuperCookies", 5);
		
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
		party.add(p);
	}
	
	public HashMap getMyBag(){
		return this.myBag;
	}
	
	public ArrayList getMyPokeDex(){
		return this.party;
	}
	
	public String toString(){
		StringBuilder str = new StringBuilder();
		for(String s : myBag.keySet()){
			str.append(s + " " + myBag.get(s) + " ");
		}
		
		return str.toString();
	}

}
