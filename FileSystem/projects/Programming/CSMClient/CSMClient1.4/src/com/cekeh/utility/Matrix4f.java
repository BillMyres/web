// Last edit: 05/10/2018 - TvB
package com.cekeh.utility;

/**
 * Cekeh's Matrix4 (4x4 float[]) object
 * Created 04/23/2018, revised 05/05/2018
 * @author Thomas vanBommel (TvB)
 */
public class Matrix4f {
	
	// Data in the matrix
	public float[][] data = {
		{1f, 0f, 0f, 0f},
		{0f, 1f, 0f, 0f},
		{0f, 0f, 1f, 0f},
		{0f, 0f, 0f, 1f}
	};
	
	/**
	 * Create a new default matrix (equivalent to 1)
	 */
	public Matrix4f() {}
	
	/**
	 * Create a new matrix with specified values
	 * @param data The specified values
	 */
	public Matrix4f(float[][] data) {
		// Set the data values
		this.data = data;
	}
	
	/**
	 * Create a string representing the data
	 */
	public String toString() {
		// String to add our data to
		String string = "";
		
		// Create a string out of the data
		for(float[] row: data)
			string += row[0] + ", " + row[1] + ", " + row[2] + ", " + row[3] + ",\n";
		
		// Return the string we created
		return string;
	}
	
	/**
	 * Scale the matrix in 3D space (on the origin)
	 * @param x X scale
	 * @param y Y scale
	 * @param z Z scale
	 * @return This object for further tampering
	 */
	public Matrix4f scale(float x, float y, float z) {
		// Scale the matrix
		data[0][0] *= x;
		data[1][1] *= y;
		data[2][2] *= z;
		
		// Return this matrix object, for further tampering
		return this;
	}
	
	/**
	 * Rotate the matrix in 3D space (on the origin)
	 * @param x X rotation
	 * @param y Y rotation
	 * @param z Z rotation
	 * @return This object for whatever you need it for
	 */
	public Matrix4f rotate(float x, float y, float z) {
		// Matrix for each rotation
		Matrix4f x_rotation = new Matrix4f();
		Matrix4f y_rotation = new Matrix4f();
		Matrix4f z_rotation = new Matrix4f();
		
		// Set x rotation data
		x_rotation.data[1][1] = (float) Math.cos(x);
		x_rotation.data[1][2] = (float)-Math.sin(x);
		x_rotation.data[2][1] = (float) Math.sin(x);
		x_rotation.data[2][2] = (float) Math.cos(x);
		
		// Set y rotation data
		y_rotation.data[0][0] = (float) Math.cos(y);
		y_rotation.data[0][2] = (float) Math.sin(y);
		y_rotation.data[2][0] = (float)-Math.sin(y);
		y_rotation.data[2][2] = (float) Math.cos(y);
		
		// Set z rotation data
		z_rotation.data[0][0] = (float) Math.cos(z);
		z_rotation.data[0][1] = (float)-Math.sin(z);
		z_rotation.data[1][0] = (float) Math.sin(z);
		z_rotation.data[1][1] = (float) Math.cos(z);
		
		// Rotate the data matrix by all 3 axis
		multiply(x_rotation.data);
		multiply(y_rotation.data);
		multiply(z_rotation.data);
		
		// Return this matrix object, for further tampering
		return this;
	}
	
	/**
	 * Translate the matrix in 3D space
	 * @param x Distance on the x axis
	 * @param y Distance on the y axis
	 * @param z Distance on the z axis
	 * @return This object
	 */
	public Matrix4f translate(float x, float y, float z) {
		// Translate the matrix
		data[0][3] += x;
		data[1][3] += y;
		data[2][3] += z;
		
		// Return this
		return this;
	}
	
	/**
	 * Multiply this matrix by another
	 * @param matrix The matrix you want to multiply with
	 * @return This object
	 */
	public Matrix4f multiply(float[][] matrix) {
		// For each data value
		for(int row = 0; row < 4; row++) {
			for(int column = 0; column < 4; column++) {	
				// Value to be set
				float value = 0;
				
				// Another for loop to make math easier
				for(int x = 0; x < 4; x++) {
					value += data[row][x] * matrix[x][column];
				}
				
				// Set the data in this matrix to the new value of [row][column]
				data[row][column] = value;
			}
		}
		
		// Return this object
		return this;
	}
	
	/**
	 * Multiply this matrix by another
	 * @param matrix The matrix you want to multiply with
	 * @return This object
	 */
	public Matrix4f multiply(Matrix4f matrix) {
		// Call the other method
		return multiply(matrix.data);
	}
	
	/**
	 * Get the matrix as a single dimensional array
	 * @return The matrix as a single dimensional array
	 */
	public float[] getRaw() {
		// The matrix we'll return
		float[] matrix = new float[16];
		
		// For each float in the data matrix
		for(int y = 0; y < 4; y++) {
			for(int x = 0; x < 4; x++) {
				// Get the index for the single dimensional array
				int index = (y * 4) + x;
				
				// Set our new matrix
				matrix[index] = data[x][y];
			}
		}
		
		// Return the matrix we made
		return matrix;
	}
}
