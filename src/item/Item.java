package item;

public abstract class Item {
	
	private String name;
	
	public Item(String itemName){
		name = itemName;
	}
	
	public String getName(){
		return name;
	}

}
