// Last edit: 05/13/2018 - TvB
package com.cekeh.models;

import com.cekeh.main.Client;
import com.cekeh.opengl.ShaderProgram;
import com.cekeh.opengl.VAO;
import com.cekeh.opengl.VBOf;
import com.cekeh.opengl.VBOi;
import com.cekeh.utility.Transform;

/**
 * Cekeh's Model class
 * Created 04/22/2018
 * @author Thomas vanBommel (TvB)
 */
public abstract class Model extends VAO{

	// The transform (position, rotation, and scale) of the model
	private Transform transform = new Transform();
	
	// The shader we will use to render our model/VAO
	private ShaderProgram shader;
	
	/**
	 * Create a new model/VAO with specified vertex, index (triangle), and shader (shader program) data
	 * @param vertex The vertex data to add to this model/VAO
	 * @param index The index data to add to this model/VAO
	 * @param shader The shader data to add to this model/VAO
	 */
	protected Model(VBOf vertex, VBOi index, ShaderProgram shader) {
		super(vertex, index, shader);
		
		// Set shader
		this.shader = shader;
	}
	
	/**
	 * Update this object before rendering
	 */
	public void update() {
		// Set the window aspect ratio
		shader.setUniform1f("aspectRatio", Client.window.getAspectRatio());
		
		try {
			// Set the VAO's transformation matrix
			shader.setUniformMatrix4fv("transformation_matrix", transform.getTransformationMatrix());
			
			// Set the VAO's view matrix (camera)
			shader.setUniformMatrix4fv("view_matrix", Client.game.getCamera().transform.getTransformationMatrix());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Get the transform for this mode/VAO
	 * @return The transform object representing where this model/VAO is in space
	 */
	public Transform getTransform() {
		// Return this model's transform
		return transform;
	}
}
