package model;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.Random;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.KeyStroke;

import item.Cookies;
import item.Item;
import item.Pokeball;
import item.SuperCookies;
import pokemons.Bulbasaur;
import pokemons.Charmander;
import pokemons.Pikachu;
import pokemons.Pokemon;
import pokemons.Squirtle;

public class controller extends JPanel implements Serializable {

	public static void main(String[] args) {
		controller gameWindow = new controller();
		JFrame window = new JFrame();
		window.setLocation(420, 369);
		window.setPreferredSize(new Dimension(WINDOW_SIZE, WINDOW_SIZE));
		window.add(gameWindow);
		window.pack();
		window.setVisible(true);
	}
	private final static int WINDOW_SIZE = 384;
	private static final int TILE_SIZE = 16;
	private Trainer trainer;
	private boolean isBattling;
	private boolean isPaused;
	private MapOne map1;
	private JPanel gameWindow;
	private JPopupMenu pauseMenu;
	public controller() {
		isBattling = false;
		isPaused = false;
		// initialize trainer name and starter poke
		trainer = new Trainer();
		trainer.setTrainerName(JOptionPane.showInputDialog(this, "Hey there buddy, I'd like to know your name."));
		trainer.getMyBag().addPokemon(setStarter());
		// initialize game panel and pause menu within frame, init frame
		pauseMenu = new JPopupMenu();
		pauseMenu.add(new JMenuItem("Pokedex"));
		pauseMenu.add(new JMenuItem("Pokemon"));
		pauseMenu.add(new JMenuItem("Bag"));
		pauseMenu.add(new JMenuItem("Trainer Card"));
		pauseMenu.add(new JMenuItem("Save"));
		pauseMenu.add(new JMenuItem("Options"));
		gameWindow = new JPanel(null);
		gameWindow.setSize(WINDOW_SIZE, WINDOW_SIZE);
		gameWindow.setLocation(0, 0);
		this.setSize(WINDOW_SIZE, WINDOW_SIZE);
		this.setLocation(0, 0);
		this.add(gameWindow);
		this.add(pauseMenu);
		map1 = new MapOne();
		repaint();
		initializeKeyBindings();
	}
	
	// CURRENTLY DRAWS ONE MORE COL AND ~2 MORE ROWS
	// Drawing extra tiles may serve to our advantage when animating centered camera...
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		for (int x = 0; x < map1.MAP_HEIGHT; x++) {
			for (int y = 0; y < map1.MAP_WIDTH; y++) {
				g2.drawImage(map1.getTileAt(x, y).getImage(), y*TILE_SIZE, x*TILE_SIZE, null);
				
			}
			
		}
		
		//add trainer image here:
		g2.drawImage(this.trainer.getImage(), trainer.getTrainerLocation().y * TILE_SIZE, trainer.getTrainerLocation().x * TILE_SIZE, null);
		
		
		//System.out.println(map1.toString());
	}

	private void initializeKeyBindings() {
		gameWindow.getInputMap().put(KeyStroke.getKeyStroke("ENTER"), "PAUSE");
		gameWindow.getActionMap().put("PAUSE", new PauseAction());
		gameWindow.getInputMap().put(KeyStroke.getKeyStroke("w"), "MOVEMENT_UP");
		gameWindow.getActionMap().put("MOVEMENT_UP", new UpAction());
		gameWindow.getInputMap().put(KeyStroke.getKeyStroke("a"), "MOVEMENT_LEFT");
		gameWindow.getActionMap().put("MOVEMENT_LEFT", new LeftAction());
		gameWindow.getInputMap().put(KeyStroke.getKeyStroke("s"), "MOVEMENT_DOWN");
		gameWindow.getActionMap().put("MOVEMENT_DOWN", new DownAction());
		gameWindow.getInputMap().put(KeyStroke.getKeyStroke("d"), "MOVEMENT_RIGHT");
		gameWindow.getActionMap().put("MOVEMENT_RIGHT", new RightAction());
		gameWindow.getInputMap().put(KeyStroke.getKeyStroke("j"), "A");
		gameWindow.getActionMap().put("A", new AButtonAction());
		gameWindow.getInputMap().put(KeyStroke.getKeyStroke("k"), "B");
		gameWindow.getActionMap().put("B", new BButtonAction());
	}
	/*
	 * The following are Java actions for each of the key bindings.
	 * There should be some design pattern that makes this easier/shorter, right?
	 * idk if needs to be refactored later
	 */
	class PauseAction extends AbstractAction{
		public PauseAction(){
			super("pause", null);
		}
		public void actionPerformed(ActionEvent e){
			toggleMenu();

		}
	}
	class UpAction extends AbstractAction{
		public UpAction(){
			super("up", null);
		}
		public void actionPerformed(ActionEvent e){
			// move char up
		}
	}
	class DownAction extends AbstractAction{
		public DownAction(){
			super("down", null);
		}
		public void actionPerformed(ActionEvent e){
			// move char down
		}
	}
	class LeftAction extends AbstractAction{
		public LeftAction(){
			super("left", null);
		}
		public void actionPerformed(ActionEvent e){
			// move char left
		}
	}
	class RightAction extends AbstractAction{
		public RightAction(){
			super("right", null);
		}
		public void actionPerformed(ActionEvent e){
			// move char right
		}
	}
	class AButtonAction extends AbstractAction{
		public AButtonAction(){
			super("a", null);
		}
		public void actionPerformed(ActionEvent e){
			// select
		}
	}
	class BButtonAction extends AbstractAction{
		public BButtonAction(){
			super("b", null);
		}
		public void actionPerformed(ActionEvent e){
			// deselect
		}
	}
	
	private Pokemon setStarter() {
		String[] starters = { "Squirtle", "Charmander", "Bulbasaur", "PEEKACHU;)" };
		Pokemon starter = null;
		int starterPokeNum = JOptionPane.showOptionDialog(null,
				"I found some Pokemon and I'd like to share. Choose one! Go ahead!", "Choose your starter",
				JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, starters, starters[0]);
		switch (starterPokeNum){
			case 0:
				starter = new Squirtle();
				break;
			case 1:
				starter = new Charmander();
				break;
			case 2:
				starter = new Bulbasaur();
				break;
			case 3:
				starter = new Pikachu();
				break;
		}
		starter.setLevel(5);
		starter.setTotalHealth(20);
		return starter;
	}

	public Item acquireItem() {
		Random rand = new Random();
		int randomNum = rand.nextInt(100) + 1;

		if (randomNum < 25) {
			return new Cookies("Cookies");
		} else if (randomNum < 35) {
			return new SuperCookies("SuperCookies");
		} else {
			return new Pokeball("Pokeball");
		}

	}

	public void launchBattle() {
		isBattling = true; // will need to make separate window for battles.
		
	}

	private void toggleMenu() {
		if (!isPaused) {
			//isPaused = !isPaused;
			pauseMenu.show(this, WINDOW_SIZE-109, 0);
		} else {
			//isPaused = !isPaused;
		}
		// will actually pause once user selects a pause menu item
	}

	
}
