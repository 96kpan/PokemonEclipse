package model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;

import item.Item;
import item.Pokeball;
import tiles.*;
import tiles.Tile;

public abstract class Map implements Serializable {

	protected static final int MAP_HEIGHT = 23;
	protected static final int MAP_WIDTH = 23;
	private static Trainer trainer;
	protected Tile[][] map;

	private Tile bushTile;
	private Tile cementTile;
	private Tile grassTile;
	private Tile smallTreeTile;
	private Tile trainerTile;
	private Tile pokeballTile;
	private Tile cookieTile;
	private Tile superCookieTile;

	private transient BufferedImage bush;
	private transient BufferedImage cement;
	private transient BufferedImage grass;
	// private transient BufferedImage gym;
	private transient BufferedImage smallTree;
	private transient BufferedImage pokeballImage;
	private transient BufferedImage cookieImage;
	private transient BufferedImage superCookieImage;

	public Map() {
		map = new Tile[MAP_HEIGHT][MAP_WIDTH];
		trainer = Trainer.getInstance();

		try {
			bush = ImageIO.read(new File("images/bush.png"));
			cement = ImageIO.read(new File("images/cement.png"));
			grass = ImageIO.read(new File("images/grass.png"));
			// gym = ImageIO.read(new File("images/gym.png"));
			smallTree = ImageIO.read(new File("images/smalltree.png"));
			pokeballImage = ImageIO.read(new File("images/pokeball.png"));
			cookieImage = ImageIO.read(new File("images/cookies.png"));
			superCookieImage = ImageIO.read(new File("images/supercookies.png"));

			bushTile = new BushTile(bush);
			cementTile = new CementTile(cement);
			grassTile = new GrassTile(grass);
			smallTreeTile = new SmallTreeTile(smallTree);
			pokeballTile = new ItemTile(pokeballImage, new Pokeball("Pokeball"));
			cookieTile = new ItemTile(cookieImage, new Pokeball("Cookies"));
			superCookieTile = new ItemTile(superCookieImage, new Pokeball("SuperCookies"));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public abstract void initMap();
	
	public void addItems(Item i, int r, int c){
		if(i.getName().equals("Pokeball")){
			map[r][c] = pokeballTile;
		} else if(i.getName().equals("Cookies")){
			map[r][c] = cookieTile;
		} else if(i.getName().equals("SuperCookies")){
			map[r][c] = superCookieTile;
		}
	}

	protected void setAllToEmpty() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				map[i][j] = grassTile;
			}
		}
	}

	public void fillWithBushTile(int startRow, int endRow, int startCol, int endCol) {
		for (int i = startRow; i < endRow; i++) {
			for (int j = startCol; j < endCol; j++) {
				map[i][j] = bushTile;
			}
		}
	}

	public void fillWithCementTile(int startRow, int endRow, int startCol, int endCol) {
		for (int i = startRow; i < endRow; i++) {
			for (int j = startCol; j < endCol; j++) {
				map[i][j] = cementTile;
			}
		}
	}

	public void fillWithGrassTile(int startRow, int endRow, int startCol, int endCol) {
		for (int i = startRow; i < endRow; i++) {
			for (int j = startCol; j < endCol; j++) {
				map[i][j] = grassTile;
			}
		}
	}

	public void fillWithSmallTreeTile(int startRow, int endRow, int startCol, int endCol) {
		for (int i = startRow; i < endRow; i++) {
			for (int j = startCol; j < endCol; j++) {
				map[i][j] = smallTreeTile;
			}
		}
	}

	public Tile getTileAt(int row, int col) {
		return map[row][col];
	}

	public String toString(){
		StringBuilder s = new StringBuilder();
		
		for(int i = 0; i < map.length; i++){
			for(int j = 0; j < map[0].length; j++){
				if(trainer.getTrainerLocation().x == i && trainer.getTrainerLocation().y == j)
					s.append(" [T] ");
				else
					s.append(map[i][j].toString());
				if(map[0].length-1 == j)
					s.append("\n");
			}
		}
		
		return s.toString();
	}

}
