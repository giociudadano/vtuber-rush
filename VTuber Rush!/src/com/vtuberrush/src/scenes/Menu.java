package com.vtuberrush.src.scenes;

import java.awt.Graphics;

import com.vtuberrush.src.helpers.LoadSave;
import com.vtuberrush.src.main.Game;
import com.vtuberrush.src.ui.Button;

import static com.vtuberrush.src.main.GameStates.PLAYING;
import static com.vtuberrush.src.main.GameStates.EDITING;
import static com.vtuberrush.src.main.GameStates.SETTINGS;
import static com.vtuberrush.src.main.GameStates.setGameState;

/**
 * An <b><i>menu game scene</i></b> is a subclass of a game scene that facilitates the
 * the changing of different game states and moving across different game scenes.
 * 
 * @author Gio Carlo Ciudadano
 * @version 0.0.1-alpha.1
 */
public class Menu extends GameScene implements SceneMethods {
	
	private Button buttonPlaying, buttonEditing, buttonSettings, buttonQuit;
	

	/**
	 * Creates a new <b><i>menu game scene</i></b>, and initializes
	 * all the buttons for changing the current game state and moving
	 * across different game scenes.
	 * @param game - The current instance of the game.
	 */
	public Menu(Game game) {
		super(game);
		initButtons();
	}

	@Override
	public void render(Graphics graphics) {
		graphics.drawImage(LoadSave.getBackground(), 0, 0, null);
		drawButtons(graphics);
	}

	private void initButtons() {
		buttonPlaying = new Button("Play", 550, 350, 200, 60);
		buttonEditing = new Button("Edit", 550, 420, 200, 60);
		buttonSettings = new Button("Settings", 550, 490, 200, 60);
		buttonQuit = new Button("Exit", 550, 560, 200, 60);
	}

	private void drawButtons(Graphics graphics) {
		buttonPlaying.draw(graphics);
		buttonEditing.draw(graphics);
		buttonSettings.draw(graphics);
		buttonQuit.draw(graphics);
	}
	
	private void resetButtons() {
		buttonPlaying.resetButtons();
		buttonEditing.resetButtons();
		buttonSettings.resetButtons();
		buttonQuit.resetButtons();
	}
	
	@Override
	public void mouseClicked(int x, int y) {
		if (buttonPlaying.getBounds().contains(x, y)) {
			setGameState(PLAYING);
		} else if (buttonEditing.getBounds().contains(x, y)) {
			setGameState(EDITING);
		} else if (buttonSettings.getBounds().contains(x, y)) {
			setGameState(SETTINGS);
		} else if (buttonQuit.getBounds().contains(x, y)) {
			System.exit(0);
		}
	}
	
	@Override
	public void mouseMoved(int x, int y) {
		
		buttonPlaying.setMouseOver(false);
		buttonEditing.setMouseOver(false);
		buttonSettings.setMouseOver(false);
		buttonQuit.setMouseOver(false);
		
		if (buttonPlaying.getBounds().contains(x, y)) {
			buttonPlaying.setMouseOver(true);
		} else if (buttonEditing.getBounds().contains(x, y)) {
			buttonEditing.setMouseOver(true);
		} else if (buttonSettings.getBounds().contains(x, y)) {
			buttonSettings.setMouseOver(true);
		} else if (buttonQuit.getBounds().contains(x, y)) {
			buttonQuit.setMouseOver(true);
		}
	}
	
	@Override
	public void mousePressed(int x, int y) {
		if (buttonPlaying.getBounds().contains(x, y)) {
			buttonPlaying.setMousePressed(true);
		} else if (buttonEditing.getBounds().contains(x, y)) {
			buttonEditing.setMousePressed(true);
		} else if (buttonSettings.getBounds().contains(x, y)) {
			buttonSettings.setMousePressed(true);
		} else if (buttonQuit.getBounds().contains(x, y)) {
			buttonQuit.setMousePressed(true);
		}
		
	}
	
	@Override
	public void mouseReleased(int x, int y) {
		resetButtons();
	}
	
	@Override
	public void mouseDragged(int x, int y) {
	}

}
