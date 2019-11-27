// Last edit: 05/06/2018 - TvB
package com.cekeh.opengl;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.glfw.GLFW;

import static org.lwjgl.glfw.GLFW.*;

import org.lwjgl.opengl.GL;

import com.cekeh.game.Camera;
import com.cekeh.main.Client;
import com.cekeh.utility.Matrix4f;

/**
 * Cekeh's Game class made with OpenGL
 * Created 04/14/2018
 * @author Thomas vanBommel (TvB)
 */
public abstract class Game {
	
	private Camera camera = new Camera();

	/**
	 * Create a new game object
	 */
	protected Game() {}
	
	/**
	 * Initialize OpenGL
	 * @throws Exception Something wen't wrong in the initialization process
	 */
	public void initialize() throws Exception {
		// Create the window capabilities, and set to use on this (main) thread
		GL.createCapabilities();
		
		// Enable alpha blending for all textures
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
	}
	
	/**
	 * Update the game, then render the new frame
	 * @param delta DeltaTime between frames
	 */
	public void update(double delta) {
		// Update the camera
		camera.update(delta);
	}
	
	/**
	 * Rendering with OpenGL to the GLFW window context
	 */
	public abstract void render();
	
	/**
	 * Clean up any memory resources used
	 */
	public abstract void cleanUp();
	
	/**
	 * Clear the current frame and prepare for a new frame to be rendered
	 */
	public void clearBuffer() {		
		// Clear the current frame, done before swapping frames
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
	}
	
	/**
	 * Set the viewport of our game
	 * This is done when the window changes size
	 * @param width The new width of the context/frame buffer
	 * @param height The new height of the context/frame buffer
	 */
	public void updateViewport(int width, int height) {
		// Set the viewport of our context, this is done when the window changes size
		glViewport(0, 0, width, height);
	}
	
	/**
	 * Get the games (main) camera
	 * @return The (main) camera object
	 */
	public Camera getCamera() {
		// Return the camera object
		return camera;
	}
}
