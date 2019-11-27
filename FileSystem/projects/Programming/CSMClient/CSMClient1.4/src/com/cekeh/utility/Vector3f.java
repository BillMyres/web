// Last edit: 05/13/2018 - TvB
package com.cekeh.utility;

/**
 * Cekeh's Vector3 (float) object
 * Created 04/22/2018
 * @author Thomas vanBommel (TvB)
 */
public class Vector3f extends Vectorf {
	
	/**
	 * Create a new Vector3 (float) with all values set to zero
	 */
	public Vector3f() { super(new float[] { 0, 0, 0 }); }
	
	/**
	 * Create a new Vector3 (float)
	 * @param x The x / r / u / [0] data value / index
	 * @param y The y / g / v / [1] data value / index
	 * @param y The z / b / s / [2] data value / index
	 */
	public Vector3f(float x, float y, float z) { super(new float[] { x, y, z }); }
	
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
	 * Get the value in the z / b / s / [2] position
	 * @return The value stored in the z / b / s / [2] position
	 */
	public float z() { return getData()[2]; }
	public float b() { return getData()[2]; }
	public float s() { return getData()[2]; }
	
	/**
	 * Set the data values in this vector
	 * @param vector The values you wish to set
	 */
	public void set(Vector3f vector) { super.set(vector.getData()); }
	
	/**
	 * Set the data values in this vector
	 * @param x The x / r / u / [0] data value / index
	 * @param y The y / g / v / [1] data value / index
	 * @param y The z / b / s / [2] data value / index
	 */
	public void set(float x, float y, float z) { super.set(new float[] { x, y, z }); }
	
	/**
	 * Set the x / r / u / [0] value of the vector (will replace current value)
	 * @param value The value you wish to set
	 */
	public void setX(float value) {	super.set(0, value); }
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
	 * Set the z / b / s / [2] value of the vector (will replace current value)
	 * @param value The value you wish to set
	 */
	public void setZ(float value) { super.set(2, value); }
	public void setB(float value) { super.set(2, value); }
	public void setS(float value) { super.set(2, value); }

	/**
	 * Add to the data values in this vector
	 * @param x The x / r / u / [0] data value / index
	 * @param y The y / g / v / [1] data value / index
	 * @param y The z / b / w / [2] data value / index
	 */
	public void add(float x, float y, float z) { super.add(new float[] { x, y, z }); }
	
	/**
	 * Add to the data values in this vector
	 * @param vector The vector you wish to add
	 */
	public void add(Vector3f vector) { super.add(vector.getData()); }
	
	/**
	 * Multiply the data values in the vector
	 * @param x The x / r / u / [0] data value / index
	 * @param y The y / g / v / [1] data value / index
	 * @param y The z / b / w / [2] data value / index
	 */
	public void multiply(float x, float y, float z) { super.multiply(new float[] { x, y, z }); };
	
	/**
	 * Multiply the data values in the vector
	 * @param vector The vector you wish to multiply
	 */
	public void multiply(Vector3f vector) { super.multiply(vector.getData()); }
}
