// Last edit: 05/14/2018 - TvB
package com.cekeh.shaders;

import com.cekeh.opengl.FragmentShader;
import com.cekeh.opengl.ShaderProgram;
import com.cekeh.opengl.VertexShader;
import com.cekeh.utility.ResourceLoader;

/**
 * Cekeh's Color Shader
 * Created 05/14/2018
 * @author Thomas vanBommel (TvB)
 */
public class DebugShader extends ShaderProgram{

	public DebugShader() throws Exception {
		super(
			new VertexShader(ResourceLoader.loadPlainText("com/cekeh/shaders/DebugShader.vs")),
			new FragmentShader(ResourceLoader.loadPlainText("com/cekeh/shaders/DebugShader.fs")),
			null
		);
	}

	@Override
	protected void bindAttributes() {
		// Bind the position attribute
		super.bindAttribute(0, "position");
	}
}
