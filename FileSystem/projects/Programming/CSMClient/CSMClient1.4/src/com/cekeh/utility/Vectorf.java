// Last edit: 05/13/2018 - TvB
package com.cekeh.utility;

/**
 * Cekeh's Vectorf object class
 * Created 05/11/2018
 * @author Thomas vanBommel (TvB)
 */
public abstract class Vectorf {
	
	// Values to be stored
	private float[] data;
	
	// The size of the vector
	private final int size;
	
	/**
	 * Create a new Vector with specified size
	 * @param data The float data members you wish to store in the vector
	 */
	protected Vectorf(float[] data) {
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
	protected void set(int index, float value) {
		// Ensure index is within bounds of data[], then set the value
		if(index <= data.length)
			data[index] = value;
	}
	
	/**
	 * Set a value in the data array (will replace current value)
	 * @param array The float array to set
	 */
	protected void set(float[] array) {
		// Get the length of the shortest (they'll usually be the same)
		int length = data.length < array.length ? data.length : array.length;
		
		// Set the vector's data
		for(int i = 0; i < length; i++)
			data[i] = array[i];
	}
	
	/**
	 * Add to the data of this vector
	 * @param array The float array to add
	 */
	protected void add(float[] array) {
		// Get the length of the shortest (they'll usually be the same)
		int length = data.length < array.length ? data.length : array.length;
		
		// Add the vector's together
		for(int i = 0; i < length; i++)
			data[i] += array[i];
	}
	
	/**
	 * Multiply the data values
	 * @param array The float array to multiply
	 */
	protected void multiply(float[] array) {
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
		for(float f: data)
			string += f + ", ";
		
		// Return the string
		return string;
	}
	
	/**
	 * Get the data stored in the vector
	 * @return Data stored in the vector
	 */
	public float[] getData() {
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
	 * Extract the data out of a Vectorf[] array
	 * @param vector The same data, just as a float[]
	 */
	public static float[] extractData(Vectorf[] vector) {
		// Create an array for our data
		float[] array = new float[vector[0].getSize() * vector.length];
		
		// Index for the loop
		int index = 0;
		
		// For each vector
		for(Vectorf v: vector) {
			// Data in the vector
			float[] d = v.getData();
			
			// Set up the new array
			for(int i = 0; i < vector[0].getSize(); i++) {
				array[index++] = d[i];
			}
		}
		
		// Return the array
		return array;
	}
}
