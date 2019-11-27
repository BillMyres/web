// Last edit: 05/11/2018 - TvB
package com.cekeh.glfw;

import org.lwjgl.glfw.GLFWCursorPosCallbackI;
import org.lwjgl.glfw.GLFWMouseButtonCallbackI;

import com.cekeh.utility.Vector2f;

/**
 * Cekeh's Mouse event object
 * Created 04/29/2018
 * @author Thomas vanBommel (TvB)
 */
public class MouseEvent implements GLFWCursorPosCallbackI {

	// The mouse's current position
	private Vector2f position = new Vector2f(0, 0);
	
	// TODO: rename to distance
	private Vector2f velocity = new Vector2f(0, 0);
	
	private boolean moved = false;
	
	/**
	 * Send a mouse event to the game
	 * @param window The window calling the mouse event
	 * @param xpos The mouse's new x position
	 * @param ypos The mouse's new y position
	 */
	public void invoke(long window, double xpos, double ypos) {
		moved = true;
		
		if(xpos > position.x())
			velocity.setX((float) (xpos - position.x()) / 100f);
		
		if(xpos < position.x())
			velocity.setX((float) (xpos - position.x()) / 100f);
		
		if(ypos > position.y())
			velocity.setY((float) (ypos - position.y()) / 100f);
		
		if(ypos < position.y())
			velocity.setY((float) (ypos - position.y()) / 100f);
		
		position = new Vector2f((float) xpos, (float) ypos);
	}
	
	/**
	 * Update the mouse event
	 */
	public void update() {
		if(moved) {
			moved = false;
			return;
		}
		
		velocity = new Vector2f(0, 0);
	}
	
	/**
	 * Get the mouse's velocity (x, y axis)
	 * @return The mouse's velocity in a Vector2f
	 */
	public Vector2f getVelocity() {
		// Return the mouse's velocity
		return velocity;
	}
}
