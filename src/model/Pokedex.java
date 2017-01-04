package model;

import pokemons.Pokemon;

public class Pokedex {
	
	private PokeData[] entries;
	public Pokedex() {
		entries = new PokeData[69];
		for (int i = 0; i < entries.length; i++)
			entries[i] =  new PokeData(i, false, "UNKNOWN", "");	
		
	}
	public String[] getEntries() {
		String[] listOfIDsAndNames = new String[entries.length];
		for (int i = 0; i < entries.length; i++)
			listOfIDsAndNames[i] =  String.format("%1$02d",entries[i].id) + " " + entries[i].name;
		return listOfIDsAndNames;
	}
	private class PokeData { // will add images later
		int id;
		boolean seen;
		String name;
		String desc;
		public PokeData(int id, boolean seen, String name, String desc) {
			this.id = id;
			this.seen = seen;
			this.name = name;
			this.desc = desc;
		}
	}
	public void add(Pokemon p) {
		int pid = p.getID();
		if (entries[pid] == null) {
			entries[pid] = new PokeData(pid, true, p.getName(), "this pokemon looks dope af" );
		}
	}
}
