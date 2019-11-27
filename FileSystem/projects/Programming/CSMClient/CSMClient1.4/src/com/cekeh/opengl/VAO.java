// Last edit: 05/17/2018 - TvB
package com.cekeh.opengl;

import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL30.*;

/**
 * Cekeh's Vertex array object class
 * Created 04/15/2018
 * @author Thomas vanBommel (TvB)
 */
public abstract class VAO {

	// OpenGL handle/reference ID
	private int object_handle;
	
	// VBO's / Attributes
	private final VBOf vertex;
	
	// VBO's (vertex buffer objects) to attach to this VAO (vertex array object)
	private final VBOi index;
	
	// The shader we'll render the VBO with
	//private final ShaderProgram shader;

	/**
	 * Create a new VAO (vertex array object) with specified vertex_data (position, UV/ST, color, etc...) and index_data (triangles/indices)
	 * @param vertex_data Float[] data representing all vertex data (position, texcoord/UV/ST, color, etc...)
	 * @param index_data Int[] data representing the triangles/indices of the model
	 */
	protected VAO(VBOf vertex, VBOi index, ShaderProgram shader) {
		// Set up our data for initialization
		this.vertex = vertex;
		this.index = index;
		//this.shader = shader;
	}
	
	public void initialize() throws OpenGLException {
		// Set the object's handle/reference ID
		object_handle = glGenVertexArrays();
			
		// Bind this VAO because we're going to add some data
		bind();
		
		// Initialize attributes
		vertex.initialize();
		index.initialize();
		
		// Finished adding data to the VBO
		unbind();
		
		// Initialize shader
		//shader.initialize();
	}
	
	/**
	 * Bind the VAO (vertex array object) for use
	 */
	public void bind() {
		// Bind the VAO
		glBindVertexArray(object_handle);
	}
	
	/**
	 * Unbind the VAO (vertex array object), so you don't accidently use it somewhere else
	 */
	public void unbind() {
		// Unbind the VAO
		glBindVertexArray(0);
	}
	
	/**
	 * Render this object to the screen
	 */
	public void render() {
		// Bind the shader for use
		//shader.bind();
		
		// Bind this VAO for use
		bind();
				
		// Enable attributes
		glEnableVertexAttribArray(0);
		
		// Enable all attributes
		vertex.bind();
		
		// Render the VAO/model with triangles from the indexData
		index.draw();
		
		// Disable all attributes
		vertex.unbind();
		
		// Disable attributes
		glDisableVertexAttribArray(0);
		
		// Unbind this VAO
		unbind();
		
		// Unbind the shader
		//shader.unbind();
	}
	
	/**
	 * Clean up the memory resources used by this object
	 */
	public void cleanUp() {
		// Clean up the buffer attributes
		vertex.cleanUp();
		index.cleanUp();
		
		// Delete this object from GPU memory
		glDeleteVertexArrays(object_handle);
		
		// Clean up the shader
		//shader.cleanUp();
	}
}
