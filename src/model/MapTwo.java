package model;

import java.io.Serializable;

public class MapTwo extends Map implements Serializable {

	public MapTwo() {
		super();
		initMap();
	}

	@Override
	public void initMap() {
		// all grass
		setAllToEmpty();

		// tree border
		fillWithSmallTreeTile(0, MAP_HEIGHT - 1, 0, 2);
		fillWithSmallTreeTile(0, MAP_HEIGHT, MAP_WIDTH - 2, MAP_WIDTH);
		fillWithSmallTreeTile(0, 2, 0, MAP_WIDTH);
		fillWithSmallTreeTile(MAP_HEIGHT - 2, MAP_HEIGHT, 0, MAP_WIDTH);

		// bush
		fillWithBushTile(12, 18, 9, 14);
		fillWithBushTile(1, 10, 14, 21);

		// cement road
		fillWithCementTile(14, 15, 0, 2);
		fillWithCementTile(10, 15, 2, 3);
		fillWithCementTile(10, 11, 2, 10);
		fillWithCementTile(10, 13, 10, 11);
		fillWithCementTile(13, 14, 10, 19);
		fillWithCementTile(0, 14, 18, 19);

	}

}
