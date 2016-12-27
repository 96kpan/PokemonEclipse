package model;

import java.io.Serializable;

public class MapOne extends Map implements Serializable{
	
	public MapOne(){
		super();
		initMap();
	}

	@Override
	public void initMap() {
		setAllToEmpty();
		
		//tree border
		fillWithSmallTreeTile(0, MAP_HEIGHT, 0, 0);
		fillWithSmallTreeTile(0, MAP_HEIGHT, MAP_WIDTH, MAP_WIDTH);
		fillWithSmallTreeTile(0, 0, 0, MAP_WIDTH);
		fillWithSmallTreeTile(0, 0, MAP_WIDTH, MAP_WIDTH);
		
	}

	

}
