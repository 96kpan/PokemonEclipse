package tiles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import item.Item;
import model.Trainer;

public class ItemTile extends Tile{
	private static Trainer myTrainer;
	private Item currItem;

	public ItemTile(BufferedImage tileImage) {
		super(tileImage);
		myTrainer = Trainer.getInstance();
	}
	
	public ItemTile(BufferedImage tileImage, Item i) {
		super(tileImage);
		myTrainer = Trainer.getInstance();
		this.currItem = i;
	}

	@Override
	public void playerIsOnTile(Trainer trainer) {
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return " [I] ";
	}
	
	@Override
	public boolean hasItem(){
		return true;
	}
	
	@Override
	public Item getItem(){
		return currItem;
		
	}

}
