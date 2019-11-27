// Last edit: 04/16/2018 - TvB
package com.cekeh.opengl;

import static org.lwjgl.opengl.GL20.*;

/**
 * Cekeh's Fragment Shader
 * Created 04/16/2018
 * @author Thomas vanBommel (TvB)
 */
public class FragmentShader extends Shader{

	/**
	 * Create a new fragment shader for use in a ShaderProgram
	 * @param source The code of the fragment shader in a String
	 * @throws OpenGLException Unable to compile shader
	 */
	public FragmentShader(String source) throws OpenGLException {
		super(source, GL_FRAGMENT_SHADER);
	}
}
