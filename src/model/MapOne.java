package model;

import java.io.Serializable;

import item.Pokeball;

public class MapOne extends Map implements Serializable{
	
	public MapOne(){
		super();
		initMap();
	}

	@Override
	public void initMap() {
		
		//all grass
		setAllToEmpty();
		
		//tree border
		fillWithSmallTreeTile(0, MAP_HEIGHT-1, 0, 1);
		fillWithSmallTreeTile(0, MAP_HEIGHT, MAP_WIDTH-1, MAP_WIDTH);
		fillWithSmallTreeTile(0, 1, 0, MAP_WIDTH);
		fillWithSmallTreeTile(MAP_HEIGHT-1, MAP_HEIGHT, 0, MAP_WIDTH);
		
		//bush
		fillWithBushTile(4, 18, 4, 21);
		
		//cement road
		fillWithCementTile(12, 13, 0, 2);
		fillWithCementTile(10, 13, 2, 3);
		fillWithCementTile(10, 11, 2, 10);
		fillWithCementTile(10, 13, 10, 11);
		fillWithCementTile(13, 14, 10, MAP_WIDTH);
		
		//add randomItems YAY! :^)
		this.addItems(new Pokeball("Pokeball"), 4, 5);
		this.addItems(new Pokeball("Cookies"), 14, 19);
		this.addItems(new Pokeball("SuperCookies"), 4, 17);
		this.addItems(new Pokeball("Cookies"), 6, 15);
		this.addItems(new Pokeball("Pokeball"), 9, 21);
		this.addItems(new Pokeball("Pokeball"), 20, 12);
	}

	

}
