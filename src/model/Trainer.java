package model;

import java.awt.Point;
import java.util.ArrayList;

import item.*;

public class Trainer {
	
	private Bag myBag;
	private String myTrainerName;
	private Point myTrainerLocation;
	private Direction myTrainerDirection;
	
	public Trainer() {
		myBag = new Bag();
		myTrainerLocation = new Point(5, 10); //starter position
		myTrainerDirection = Direction.EAST;
		myTrainerName = "Pickles";
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

}
