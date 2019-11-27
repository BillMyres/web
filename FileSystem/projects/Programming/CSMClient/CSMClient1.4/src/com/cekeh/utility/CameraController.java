// Last edit: 05/11/2018 - TvB
package com.cekeh.utility;

import static org.lwjgl.glfw.GLFW.*;

import com.cekeh.game.Camera;
import com.cekeh.main.Client;

/**
 * Cekeh's Camera controller object
 * Created 04/29/2018
 * @author Thomas vanBommel (TvB)
 */
public class CameraController {

	// The camera we will be controlling
	private Camera camera;
	
	// The speed the camera can move
	private Vector3f speed = new Vector3f(5, 5, 5);
	
	// The current velocity of the camera
	private Vector3f velocity = new Vector3f(0, 0, 0);
	
	// The camera rotation input
	private Vector3f rotation_input = new Vector3f(0, 0, 0);
	
	/**
	 * Create a new camera controller
	 * @param camera The camera to control
	 */
	public CameraController(Camera camera) {
		// Set the camera we will be controlling
		this.camera = camera;
	}
	
	/**
	 * Update the camera controller every frame
	 * @param delta DeltaTime between frames
	 */
	public void update(double delta) {
		// Get the player input
		Vector3f input = getTranslationInput();
		
		// Set the camera's velocity
		velocity.set(
				(float) (input.x() * speed.x() * delta),
				(float) (input.y() * speed.y() * delta),
				(float) (input.z() * speed.z() * delta)
		);
		
		// Move the camera
		camera.transform.translate(velocity);
		
		// Rotate the camera
		camera.transform.rotate(getRotationInput());
	}
	
	/**
	 * Get the translation input from the user
	 * @return Vector3f axis translation (x, y, z)
	 */
	private Vector3f getTranslationInput() {
		// Set the input to zero
		Vector3f input = new Vector3f(0, 0, 0);
		
		// Check if the playing wants to go left
		if(Client.window.getKeyEvent().keyDown(GLFW_KEY_A))
			input.add(1, 0, 0);
		
		// Check if the playing wants to go right
		if(Client.window.getKeyEvent().keyDown(GLFW_KEY_D))
			input.add(-1, 0, 0);
		
		// Check if the playing wants to go up
		if(Client.window.getKeyEvent().keyDown(GLFW_KEY_SPACE))
			input.add(0, -1, 0);
		
		// Check if the playing wants to go down
		if(Client.window.getKeyEvent().keyDown(GLFW_KEY_LEFT_SHIFT))
			input.add(0, 1, 0);
		
		// Check if the playing wants to go forward
		if(Client.window.getKeyEvent().keyDown(GLFW_KEY_W))
			input.add(0, 0, 1);
		
		// Check if the playing wants to go backward
		if(Client.window.getKeyEvent().keyDown(GLFW_KEY_S))
			input.add(0, 0, -1);
		
		// Return the input vectors
		return input;
	}
	
	/**
	 * Get the rotation input from the user
	 * @return Vector3f axis rotation (x, y, z)
	 */
	private Vector3f getRotationInput() {
		if(Client.window.getKeyEvent().keyDown(GLFW_KEY_UP))
			rotation_input.setX(-0.05f);
		else if(Client.window.getKeyEvent().keyDown(GLFW_KEY_DOWN))
			rotation_input.setX(0.05f);
		else
			rotation_input.setX(0);
		
		if(Client.window.getKeyEvent().keyDown(GLFW_KEY_RIGHT))
			rotation_input.setY(0.05f);
		else if(Client.window.getKeyEvent().keyDown(GLFW_KEY_LEFT))
			rotation_input.setY(-0.05f);
		else
			rotation_input.setY(0);
		
		// Return the input vectors
		return rotation_input;
	}
}
