// Last edit: 05/17/2018 - TvB
package com.cekeh.opengl;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL20.*;

import com.cekeh.utility.Vectori;

/**
 * Cekeh's VBOi object
 * Created 05/13/2018
 * @author Thomas vanBommel (TvB)
 */
public class VBOi {
	
	// Index of this VBO
	private final int index;
	
	// The name of this specific VBO
	private final String name;
	
	// The handle / index of the VBO
	private int handle;
	
	// Data for the VBO
	private Vectori[] data;
	
	// Data type for the VBO
	private final int target;
	
	public VBOi(String name, Vectori[] data, int target, int index) {
		// Set the index of this VBO
		this.index = index;
		
		// Set the data values
		this.name = name;
		this.data = data;
		this.target = target;
	}
	
	public void initialize() {
		// Create the handle / reference ID
		handle = glGenBuffers();
		
		// Bind the buffer to the target
		glBindBuffer(target, handle);
		
		// Set buffer data
		glBufferData(target, Vectori.extractData(data), GL_STATIC_DRAW);
		
		// Unbind the buffer
		glBindBuffer(target, 0);
	}
	
	/**
	 * Bind this Attribute (VBO) for use
	 */
	public void bind() {
		// Bind the VBO for use
		glBindBuffer(target, handle);
	}
	
	/**
	 * Unbind this Attribute (VBO)
	 */
	public void unbind() {
		// Unbind the VBO
		glBindBuffer(target, 0);
	}
	
	/**
	 * Draw openGL indices 
	 */
	public void draw() {
		// Bind the index VBO
		bind();
		
		// Draw elements
		glDrawElements(GL_TRIANGLES, data[0].getSize() * data.length, GL_UNSIGNED_INT, handle);
	
		// Unbind the index VBO
		unbind();
	}
	
	/**
	 * Clean up any memory resources used by this buffer object
	 */
	public void cleanUp() {
		glDeleteBuffers(handle);
	}
}
