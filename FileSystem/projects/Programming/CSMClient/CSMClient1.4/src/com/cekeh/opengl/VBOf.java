// Last edit: 05/17/2018 - TvB
package com.cekeh.opengl;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL20.*;

import com.cekeh.utility.Vectorf;

/**
 * Cekeh's VBOf object
 * Created 05/12/2018
 * @author Thomas vanBommel (TvB)
 */
public class VBOf {
	
	// Index of this VBO
	private final int index;
	
	// The name of this specific VBO
	private final String name;
	
	// The handle / index of the VBO
	private int handle;
	
	// Data for the VBO
	private Vectorf[] data;
	
	// Data type for the VBO
	private final int target;
	
	public VBOf(String name, Vectorf[] data, int target, int index) {
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
		
		// Set the attribute pointer
		glVertexAttribPointer(0, data[0].getSize(), GL_FLOAT, false, 0, 0);
		glEnableVertexAttribArray(0);
		
		// Set buffer data
		glBufferData(target, Vectorf.extractData(data), GL_STATIC_DRAW);
		
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
	 * Clean up any memory resources used by this buffer object
	 */
	public void cleanUp() {
		glDeleteBuffers(handle);
	}
}
