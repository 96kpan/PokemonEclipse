package model;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
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
		PokemonGame game = new PokemonGame();
		JFrame window = new JFrame();
		gameCardPanel = new JPanel(new CardLayout());
		window.setLocation(420, 369);
		window.setPreferredSize(new Dimension(WINDOW_SIZE, WINDOW_SIZE));
		window.setDefaultCloseOperation(window.EXIT_ON_CLOSE);
		window.add(gameCardPanel);
		gameCardPanel.add(game, "g");
		((CardLayout) gameCardPanel.getLayout()).show(gameCardPanel, "g");
		gameCardPanel.addKeyListener(game.new KeyboardListener());
		gameCardPanel.setFocusable(true);
		window.pack();
		window.setVisible(true);

	}

	private final static int WINDOW_SIZE = 384;
	private static final int TILE_SIZE = 16;
	private Trainer trainer;
	private boolean isPaused;
	private MapOne map1;
	private JPopupMenu pauseMenu;
	private JPanel menuFrame;
	private static JPanel gameCardPanel; // doesn't need to be serialized.
	private Pokedex dex;

	public PokemonGame() {
		dex = new Pokedex();
		isPaused = false;
		// initialize trainer name and starter poke
		trainer = new Trainer();
		trainer.setTrainerName(JOptionPane.showInputDialog(this, "Hey there buddy, I'd like to know your name."));
		trainer.getMyBag().addPokemon(setStarter());
		// initialize game panel and pause menu within frame, init frame
		pauseMenu = new JPopupMenu();
		initializePauseMenu();
		this.setSize(WINDOW_SIZE, WINDOW_SIZE);
		this.setLocation(0, 0);
		// this.addKeyListener(new KeyboardListener());
		// this.setFocusable(true);
		this.add(pauseMenu);
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
		pauseMenu.add(new JMenuItem(new PopUpActionListener("Cancel")));
		MenuElement[] pMenuItems = pauseMenu.getSubElements();
		((JMenuItem) pMenuItems[0]).setText("Pokedex");
		((JMenuItem) pMenuItems[1]).setText("Pokemon");
		((JMenuItem) pMenuItems[2]).setText("Bag");
		((JMenuItem) pMenuItems[3]).setText("Trainer Card");
		((JMenuItem) pMenuItems[4]).setText("Save");
		((JMenuItem) pMenuItems[5]).setText("Option");
		((JMenuItem) pMenuItems[6]).setText("Cancel");
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
	}

	public Trainer getTrainer() {
		return this.trainer;
	}

	private void launchBattleScene() {
		Battle battle = new Battle();
		this.add(battle);

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
			if (!isPaused) {
				if (key == KeyEvent.VK_ENTER) { // enter key will toggle the menu
					toggleMenu();
				} else if (key ==  KeyEvent.VK_J) { // A button is 'J'
					// picks up item if neccessary, needs to be facing item

					if (map1.map[trainer.getTrainerLocation().x][trainer.getTrainerLocation().y].hasItem()) {
					
						trainer.acquireItem(
								map1.map[trainer.getTrainerLocation().x][trainer.getTrainerLocation().y].getItem());
						
					}
				} else if (key >= 37 && key <= 40) {
					
					Point oldPoint = trainer.getTrainerLocation();
					map1.map[oldPoint.x][oldPoint.y].setHasTrainer(false);
					int dx = 0;
					int dy = 0;

					if (key == 38) { // up
						dx = -1;
						dy = 0;
						trainer.setTrainerDirection(Direction.NORTH);
					} else if (key == 40) { // down
						dx = 1;
						dy = 0;
						trainer.setTrainerDirection(Direction.SOUTH);
					} else if (key == 37) { // left
						dy = -1;
						dx = 0;
						trainer.setTrainerDirection(Direction.WEST);
					} else if (key == 39) { // right
						dy = 1;
						dx = 0;
						trainer.setTrainerDirection(Direction.EAST);
					}
					
					if (inBounds(oldPoint.x + dx, oldPoint.y + dy)
							&& map1.map[oldPoint.x + dx][oldPoint.y + dy].canMove()) {
						trainer.setTrainerLocation(new Point(oldPoint.x + dx, oldPoint.y + dy));
						map1.map[oldPoint.x + dx][oldPoint.y + dy].setHasTrainer(true);
						map1.map[oldPoint.x + dx][oldPoint.y + dy].playerIsOnTile(trainer);
						if (trainer.getBattleState()) {
							launchBattleScene();
						}
					} else {
						trainer.setTrainerLocation(oldPoint);
						map1.map[oldPoint.x][oldPoint.y].setHasTrainer(true);
					}
				}

			}

			else if (key == KeyEvent.VK_ENTER) { // enter key will toggle the
													// menu
				((CardLayout) gameCardPanel.getLayout()).show(gameCardPanel, "g");
				if (gameCardPanel.getComponentCount() >= 2)
					gameCardPanel.remove(1); // removes the previous menu card
				isPaused = false;
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

		public PopUpActionListener(String s) {
			this.buttonPressed = s;

		}

		@Override
		public void actionPerformed(ActionEvent e) {
			isPaused = true;
			menuFrame = new JPanel();
			menuFrame.setLocation(0, 0);
			menuFrame.setPreferredSize(new Dimension(WINDOW_SIZE, WINDOW_SIZE));
			menuFrame.setBackground(new Color(41, 255, 173));

			JLabel jta = new JLabel("");
			jta.setSize(WINDOW_SIZE, WINDOW_SIZE);
			jta.setFont(new Font("Courier", Font.BOLD, 30));

			// if/else if statement for which choice
			if (buttonPressed.equals("Pokedex")) { // all of your pokemons
				
			} else if (buttonPressed.equals("Pokemon")) { // your six pokemons
				jta.setText(trainer.getMyBag().toStringParty());
			} else if (buttonPressed.equals("Bag")) {
				jta.setText(trainer.getMyBag().toStringBag());
			} else if (buttonPressed.equals("Trainer Card")) {
				
			} else if (buttonPressed.equals("Save")) {

			} else if (buttonPressed.equals("Option")) {

			} else {
				isPaused = false;
				return;
			}
			menuFrame.add(jta);
			gameCardPanel.add(menuFrame, "m");
			((CardLayout) gameCardPanel.getLayout()).show(gameCardPanel, "m");

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

	private void toggleMenu() { // should pressing b need to cancel the menu?
		// cancel option already provided.
		pauseMenu.show(this, WINDOW_SIZE - 109, 0);

	}

}
