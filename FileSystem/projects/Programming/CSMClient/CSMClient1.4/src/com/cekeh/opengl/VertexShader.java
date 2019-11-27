// Last edit: 04/16/2018 - TvB
package com.cekeh.opengl;

import static org.lwjgl.opengl.GL20.*;

/**
 * Cekeh's Vertex Shader
 * Created 04/16/2018
 * @author Thomas vanBommel (TvB)
 */
public class VertexShader extends Shader{

	/**
	 * Create a new vertex shader for use in a ShaderProgram
	 * @param source The code of the vertex shader in a String
	 * @throws OpenGLException Unable to compile shader
	 */
	public VertexShader(String source) throws OpenGLException {
		super(source, GL_VERTEX_SHADER);
	}
}
