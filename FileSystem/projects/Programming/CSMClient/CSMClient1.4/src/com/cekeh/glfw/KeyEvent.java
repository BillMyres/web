// Last edit: 04/29/2018 - TvB
package com.cekeh.glfw;

import static org.lwjgl.glfw.GLFW.*;

import java.util.ArrayList;

import org.lwjgl.glfw.GLFWKeyCallbackI;

/**
 * Cekeh's Key event object
 * Created 04/28/2018
 * @author Thomas vanBommel (TvB)
 */
public class KeyEvent implements GLFWKeyCallbackI{

	// Key's that are currently being held
	private ArrayList<Integer> active_keys = new ArrayList<Integer>();
	
	/**
	 * Send a keyboard event to the game
	 * @param window The window calling the event
	 * @param key The keyboard key that was pressed or released
	 * @param code The system-specific code of the key
	 * @param action The key action: GLFW_PRESS, GLFW_RELEASE, GLFW_REPEAT
	 * @param mods Modifier keys held down
	 */
	@Override
	public void invoke(long window, int key, int scancode, int action, int mods) {
		// Check if the key should be added to the active key list
		if(action == GLFW_PRESS)
			active_keys.add(key);
		
		// Check if the key should be removed from the active key list
		else if(action == GLFW_RELEASE)
			active_keys.remove((Integer) key);
	}
	
	/**
	 * Ask if a key is currently being held down
	 * @param key The GLFW key code for the key you're requesting about
	 * @return True if the key is down or false if the key is up
	 */
	public boolean keyDown(int key) {
		// Check each active key
		for(int i: active_keys)
			if(i == key)
				return true;
		
		// Return false if key is not an active key
		return false;
	}
}
