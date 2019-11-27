// Last edit: 04/23/2018 - TvB
package com.cekeh.utility;

/**
 * Cekeh's Matrix Exception
 * Created 04/23/2018
 * @author Thomas vanBommel (TvB)
 */
@SuppressWarnings("serial")
public class MatrixException extends Exception {
	
	/**
	 * Create a new matrix exception with specified details
	 * @param message Details about what went wrong
	 */
	public MatrixException(String message) {
		super(message);
	}
}
