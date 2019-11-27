// Last edit: 05/07/2018 - TvB
package com.cekeh.opengl;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL13.*;
import static org.lwjgl.opengl.GL30.*;

import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferUShort;
import java.io.IOException;
import java.net.URISyntaxException;

import com.cekeh.utility.ResourceLoader;

/**
 * Cekeh's Texture object
 * Created 04/18/2018
 * @author Thomas vanBommel (TvB)
 */
public class Texture {

	// OpenGL's handle/reference ID
	private int object_handle;
	private final String name;
	
	// The buffered image loaded with our resource loader, which we will use when we initialize
	private final BufferedImage image;
	
	// The image formatted so we can grab the (short[]) pixel colors with getData()
	private final DataBufferUShort buffer;
	
	/**
	 * Create a new texture and load it from a file location, you will need to initialize texture to load it to the graphics card
	 * @param name The name that your uniform sampler will be called in your shader
	 * @param path The file location for the specific image you want starting with "FIRST_FOLDER_NAME/"
	 * @throws IllegalArgumentException Invalid path
	 * @throws IOException IO error has occurred (most likely an invalid path)
	 * @throws InvalidFormatException Image is not of TYPE_USHORT
	 */
	public Texture(String name, String path) throws IllegalArgumentException, IOException, InvalidFormatException {
		// Set the reference name for the texture
		this.name = name;
		
		// Load the buffered image before initialization, since it doesn't require OpenGL
		image = ResourceLoader.loadImage(path);
		
		// Get the generic buffer so we can ensure the correct format
		DataBuffer data = image.getRaster().getDataBuffer();
		
		// Check the image to ensure it's TYPE_USHORT, because I don't know how to use anything else :P
		if(data.getDataType() != DataBuffer.TYPE_USHORT)
			throw new InvalidFormatException("Image with incorrect data type: " + path);
		
		// Get our buffer, this will be use to get the data in an (short[]) array from our image with getData()
		buffer = (DataBufferUShort) data;
	}
	
	/**
	 * Initialize the OpenGL for this texture object and load it to the graphics card
	 */
	public void initialize() {
		// Generate the handle/reference ID
		object_handle = glGenTextures();
		
		// Bind this texture for use
		glBindTexture(GL_TEXTURE_2D, object_handle);
		
		// Add the image to the graphics card
		glTexImage2D(
				GL_TEXTURE_2D, 0,
				GL_RGBA,
				image.getWidth(),
				image.getHeight(), 0,
				GL_RGBA,
				GL_UNSIGNED_SHORT,
				buffer.getData()
		);
		
		// Generate mip maps for texture scaling
		glGenerateMipmap(GL_TEXTURE_2D);
		
		// Set texture parameter to rid of aliasing
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
		
		// Unbind this texture, we are done for now
		glBindTexture(GL_TEXTURE_2D, 0);
	}
	
	/**
	 * Bind this texture for use with a shader
	 * @param slot The texture slot the texture should be placed in, GL_TEXTURE0, GL_TEXTURE1, GL_TEXTURE2, ...
	 */
	public void bind(int slot) {
		// Set the texture slot to place the texture in
		glActiveTexture(slot + 1);
		
		// Bind the texture to that texture slot
		glBindTexture(GL_TEXTURE_2D, object_handle);
	}
	
	/**
	 * Unbind this texture, so you don't accidently use it somewhere else
	 * @param slot The texture slot the texture should be placed in, GL_TEXTURE0, GL_TEXTURE1, GL_TEXTURE2, ...
	 */
	public void unbind(int slot) {
		// Set the texture slot to place the texture in; +1 because GL_TEXTURE0 == NULL == 0
		glActiveTexture(slot + 1);// TODO: test
		
		// Unbind this texture
		glBindTexture(GL_TEXTURE_2D, 0);
	}
	
	/**
	 * Clean up memory resources used by this texture object
	 */
	public void cleanUp() {
		// Delete this texture from memory
		glDeleteTextures(object_handle);
	}
	
	/**
	 * Return the handle/reference ID for this texture
	 * @return The handle/reference ID for this texture
	 */
	public int getHandle() {
		return object_handle;
	}
	
	/**
	 * Return the reference name for this texture
	 * @return The reference name for this texture
	 */
	public String getName() {
		return name;
	}
}
