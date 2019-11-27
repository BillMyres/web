// Last edit: 05/17/2018 - TvB
package com.cekeh.models;

import org.lwjgl.opengl.GL15;

import com.cekeh.opengl.VBOf;
import com.cekeh.opengl.VBOi;
import com.cekeh.shaders.DebugShader;
import com.cekeh.utility.Vector3f;
import com.cekeh.utility.Vector3i;

/**
 * Cekeh's Grid VAO/model
 * Created 05/06/2018
 * @author Thomas vanBommel (TvB)
 */
public class Grid extends Model{

	private final static Vector3f[] vertex_data = {
			new Vector3f(-1, 0,  1), // [0] Front-left
			new Vector3f( 1, 0,  1), // [1] Front-right
			new Vector3f( 1, 0, -1), // [2] Back-right
			new Vector3f(-1, 0, -1)  // [3] Back-left
	};
	
	private final static Vector3f[] vertex_data_debug = {
			new Vector3f( 0,  0, 0), // [0] Top-left
			new Vector3f( 1,  0, 0), // [1] Top-right
			new Vector3f( 1, -1, 0), // [2] Bottom-right
			new Vector3f( 0, -1, 0)  // [3] Bottom-left
	};
	
	// Index data for the quad
	private final static Vector3i[] index_data = {
		new Vector3i(0, 1, 2),
		new Vector3i(2, 3, 0)
	};
	
	public static DebugShader shader;
	
	/**
	 * Create a new Grid model object
	 * @throws Exception Something went wrong during initialization
	 */
	public Grid() throws Exception {
		// Create the new VAO with our grid data
		super(new VBOf("position", vertex_data_debug, GL15.GL_ARRAY_BUFFER, 0), new VBOi("index", index_data, GL15.GL_ELEMENT_ARRAY_BUFFER, 0), (shader = new DebugShader()));
	}
	
	@Override
	public void update() {
		// Call model's update
		super.update();
	}
}
