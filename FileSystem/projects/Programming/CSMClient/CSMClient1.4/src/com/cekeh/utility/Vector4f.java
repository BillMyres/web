// Last edit: 05/13/2018 - TvB
package com.cekeh.utility;

/**
 * Cekeh's Vector4 (float) object
 * Created 05/12/2018
 * @author Thomas vanBommel (TvB)
 */
public class Vector4f extends Vectorf {

	/**
	 * Create a new Vector4 (float) with all values set to zero
	 */
	public Vector4f() { super(new float[] { 0, 0, 0, 0 }); }
	
	/**
	 * Create a new Vector4 (float)
	 * @param x The x / r / u / [0] data value / index
	 * @param y The y / g / v / [1] data value / index
	 * @param y The z / b / s / [2] data value / index
	 * @param y The w / a / t / [3] data value / index
	 */
	public Vector4f(float x, float y, float z, float w) { super(new float[] { x, y, z, w }); }
	
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
	 * Get the value in the w / a / t / [3] position
	 * @return The value stored in the w / a / t / [3] position
	 */
	public float w() { return getData()[3]; }
	public float a() { return getData()[3]; }
	public float t() { return getData()[3]; }
	
	/**
	 * Set the data values in this vector
	 * @param vector The values you wish to set
	 */
	public void set(Vector4f vector) { super.set(vector.getData()); }
	
	/**
	 * Set the data values in this vector
	 * @param x The x / r / u / [0] data value / index
	 * @param y The y / g / v / [1] data value / index
	 * @param y The z / b / s / [2] data value / index
	 * @param w The w / a / t / [3] data value / index
	 */
	public void set(float x, float y, float z, float w) { super.set(new float[] { x, y, z, w }); }
	
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
	 * Set the w / a / t / [3] value of the vector (will replace current value)
	 * @param value The value you wish to set
	 */
	public void setW(float value) { super.set(3, value); }
	public void setA(float value) { super.set(3, value); }
	public void setT(float value) { super.set(3, value); }

	/**
	 * Add to the data values in this vector
	 * @param x The x / r / u / [0] data value / index
	 * @param y The y / g / v / [1] data value / index
	 * @param y The z / b / w / [2] data value / index
	 * @param w The w / a / a / [3] data value / index
	 */
	public void add(float x, float y, float z, float w) { super.add(new float[] { x, y, z, w }); }
	
	/**
	 * Add to the data values in this vector
	 * @param vector The vector you wish to add
	 */
	public void add(Vector4f vector) { super.add(vector.getData()); }
	
	/**
	 * Multiply the data values in the vector
	 * @param x The x / r / u / [0] data value / index
	 * @param y The y / g / v / [1] data value / index
	 * @param y The z / b / w / [2] data value / index
	 * @param w The w / a / a / [3] data value / index
	 */
	public void multiply(float x, float y, float z, float w) { super.multiply(new float[] { x, y, z, w }); };
	
	/**
	 * Multiply the data values in the vector
	 * @param vector The vector you wish to multiply
	 */
	public void multiply(Vector4f vector) { super.multiply(vector.getData()); }
}
