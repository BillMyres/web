// Last edit: 05/13/2018 - TvB
package com.cekeh.opengl;

import static org.lwjgl.opengl.GL13.*;
import static org.lwjgl.opengl.GL20.*;

import com.cekeh.main.Client;
import com.cekeh.utility.Matrix4f;
import com.cekeh.utility.Vector4f;

/**
 * Cekeh's Shader Program class
 * Created 04/16/2018
 * @author Thomas vanBommel (TvB)
 */
public abstract class ShaderProgram {
	
	// OpenGL's handle/reference ID
	private int program_handle;
	
	// Shader's to be attached to the shader program
	private final VertexShader vertex;
	private final FragmentShader fragment;
	
	// Textures to be bound to this shader program
	private final Texture[] textures;
	
	/**
	 * Create a new shader program
	 * @param vertex The GLSL vertex shader to be attached to the shader program
	 * @param fragment The GLSL fragment shader to be attached to the shader program
	 * @param textures Array of texture to be bound to the shader program with GL_TEXTURE0, GL_TEXTURE1, GL_TEXTURE2, ... null for no images
	 */
	protected ShaderProgram(VertexShader vertex, FragmentShader fragment, Texture[] textures) {
		// Set the shader's to be attached to our shader program
		this.vertex = vertex;
		this.fragment = fragment;
		this.textures = textures;
	}
	
	/**
	 * Initialize the shader program with OpenGL
	 * @throws OpenGLException Unable to link the shader's to the shader program 
	 * @throws OpenGLException Unable to validate the shader program
	 */
	public void initialize() throws OpenGLException {
		// Initialize shader's
		vertex.initialize();
		fragment.initialize();
		
		// Create the handle/reference ID for this shader program object
		program_handle = glCreateProgram();
		
		System.out.println("ShaderProgram.java: " + program_handle);
		
		// Attach the shader's to the shader program
		glAttachShader(program_handle, vertex.getHandle());
		glAttachShader(program_handle, fragment.getHandle());
		
		// Bind the attributes unique to the shader program
		bindAttributes();
		
		// Link the program
		glLinkProgram(program_handle);
		
		// Check link status
		if(glGetProgrami(program_handle, GL_LINK_STATUS) != 1)
			throw new OpenGLException("Unable to link shader to shader program:\n(" + glGetProgramInfoLog(program_handle) + ")");
	
		// Validate program
		glValidateProgram(program_handle);
		
		// Check validation status
		if(glGetProgrami(program_handle, GL_VALIDATE_STATUS) != 1)
			throw new OpenGLException("Unable to validate shader program:\n" + glGetProgramInfoLog(program_handle));
	
		// Only want to do this if there are textures to add to the shader 
		if(textures != null) {
			// Initialize textures
			for(Texture texture: textures) {
				texture.initialize();
				
				// Find where the uniform sampler is in the shader
				int location = glGetUniformLocation(program_handle, texture.getName());
				
				// Set the texture handle/reference ID to that uniform sampler (shouldn't matter if the location is null, just won't be able to use it in the shader)
				glUniform1i(location, texture.getHandle());
			}
		}
	}
	
	/**
	 * Bind all attributes in the shader program
	 */
	protected abstract void bindAttributes();
	
	/**
	 * Bind an attribute to a location (index)
	 * @param index The index of the attribute (position is usually 0)
	 * @param name The name of the attribute
	 */
	protected void bindAttribute(int index, String name) {
		// Bind the attribute location
		glBindAttribLocation(program_handle, index, name);
	}
	
	/**
	 * Bind this shader program for use
	 */
	public void bind() {
		// Bind this program for use
		glUseProgram(program_handle);
		
		// Bind textures to their texture slots
		if(textures != null)
			for(int i = 0; i < textures.length; i++) 
				textures[i].bind(GL_TEXTURE0 + i);
		
		
	}
	
	/**
	 * Unbind this shader program, so not to accidently use it else where
	 */
	public void unbind() {		
		// Unbind textures
		if(textures != null)
			for(int i = 0; i < textures.length; i++)
				textures[i].unbind(GL_TEXTURE0 + i);
		
		// Unbind this program
		glUseProgram(0);
	}
	
	/**
	 * Get the handle / reference ID for a specified uniform variable in this shader
	 * @param name The specific name of the uniform variables
	 * @return The handle / reference ID for the location of the specified uniform
	 */
	private int getUniformLocation(String name) {
		// Bind this program for use
		glUseProgram(program_handle);
				
		// Return the uniforms location handle / reference ID
		return glGetUniformLocation(program_handle, name);
	}
	
	/**
	 * Set a uniform float in this shader
	 * @param name The exact name of the uniform variable in the shader source
	 * @param data The specified float to be stored in the specified location (name)
	 */
	public void setUniform1f(String name, float data) {
		// Set the data
		glUniform1f(getUniformLocation(name), data);
		
		// Unbind this program
		glUseProgram(0);
	}
	
	/**
	 * Set a specified uniform variable in the shader
	 * @param name The specific name for the uniform
	 * @param x Data for the x / r / u / [0] slot
	 * @param y Data for the y / g / v / [1] slot
	 * @param z Data for the z / b / s / [2] slot
	 * @param w Data for the w / w / t / [3] slot
	 */
	public void setUniform4f(String name, float x, float y, float z, float w) {
		// Set the data
		glUniform4f(getUniformLocation(name), x, y, z, w);
		
		// Unbind the program
		glUseProgram(0);
	}
	
	/**
	 * Set a specified uniform variable in the shader
	 * @param name The specific name for the uniform
	 * @param data The specified float to be stored in the specified location (name)
	 */
	public void setUniform4fv(String name, Vector4f data) {
		// Set the data
		glUniform4fv(getUniformLocation(name), data.getData());
		
		// Unbind the program
		glUseProgram(0);
	}
	
	/**
	 * Set a uniform 4x4 matrix in a shader (like matrices)
	 * @param name The exact name of the uniform variable in the shader source
	 * @param data A specified Matrix4 (4x4 float[])
	 * @throws InvalidFormatException Invalid matrix format error
	 */
	public void setUniformMatrix4fv(String name, Matrix4f data) throws InvalidFormatException {
		// Get the location for the uniform we are going to modify
		int location = getUniformLocation(name);
		
		// Set the data
		glUniformMatrix4fv(location, false, data.getRaw());
		
		// Unbind this program
		glUseProgram(0);
	}
	
	/**
	 * Clean up the memory resources used by this object
	 */
	public void cleanUp() {
		// Detach the shader's from the shader program
		glDetachShader(program_handle, vertex.getHandle());
		glDetachShader(program_handle, fragment.getHandle());
		
		// Clean up the shader's
		vertex.cleanUp();
		fragment.cleanUp();
		
		// Delete this program
		glDeleteProgram(program_handle);
		
		// Clean up textures
		if(textures != null)
			for(Texture texture: textures)
				texture.cleanUp();
	}
	
	/**
	 * Get the handle/reference ID for this shader program
	 * @return
	 */
	public int getHandle() {
		return program_handle;
	}
}
