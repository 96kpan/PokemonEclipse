package model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.Serializable;
import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.MenuElement;
import pokemons.Bulbasaur;
import pokemons.Charmander;
import pokemons.Pikachu;
import pokemons.Pokemon;
import pokemons.Squirtle;

public class PokemonGame extends JPanel implements Serializable {

	public static void main(String[] args) {
		PokemonGame gameWindow = new PokemonGame();
		JFrame window = new JFrame();
		window.setLocation(420, 369);
		window.setPreferredSize(new Dimension(WINDOW_SIZE, WINDOW_SIZE));
		window.setDefaultCloseOperation(window.EXIT_ON_CLOSE);
		window.add(gameWindow);
		window.pack();
		window.setVisible(true);
	}

	private final static int WINDOW_SIZE = 384;
	private static final int TILE_SIZE = 16;
	private Trainer trainer;
	private boolean isPaused;
	private MapOne map1;
	private JPanel gameWindow;
	private JPopupMenu pauseMenu;

	public PokemonGame() {

		isPaused = false;
		// initialize trainer name and starter poke
		trainer = new Trainer();
		trainer.setTrainerName(JOptionPane.showInputDialog(this, "Hey there buddy, I'd like to know your name."));
		trainer.getMyBag().addPokemon(setStarter());
		// initialize game panel and pause menu within frame, init frame
		pauseMenu = new JPopupMenu();
		initializePauseMenu();
		gameWindow = new JPanel(null);
		gameWindow.setSize(WINDOW_SIZE, WINDOW_SIZE);
		gameWindow.setLocation(0, 0);
		this.setSize(WINDOW_SIZE, WINDOW_SIZE);
		this.setLocation(0, 0);
		this.add(gameWindow);
		this.add(pauseMenu);
		this.addKeyListener(new KeyboardListener());
		this.setFocusable(true);
		map1 = new MapOne();
		repaint();
	}

	private void initializePauseMenu() {
		pauseMenu.add(new JMenuItem(new PopUpActionListener("Pokedex")));
		pauseMenu.add(new JMenuItem(new PopUpActionListener("Pokemon")));
		pauseMenu.add(new JMenuItem(new PopUpActionListener("Bag")));
		pauseMenu.add(new JMenuItem(new PopUpActionListener("Trainer Card")));
		pauseMenu.add(new JMenuItem(new PopUpActionListener("Save")));
		pauseMenu.add(new JMenuItem(new PopUpActionListener("Option")));
		MenuElement[] pMenuItems = pauseMenu.getSubElements();
		((JMenuItem) pMenuItems[0]).setText("Pokedex");
		((JMenuItem) pMenuItems[1]).setText("Pokemon");
		((JMenuItem) pMenuItems[2]).setText("Bag");
		((JMenuItem) pMenuItems[3]).setText("Trainer Card");
		((JMenuItem) pMenuItems[4]).setText("Save");
		((JMenuItem) pMenuItems[5]).setText("Option");
	}

	// CURRENTLY DRAWS ONE MORE COL AND ~2 MORE ROWS
	// Drawing extra tiles may serve to our advantage when animating centered
	// camera...
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		for (int x = 0; x < map1.MAP_HEIGHT; x++) {
			for (int y = 0; y < map1.MAP_WIDTH; y++) {

				g2.drawImage(map1.getTileAt(x, y).getImage(), y * TILE_SIZE, x * TILE_SIZE, null);

			}
		}
		g2.drawImage(this.trainer.getImage(), trainer.getTrainerLocation().y * TILE_SIZE,
				trainer.getTrainerLocation().x * TILE_SIZE, null);
		// add trainer image here:
		System.out.println(map1.toString());
	}

	public Trainer getTrainer() {
		return this.trainer;
	}

	/*
	 * The following are Java actions for each of the key bindings. There should
	 * be some design pattern that makes this easier/shorter, right? -> um
	 * keylistener implements actionlistern??!!!>!>> idk if needs to be
	 * refactored later
	 */

	private class KeyboardListener implements KeyListener {

		@Override
		public void keyTyped(KeyEvent e) {

		}

		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			// System.out.println(key);
			Point oldPoint = trainer.getTrainerLocation();
			map1.map[oldPoint.x][oldPoint.y].setHasTrainer(false);
			int dx = oldPoint.x;
			int dy = oldPoint.y;

			if (key == 38) { // up
				dx = -1;
				dy = 0;
			} else if (key == 40) { // down
				dx = 1;
				dy = 0;
			} else if (key == 37) { // left
				dy = -1;
				dx = 0;
			} else if (key == 39) { // right
				dy = 1;
				dx = 0;
			}

			if (key == 10) { // enter key will toggle the menu
				toggleMenu();
			}

			// TODO: ADD MORE ELSE IF STATEMENTS FOR ENTER KEYS, A, B, ETC

			if (inBounds(oldPoint.x + dx, oldPoint.y + dy) && map1.map[oldPoint.x + dx][oldPoint.y + dy].canMove()) {
				trainer.setTrainerLocation(new Point(oldPoint.x + dx, oldPoint.y + dy));
				map1.map[oldPoint.x + dx][oldPoint.y + dy].setHasTrainer(true);
				map1.map[oldPoint.x + dx][oldPoint.y + dy].playerIsOnTile(trainer);
			} else {
				trainer.setTrainerLocation(oldPoint);
				map1.map[oldPoint.x][oldPoint.y].setHasTrainer(true);
			}

			repaint();

		}

		private boolean inBounds(int x, int y) {
			if (x > 0 && x < map1.MAP_WIDTH && y > 0 && y < Map.MAP_HEIGHT) {
				return true;
			}
			return false;
		}

		@Override
		public void keyReleased(KeyEvent e) {

		}

	}

	private class PopUpActionListener extends AbstractAction {

		private String buttonPressed;
		private JFrame newFrame;

		public PopUpActionListener(String s) {
			this.buttonPressed = s;
			newFrame = new JFrame();
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			newFrame.setLocation(450, 389);
			newFrame.setPreferredSize(new Dimension(WINDOW_SIZE, WINDOW_SIZE));
			newFrame.pack();
			JPanel newPanel = new JPanel(null);
			newPanel.setLocation(0, 0);
			newPanel.setSize(WINDOW_SIZE-69, WINDOW_SIZE-69);
			newPanel.setBackground(Color.white);

			JLabel jta = new JLabel("");
			jta.setSize(WINDOW_SIZE, WINDOW_SIZE);
			jta.setFont(new Font("Courier", Font.BOLD, 30));

			// if/else if statement for which choice
			if (buttonPressed.equals("Pokedex")) { //all of your pokemons
				jta.setText(trainer.getMyBag().toStringPokedex());
			} else if (buttonPressed.equals("Pokemon")) { //your six pokemons
				jta.setText(trainer.getMyBag().toStringParty());
			} else if (buttonPressed.equals("Bag")) {
				jta.setText(trainer.getMyBag().toStringBag());
			} else if (buttonPressed.equals("Trainer Card")) {

			} else if (buttonPressed.equals("Save")) {

			} else if (buttonPressed.equals("Option")) {

			}

			newPanel.add(jta);
			newFrame.add(newPanel);
			newFrame.setVisible(true);
		}
	}

	private Pokemon setStarter() {
		String[] starters = { "Squirtle", "Charmander", "Bulbasaur", "PEEKACHU;)" };
		Pokemon starter = null;
		int starterPokeNum = JOptionPane.showOptionDialog(null,
				"I found some Pokemon and I'd like to share. Choose one! Go ahead!", "Choose your starter",
				JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, starters, starters[1]);
		switch (starterPokeNum) {
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

	private void toggleMenu() {
		if (!isPaused) {
			// isPaused = !isPaused;
			pauseMenu.show(this, WINDOW_SIZE - 109, 0);
		} else {
			// isPaused = !isPaused;
		}
		// will actually pause once user selects a pause menu item
	}

}
