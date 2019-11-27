// Last edit: 05/13/2018 - TvB
package com.cekeh.utility;

/**
 * Cekeh's Vector4 (int) object
 * Created 05/13/2018
 * @author Thomas vanBommel (TvB)
 */
public class Vector4i extends Vectori {

	/**
	 * Create a new Vector4 (int) with all values set to zero
	 */
	public Vector4i() { super(new int[] { 0, 0, 0, 0 }); }
	
	/**
	 * Create a new Vector4 (int)
	 * @param x The x / r / u / [0] data value / index
	 * @param y The y / g / v / [1] data value / index
	 * @param y The z / b / s / [2] data value / index
	 * @param y The w / a / t / [3] data value / index
	 */
	public Vector4i(int x, int y, int z, int w) { super(new int[] { x, y, z, w }); }
	
	/**
	 * Get the value in the x / r / u position
	 * @return The value stored in the x / r / u / [0] position
	 */
	public int x() { return getData()[0]; }
	public int r() { return getData()[0]; }
	public int u() { return getData()[0]; }
	
	/**
	 * Get the value in the y / g / v / [1] position
	 * @return The value stored in the y / g / v / [1] position
	 */
	public int y() { return getData()[1]; }
	public int g() { return getData()[1]; }
	public int v() { return getData()[1]; }
	
	/**
	 * Get the value in the z / b / s / [2] position
	 * @return The value stored in the z / b / s / [2] position
	 */
	public int z() { return getData()[2]; }
	public int b() { return getData()[2]; }
	public int s() { return getData()[2]; }
	
	/**
	 * Get the value in the w / a / t / [3] position
	 * @return The value stored in the w / a / t / [3] position
	 */
	public int w() { return getData()[3]; }
	public int a() { return getData()[3]; }
	public int t() { return getData()[3]; }
	
	/**
	 * Set the data values in this vector
	 * @param vector The values you wish to set
	 */
	public void set(Vector4i vector) { super.set(vector.getData()); }
	
	/**
	 * Set the data values in this vector
	 * @param x The x / r / u / [0] data value / index
	 * @param y The y / g / v / [1] data value / index
	 * @param y The z / b / s / [2] data value / index
	 * @param w The w / a / t / [3] data value / index
	 */
	public void set(int x, int y, int z, int w) { super.set(new int[] { x, y, z, w }); }
	
	/**
	 * Set the x / r / u / [0] value of the vector (will replace current value)
	 * @param value The value you wish to set
	 */
	public void setX(int value) {	super.set(0, value); }
	public void setR(int value) {	super.set(0, value); }
	public void setU(int value) {	super.set(0, value); }
	
	/**
	 * Set the y / g / v / [1] value of the vector (will replace current value)
	 * @param value The value you wish to set
	 */
	public void setY(int value) { super.set(1, value); }
	public void setG(int value) { super.set(1, value); }
	public void setV(int value) { super.set(1, value); }
	
	/**
	 * Set the z / b / s / [2] value of the vector (will replace current value)
	 * @param value The value you wish to set
	 */
	public void setZ(int value) { super.set(2, value); }
	public void setB(int value) { super.set(2, value); }
	public void setS(int value) { super.set(2, value); }
	
	/**
	 * Set the w / a / t / [3] value of the vector (will replace current value)
	 * @param value The value you wish to set
	 */
	public void setW(int value) { super.set(3, value); }
	public void setA(int value) { super.set(3, value); }
	public void setT(int value) { super.set(3, value); }

	/**
	 * Add to the data values in this vector
	 * @param x The x / r / u / [0] data value / index
	 * @param y The y / g / v / [1] data value / index
	 * @param y The z / b / w / [2] data value / index
	 * @param w The w / a / a / [3] data value / index
	 */
	public void add(int x, int y, int z, int w) { super.add(new int[] { x, y, z, w }); }
	
	/**
	 * Add to the data values in this vector
	 * @param vector The vector you wish to add
	 */
	public void add(Vector4i vector) { super.add(vector.getData()); }
	
	/**
	 * Multiply the data values in the vector
	 * @param x The x / r / u / [0] data value / index
	 * @param y The y / g / v / [1] data value / index
	 * @param y The z / b / w / [2] data value / index
	 * @param w The w / a / a / [3] data value / index
	 */
	public void multiply(int x, int y, int z, int w) { super.multiply(new int[] { x, y, z, w }); };
	
	/**
	 * Multiply the data values in the vector
	 * @param vector The vector you wish to multiply
	 */
	public void multiply(Vector4i vector) { super.multiply(vector.getData()); }
}
