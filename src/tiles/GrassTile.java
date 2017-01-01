package tiles;

import java.awt.image.BufferedImage;
import java.io.Serializable;

import model.controller;

public class GrassTile extends Tile implements Serializable{

	public GrassTile(BufferedImage tileImage) {
		super(tileImage);
	}

	@Override
	public void playerIsOnTile(controller game) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return " [g] ";
	}

}
