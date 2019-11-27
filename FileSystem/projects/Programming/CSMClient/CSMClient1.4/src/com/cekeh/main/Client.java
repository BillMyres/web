// Last edit: 04/29/2018 - TvB
package com.cekeh.main;

import com.cekeh.game.TestGame;
import com.cekeh.glfw.Window;
import com.cekeh.opengl.Game;
import com.cekeh.utility.Time;

/**
 * Cekeh's client program
 * Created 04/13/2018
 * @version Version 1.4
 * @author Thomas vanBommel (TvB)
 * @author www.Cekeh.com
 */
public class Client{
	
	// The window to render everything
	public static Window window;
	
	// The game we will display in our window
	public static Game game;
	
	// TODO: Java-Doc
	public static void main(String[] args) throws Exception {
		// Create a new window to display everything
		window = new Window();
		
		// Create the game to display on the window
		game = new TestGame();
		
		// Create a new client, and start updating it (main loop)
		new Client().update();
	}
	
	// Time will help keep a steady FPS for our client
	private Time time = new Time();
	
	/**
	 * Create a new, windowed client program
	 * @throws Exception Something wen't wrong in the initialization process
	 */
	private Client() throws Exception {
		// Initialize our game
		game.initialize();
	}

	/**
	 * Main loop of our program
	 * @throws InterruptedException This thread was interrupted by another, unable to sleep
	 */
	protected void update() throws InterruptedException {
		// Run this game loop until GLFW is going to close the window
		while(!window.windowShouldClose()) {
			// Update the time object to maintain FPS
			time.update();
			
			// Update the game objects
			game.update(time.deltaTime());
			
			// Clear the buffer before rendering
			game.clearBuffer();
			
			// Render the new frame
			game.render();
			
			// Swap window buffers to reveal the new frame
			window.swapBuffers();
			
			// Poll GLFW window events
			window.pollEvents();
			
			// Sleep the thread
			time.sleep();
		}
		
		// Time to clean up
		cleanUp();
	}
	
	/**
	 * Clean up any resources used by our code
	 */
	protected void cleanUp() {
		// Clean up the game
		game.cleanUp();
		
		// Clean up the window
		window.cleanUp();
	}
}
