package model;

import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import item.*;
import tiles.BushTile;
import tiles.CementTile;
import tiles.GrassTile;
import tiles.SmallTreeTile;
import tiles.Tile;
import tiles.TrainerTile;

public class Trainer {
	
	private Bag myBag;
	private String myTrainerName;
	private Point myTrainerLocation;
	private Direction myTrainerDirection;
	private Tile trainerTile;
	private transient BufferedImage trainer;
	
	public Trainer() {
		myBag = new Bag();
		myTrainerLocation = new Point(7, 10); //starter position
		myTrainerDirection = Direction.EAST;
		myTrainerName = "Pickles";
		
		try {
			trainer = ImageIO.read(new File("images/trainer.png"));
			
			trainerTile = new TrainerTile(trainer);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public void setTrainerName(String name){
		myTrainerName = name;
	}
	
	public Bag getMyBag(){
		return this.myBag;
	}
	
	public String getTrainerName(){
		return this.myTrainerName;
	}
	
	public Point getTrainerLocation() {
		return this.myTrainerLocation;
	}
	
	public Direction getTrainerDirection() {
		return this.myTrainerDirection;
	}


	public Image getImage() {
		// TODO Auto-generated method stub
		return trainer;
	}

}
