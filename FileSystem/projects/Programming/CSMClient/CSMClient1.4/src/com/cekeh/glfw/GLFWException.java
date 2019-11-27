// Last edit: 04/16/2018 - TvB
package com.cekeh.glfw;

/**
 * Cekeh's GLFW Exception
 * Created 04/13/2018
 * @author Thomas vanBommel (TvB)
 */
@SuppressWarnings("serial")
public class GLFWException extends Exception{
	
	/**
	 * Create a new GLFW exception with specified details
	 * @param message Details about what went wrong
	 */
	public GLFWException(String message) {
		super(message);
	}
}
