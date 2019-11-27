// Last edit: 05/13/2018 - TvB
package com.cekeh.utility;

/**
 * Cekeh's Vectori object class
 * Created 05/13/2018
 * @author Thomas vanBommel (TvB)
 */
public class Vectori {

	// Values to hold
	private int[] data;
	
	// The size of the vector
	private final int size;
	
	/**
	 * Create a new Vector with specified size
	 * @param data The int data members you wish to store in the vector
	 */
	protected Vectori(int[] data) {
		// Add the members to the data array
		this.data = data;
		
		// Set the size of the vector
		size = data.length;
	}
	
	/**
	 * Set a value in the data array (will replace current value)
	 * @param index The index of the value you wish to change; if index it out of range of data.length, nothing will happen.
	 * @param value The value you wish to set
	 */
	protected void set(int index, int value) {
		// Ensure index is within bounds of data[], then set the value
		if(index <= data.length)
			data[index] = value;
	}
	
	/**
	 * Set a value in the data array (will replace current value)
	 * @param array The int array to set
	 */
	protected void set(int[] array) {
		// Get the length of the shortest (they'll usually be the same)
		int length = data.length < array.length ? data.length : array.length;
		
		// Set the vector's data
		for(int i = 0; i < length; i++)
			data[i] = array[i];
	}
	
	/**
	 * Add to the data of this vector
	 * @param array The int array to add
	 */
	protected void add(int[] array) {
		// Get the length of the shortest (they'll usually be the same)
		int length = data.length < array.length ? data.length : array.length;
		
		// Add the vector's together
		for(int i = 0; i < length; i++)
			data[i] += array[i];
	}
	
	/**
	 * Multiply the data values
	 * @param array The int array to multiply
	 */
	protected void multiply(int[] array) {
		// Get the length of the shortest (usually the same)
		int length = data.length < array.length ? data.length : array.length;
		
		// Multiply values
		for(int i = 0; i < length; i++)
			data[i] *= array[i];
	}
	
	/**
	 * Returns a string representation of this object
	 */
	public String toString() {
		// String to return
		String string = "";
		
		// Create the string
		for(int i: data)
			string += i + ", ";
		
		// Return the string
		return string;
	}
	
	/**
	 * Get the data stored in the vector
	 * @return Data stored in the vector
	 */
	public int[] getData() {
		// Return the data
		return data;
	}
	
	/**
	 * Get the size of the vector
	 * @return The size of the vector
	 */
	public int getSize() {
		// Return the size of the vector
		return size;
	}
	
	/**
	 * Extract the data out of a Vectori[] array
	 * @param vector The same data, just as a int[]
	 */
	public static int[] extractData(Vectori[] vector) {
		// Create an array for our data
		int[] array = new int[vector[0].getSize() * vector.length];
		
		// Index for the loop
		int index = 0;
		
		// For each vector
		for(Vectori v: vector) {
			// Data in the vector
			int[] d = v.getData();
			
			// Set up the new array
			for(int i = 0; i < vector[0].getSize(); i++) {
				array[index++] = d[i];
			}
		}
		
		// Return the array
		return array;
	}
}
