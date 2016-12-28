package model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;

import tiles.*;
import tiles.Tile;

public abstract class Map implements Serializable{
	
	protected static final int MAP_HEIGHT = 23;
	protected static final int MAP_WIDTH = 23;
	private Tile[][] map;
	
	private Tile bushTile;
	private Tile cementTile;
	private Tile grassTile;
	private Tile smallTreeTile;

	private transient BufferedImage bush;
	private transient BufferedImage cement;
	private transient BufferedImage grass;
	//private transient BufferedImage gym;
	private transient BufferedImage smallTree;

	public Map() {
		map = new Tile[MAP_HEIGHT][MAP_WIDTH];
		try {
			bush = ImageIO.read(new File("images/bush.png"));
			cement = ImageIO.read(new File("images/cement.png"));
			grass = ImageIO.read(new File("images/grass.png"));
			//gym = ImageIO.read(new File("images/gym.png"));
			smallTree = ImageIO.read(new File("images/smalltree.png"));
			
			bushTile = new BushTile(bush);
			cementTile = new GrassTile(grass);
			grassTile = new GrassTile(grass);
			smallTreeTile = new GrassTile(grass);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public abstract void initMap();
	
	protected void setAllToEmpty() {
		for(int i = 0; i < map.length; i++){
			for(int j = 0; j < map[0].length; j++){
				map[i][j] = grassTile;
			}
		}
	}
	
	public void fillWithBushTile(int startRow, int endRow, int startCol, int endCol){
		for(int i = startRow; i < endRow; i++){
			for(int j = startCol; j < endCol; j++){
				map[i][j] = bushTile;
			}
		}
	}
	
	public void fillWithCementTile(int startRow, int endRow, int startCol, int endCol){
		for(int i = startRow; i < endRow; i++){
			for(int j = startCol; j < endCol; j++){
				map[i][j] = cementTile;
			}
		}
	}
	
	public void fillWithGrassTile(int startRow, int endRow, int startCol, int endCol){
		for(int i = startRow; i < endRow; i++){
			for(int j = startCol; j < endCol; j++){
				map[i][j] = grassTile;
			}
		}
	}
	
	public void fillWithSmallTreeTile(int startRow, int endRow, int startCol, int endCol){
		for(int i = startRow; i < endRow; i++){
			for(int j = startCol; j < endCol; j++){
				map[i][j] = smallTreeTile;
			}
		}
	}
	
	public String getTileAt(int row, int col){
		return map[row][col].toString();
	}
	
	public String toString(){
		StringBuilder s = new StringBuilder();
		for(int i = 0; i < map.length; i++){
			for(int j = 0; j < map[0].length; j++){
				if(map[0].length-1 == j){
					s.append(map[i][j].toString() + "\n");
				}
				else{
					s.append(map[i][j].toString());
				}
			}
		}
		
		return s.toString();
	}
	
	
}
