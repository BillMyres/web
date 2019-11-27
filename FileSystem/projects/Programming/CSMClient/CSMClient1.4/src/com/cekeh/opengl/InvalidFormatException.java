// Last edit: 04/18/2018 - TvB
package com.cekeh.opengl;

/**
 * Cekeh's Invalid format exception
 * Created 04/18/2018
 * @author Thomas vanBommel (TvB)
 */
@SuppressWarnings("serial")
public class InvalidFormatException extends Exception {

	/**
	 * Create a new invalid format exception with specified details
	 * @param message Details about what went wrong
	 */
	public InvalidFormatException(String message) {
		super(message);
	}
}
