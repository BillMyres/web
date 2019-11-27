// Last edit: 04/16/2018 - TvB
package com.cekeh.opengl;

/**
 * Cekeh's OpenGL Exception
 * Created 04/16/2018
 * @author Thomas vanBommel (TvB)
 */
@SuppressWarnings("serial")
public class OpenGLException extends Exception{
	
	/**
	 * Create a new OpenGL exception with specified details
	 * @param message Details about what went wrong
	 */
	public OpenGLException(String message) {
		super(message);
	}
}
