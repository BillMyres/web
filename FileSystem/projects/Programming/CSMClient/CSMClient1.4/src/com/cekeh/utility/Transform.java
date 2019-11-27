// Last edit: 05/11/2018 - TvB
package com.cekeh.utility;

/**
 * Cekeh's Transform object
 * Created 04/22/2018, revised 05/05/2018
 * @author Thomas vanBommel (TvB)
 */
public class Transform {
	
	// The components that make up any position in space
	public Vector3f scale = new Vector3f(1, 1, 1);
	public Vector3f rotation = new Vector3f(0, 0, 0);
	public Vector3f position = new Vector3f(0, 0, 0);
	
	/**
	 * Create a new default transform with position and rotation zero'd out and scale of 1
	 */
	public Transform() {}
	
	/**
	 * Scale this transform in 3D space
	 * @param x Scale in the x axis
	 * @param y Scale in the y axis
	 * @param z Scale in the z axis
	 * @return This object for extra transformations
	 */
	public Transform scale(float x, float y, float z) {
		// Adjust rotation
		scale.multiply(x, y, z);
		
		// Return this object for more transformations
		return this;
	}
	
	/**
	 * Scale the transform in 3D space
	 * @param vector Scale on all axis
	 * @return This object
	 */
	public Transform scale(Vector3f vector) {
		// Call other method
		return scale(vector.x(), vector.y(), vector.z());
	}
	
	/**
	 * Rotate this transform in 3D space
	 * @param x Rotation in the x axis
	 * @param y Rotation in the y axis
	 * @param z Rotation in the z axis
	 * @return This object for extra transformations
	 */
	public Transform rotate(float x, float y, float z) {
		// Adjust rotation
		rotation.add(x, y, z);
		
		// Return this object for more transformations
		return this;
	}
	
	/**
	 * Rotate this transform in 3D space
	 * @param vector Rotation on all axis
	 * @return This object
	 */
	public Transform rotate(Vector3f vector) {
		// Call the other method
		return rotate(vector.x(), vector.y(), vector.z());
	}
	
	/**
	 * Translate this transform in 3D space
	 * @param x Position to translate in the x axis
	 * @param y Position to translate in the y axis
	 * @param z Position to translate in the z axis
	 * @return This object for extra transformations
	 */
	public Transform translate(float x, float y, float z) {
		// Adjust position
		position.add(x, y, z);
		
		// Return this object for extra transformations
		return this;
	}
	
	/**
	 * Translate this transform in 3D space
	 * @param vector Position to translate on all axis
	 * @return This object for more transformations
	 */
	public Transform translate(Vector3f vector) {
		// Return the other method
		return translate(vector.x(), vector.y(), vector.z());
	}
	
	public Matrix4f getTransformationMatrix() {
		// Transformation matrix we will be creating
		Matrix4f transformation_matrix = new Matrix4f();
		
		// Matrices that make up the transformation matrix (order DOES matter)
		transformation_matrix.multiply(new Matrix4f().scale(scale.x(), scale.y(), scale.z()));
		transformation_matrix.multiply(new Matrix4f().rotate(rotation.x(), rotation.y(), rotation.z()));
		transformation_matrix.multiply(new Matrix4f().translate(position.x(), position.y(), position.z()));
		
		// Return the matrix we created
		return transformation_matrix;
	}
}
