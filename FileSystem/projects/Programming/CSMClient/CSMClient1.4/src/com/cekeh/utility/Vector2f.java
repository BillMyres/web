// Last edit: 05/13/2018 - TvB
package com.cekeh.utility;

/**
 * Cekeh's Vector2 (float) object
 * Created 04/29/2018
 * @author Thomas vanBommel (TvB)
 */
public class Vector2f extends Vectorf {
	
	/**
	 * Create a new Vector2 (float) with all values set to zero
	 */
	public Vector2f() { super(new float[] { 0, 0 }); }
	
	/**
	 * Create a new Vector2 (float)
	 * @param x The x / r / u / [0] data value / index
	 * @param y The y / g / v / [1] data value / index
	 */
	public Vector2f(float x, float y) { super(new float[] { x, y }); }
	
	/**
	 * Get the value in the x / r / u position
	 * @return The value stored in the x / r / u / [0] position
	 */
	public float x() { return getData()[0]; }
	public float r() { return getData()[0]; }
	public float u() { return getData()[0]; }
	
	/**
	 * Get the value in the y / g / v / [1] position
	 * @return The value stored in the y / g / v / [1] position
	 */
	public float y() { return getData()[1]; }
	public float g() { return getData()[1]; }
	public float v() { return getData()[1]; }
	
	/**
	 * Set the data values in this vector
	 * @param vector The values you wish to set
	 */
	public void set(Vector2f vector) { super.set(vector.getData()); }
	
	/**
	 * Set the data values in this vector
	 * @param x The x / r / u / [0] data value / index
	 * @param y The y / g / v / [1] data value / index
	 */
	public void set(float x, float y) { super.set(new float[] { x, y }); }
	
	/**
	 * Set the x / r / u / [0] value of the vector (will replace current value)
	 * @param value The value you wish to set
	 */
	public void setX(float value) { super.set(0, value); }
	public void setR(float value) {	super.set(0, value); }
	public void setU(float value) {	super.set(0, value); }
	
	/**
	 * Set the y / g / v / [1] value of the vector (will replace current value)
	 * @param value The value you wish to set
	 */
	public void setY(float value) { super.set(1, value); }
	public void setG(float value) { super.set(1, value); }
	public void setV(float value) { super.set(1, value); }
	
	/**
	 * Add to the data values in this vector
	 * @param x The x / r / u / [0] data value / index
	 * @param y The y / g / v / [1] data value / index
	 */
	public void add(float x, float y) { super.add(new float[] { x, y }); }
	
	/**
	 * Add to the data values in this vector
	 * @param vector The vector you wish to add
	 */
	public void add(Vector2f vector) { super.add(vector.getData()); }
	
	/**
	 * Multiply the data values in the vector
	 * @param x The x / r / u / [0] data value / index
	 * @param y The y / g / v / [1] data value / index
	 */
	public void multiply(float x, float y) { super.multiply(new float[] { x, y }); };
	
	/**
	 * Multiply the data values in the vector
	 * @param vector The vector you wish to multiply
	 */
	public void multiply(Vector2f vector) { super.multiply(vector.getData()); }
}
