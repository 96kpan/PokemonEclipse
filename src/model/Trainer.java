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
		myTrainerName = null;
		initTrainer();
	}

	private void initTrainer() {
		
		if(myTrainerName.equals(null)){
			myTrainerName = "Ash Ketchum"; //if no name is set
		}
		myTrainerLocation = new Point(5, 10); //starter position
		myTrainerDirection = Direction.EAST;
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
