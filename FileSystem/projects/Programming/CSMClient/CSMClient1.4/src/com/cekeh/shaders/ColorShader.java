// Last edit: 05/12/2018 - TvB
package com.cekeh.shaders;

import com.cekeh.opengl.FragmentShader;
import com.cekeh.opengl.OpenGLException;
import com.cekeh.opengl.ShaderProgram;
import com.cekeh.opengl.VertexShader;
import com.cekeh.utility.ResourceLoader;
import com.cekeh.utility.Vector4f;

/**
 * Cekeh's Color Shader
 * Created 04/16/2018
 * @author Thomas vanBommel (TvB)
 */
public class ColorShader extends ShaderProgram {
	
	private Vector4f rgba = new Vector4f(0.5f, 1f, 0.25f, 1);
	
	/**
	 * Create a new colored shader to make your VAO look that much better
	 * @throws Exception Something went wrong during initialization
	 */
	// TODO: Java-Doc
	public ColorShader(float red, float green, float blue, float alpha) throws Exception {
		super(
			new VertexShader(ResourceLoader.loadPlainText("com/cekeh/shaders/ColorShader.vs")),
			new FragmentShader(ResourceLoader.loadPlainText("com/cekeh/shaders/ColorShader.fs")),
			null
		);
		
		rgba = new Vector4f(red, green, blue, alpha);
	}
	
	@Override
	public void initialize() throws OpenGLException {
		// Initialize the shader program
		super.initialize();
		
		// Set the main_color of the shader
		setUniform4fv("main_color", rgba);
	}

	@Override
	protected void bindAttributes() {
		// Bind the position attribute
		super.bindAttribute(0, "position");
	}
}
