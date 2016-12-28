package model;

import java.io.Serializable;

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
		fillWithSmallTreeTile(0, MAP_HEIGHT, 0, 0);
		fillWithSmallTreeTile(0, MAP_HEIGHT, MAP_WIDTH, MAP_WIDTH);
		fillWithSmallTreeTile(0, 0, 0, MAP_WIDTH);
		fillWithSmallTreeTile(0, 0, MAP_WIDTH, MAP_WIDTH);
		
		//bush border
		fillWithBushTile(12, 18, 9, 14);
		
		//cement road
		fillWithCementTile(13, 13, 0, 2);
		fillWithCementTile(10, 13, 2, 2);
		fillWithCementTile(10, 10, 2, 10);
		fillWithCementTile(10, 13, 10, 10);
		fillWithCementTile(10, 13, 10, 10);
		fillWithCementTile(13, 13, 10, MAP_WIDTH);
	}

	

}
