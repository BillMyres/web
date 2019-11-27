// Last edit: 05/07/2018 - TvB
package com.cekeh.opengl;

import static org.lwjgl.opengl.GL20.*;

/**
 * Cekeh's Shader object class
 * Created 04/16/2018
 * @author Thomas vanBommel (TvB)
 */
public abstract class Shader {

	// OpenGL's handle/reference ID
	private int object_handle;
	
	// Data for initialization and clean up
	private final String source;
	private final int type;
	
	/**
	 * Create a new shader, for use with a ShaderProgram
	 * @param source The code for the GLSL shader in a String
	 * @param type The type of the shader, one of: GL_VERTEX_SHADER, GL_FRAGMENT_SHADER
	 */
	protected Shader(String source, int type) {
		// Set the data for initialization and clean up
		this.source = source;
		this.type = type;
	}
	
	/**
	 * Initialize with OpenGL, stores the shader information on the graphics card
	 * @throws OpenGLException Unable to compile shader
	 */
	public void initialize() throws OpenGLException {
		// Set OpenGL's handle/reference ID
		object_handle = glCreateShader(type);
		
		System.out.println("Shader.java: " + object_handle);
		
		// Set the source of the shader
		glShaderSource(object_handle, source);
		
		// Compile the GLSL shader program
		glCompileShader(object_handle);
		
		// Check to see if the shader compiled without problems
		if(glGetShaderi(object_handle, GL_COMPILE_STATUS) != 1)
			throw new OpenGLException("Unable to compile shader\n" + glGetShaderInfoLog(object_handle));
	}
	
	/**
	 * Clean up the memory resources used by this object
	 */
	public void cleanUp() {
		// Delete the shader source from memory
		glDeleteShader(object_handle);
	}
	
	/**
	 * Get the shader's OpenGL handle/reference ID
	 * @return The object's OpenGL handle/reference ID
	 */
	public int getHandle() {
		// Return the object's OpenGL handle/reference ID
		return object_handle;
	}
}
