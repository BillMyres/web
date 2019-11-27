// Last edit: 05/17/2018 - TvB
package com.cekeh.models;

import org.lwjgl.opengl.GL15;

import com.cekeh.opengl.VBOf;
import com.cekeh.opengl.VBOi;
import com.cekeh.shaders.ColorShader;
import com.cekeh.utility.Vector3f;
import com.cekeh.utility.Vector3i;

/**
 * Cekeh's Quad VAO/model
 * Created 04/15/2018
 * @author Thomas vanBommel (TvB)
 */
public class Quad extends Model{

	private final static Vector3f[] vertex_data = {
			new Vector3f(-1,  1, 0.1f), // [0] Top-left
			new Vector3f( 1,  1, 0.1f), // [1] Top-right
			new Vector3f( 1, -1, 0.1f), // [2] Bottom-right
			new Vector3f(-1, -1, 0.1f)  // [3] Bottom-left
	};
	
	// Index data for the quad
	private final static Vector3i[] index_data = {
		new Vector3i(0, 1, 2),
		new Vector3i(2, 3, 0)
	};
	
	public static ColorShader shader;
	
	/**
	 * Create a new Quad model object
	 * @throws Exception Something went wrong during initialization
	 */
	public Quad() throws Exception {
		// Create the new VAO with our quad data
		super(new VBOf("position", vertex_data, GL15.GL_ARRAY_BUFFER, 0), new VBOi("index", index_data, GL15.GL_ELEMENT_ARRAY_BUFFER, 0), shader = new ColorShader(1, 1, 0, 1));
	
		getTransform().translate(0, 0, -1);
	}
}
