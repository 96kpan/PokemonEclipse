package model;

import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;

import item.*;
import tiles.BushTile;
import tiles.CementTile;
import tiles.GrassTile;
import tiles.SmallTreeTile;
import tiles.Tile;

public class Trainer {
	
	private Bag myBag;
	private static Trainer instance;
	private String myTrainerName;
	private static Point myTrainerLocation;
	private Direction myTrainerDirection;
	private transient BufferedImage trainer;
	private boolean isBattling;
	
	public Trainer() {
		myBag = new Bag();
		isBattling = false;
		myTrainerLocation = new Point(12, 0); //starter position
		myTrainerDirection = Direction.EAST;
		myTrainerName = "Pickles";
		
		try {
			trainer = ImageIO.read(new File("images/trainer.png"));
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	public Item acquireItem() {
		Random rand = new Random();
		int randomNum = rand.nextInt(100) + 1;
		
		Item temp = null;
		
		if (randomNum < 25) {
			temp = new Cookies("Cookies");
		} else if (randomNum < 35) {
			temp = new SuperCookies("SuperCookies");
		} else {
			temp = new Pokeball("Pokeball");
		}
		
		this.myBag.addItemToBag(temp.getName()); 
		return temp;
	}
	
	public void acquireItem(Item i) {	
		this.myBag.addItemToBag(i.getName()); 
	}
	
	public void launchBattle() {
		isBattling = true; // will need to make separate window for battles.
	}
	
	public static synchronized Trainer getInstance()
	{
		if (instance == null)
			instance = new Trainer();

		return instance;
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
	
	public void setTrainerLocation(Point p){
		this.myTrainerLocation = p;
	}
	
	public Direction getTrainerDirection() {
		return this.myTrainerDirection;
	}

	public Image getImage() {
		return trainer;
	}
	
	public boolean getBattleState() {
		return isBattling;
	}
}
