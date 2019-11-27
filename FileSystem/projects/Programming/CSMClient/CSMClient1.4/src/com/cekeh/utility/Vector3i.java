// Last edit: 05/13/2018 - TvB
package com.cekeh.utility;

/**
 * Cekeh's Vector3 (int) object
 * Created 05/13/2018
 * @author Thomas vanBommel (TvB)
 */
public class Vector3i extends Vectori {
	
	/**
	 * Create a new Vector3 (int) with all values set to zero
	 */
	public Vector3i() { super(new int[] { 0, 0, 0 }); }
	
	/**
	 * Create a new Vector3 (int)
	 * @param x The x / r / u / [0] data value / index
	 * @param y The y / g / v / [1] data value / index
	 * @param y The z / b / s / [2] data value / index
	 */
	public Vector3i(int x, int y, int z) { super(new int[] { x, y, z }); }
	
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
	 * Set the data values in this vector
	 * @param vector The values you wish to set
	 */
	public void set(Vector3i vector) { super.set(vector.getData()); }
	
	/**
	 * Set the data values in this vector
	 * @param x The x / r / u / [0] data value / index
	 * @param y The y / g / v / [1] data value / index
	 * @param y The z / b / s / [2] data value / index
	 */
	public void set(int x, int y, int z) { super.set(new int[] { x, y, z }); }
	
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
	 * Add to the data values in this vector
	 * @param x The x / r / u / [0] data value / index
	 * @param y The y / g / v / [1] data value / index
	 * @param y The z / b / w / [2] data value / index
	 */
	public void add(int x, int y, int z) { super.add(new int[] { x, y, z }); }
	
	/**
	 * Add to the data values in this vector
	 * @param vector The vector you wish to add
	 */
	public void add(Vector3i vector) { super.add(vector.getData()); }
	
	/**
	 * Multiply the data values in the vector
	 * @param x The x / r / u / [0] data value / index
	 * @param y The y / g / v / [1] data value / index
	 * @param y The z / b / w / [2] data value / index
	 */
	public void multiply(int x, int y, int z) { super.multiply(new int[] { x, y, z }); };
	
	/**
	 * Multiply the data values in the vector
	 * @param vector The vector you wish to multiply
	 */
	public void multiply(Vector3i vector) { super.multiply(vector.getData()); }
}
