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
		fillWithSmallTreeTile(0, MAP_HEIGHT-1, 0, 1);
		fillWithSmallTreeTile(0, MAP_HEIGHT, MAP_WIDTH-1, MAP_WIDTH);
		fillWithSmallTreeTile(0, 1, 0, MAP_WIDTH);
		fillWithSmallTreeTile(MAP_HEIGHT-1, MAP_HEIGHT, 0, MAP_WIDTH);
		
		//bush
		fillWithBushTile(12, 18, 9, 14);
		
		//cement road
		fillWithCementTile(12, 13, 0, 2);
		fillWithCementTile(10, 13, 2, 3);
		fillWithCementTile(10, 11, 2, 10);
		fillWithCementTile(10, 13, 10, 11);
		fillWithCementTile(13, 14, 10, MAP_WIDTH);
	}

	

}
