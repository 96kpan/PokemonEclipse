package item;

import java.util.ArrayList;
import java.util.HashMap;

import model.Pokedex;
import pokemons.Pokemon;


public class Bag {
	
	HashMap <String, Integer> myBag;
	ArrayList<Pokemon> party;
	Pokedex pokedex;
	
	public Bag(){
		myBag = new HashMap();
		party = new ArrayList<Pokemon>();
		pokedex = new Pokedex();
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
	
		if(party.size() < 6){
			party.add(p); //adds to both if user hasn't reached 6 pokemons
		} 
		pokedex.add(p); //but the minute a user hits 6 pokemons, then we only add to the pokedex
		
	}
	
	public HashMap getMyBag(){
		return this.myBag;
	}
	
	public ArrayList getMyParty(){
		return this.party;
	}
	
	public String toStringBag(){
		StringBuilder str = new StringBuilder();
		str.append("<html>");
		for(String s : myBag.keySet()){
			str.append(s + " " + myBag.get(s) + " </br>");
		}
		str.append("</html>");
		
		return str.toString();
	}
	
	public String toStringParty(){
		StringBuilder str = new StringBuilder();
		str.append("<html>");
		for(int i = 0; i < party.size(); i++){
			str.append(party.get(i) + " </br>");
		}
		str.append("</html>");
		
		return str.toString();
	}
	
	public String[] toStringPokedex(){
		return pokedex.getEntries();
	}

}
