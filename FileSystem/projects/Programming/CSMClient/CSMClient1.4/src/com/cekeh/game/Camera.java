// Last edit: 05/06/2018 - TvB
package com.cekeh.game;

import com.cekeh.utility.CameraController;
import com.cekeh.utility.Transform;

/**
 * Cekeh's Camera object
 * Created 04/27/2018
 * @author Thomas vanBommel (TvB)
 */
public class Camera{
	
	// The camera's controller
	CameraController controller = new CameraController(this);
	
	// The camera's position
	public Transform transform = new Transform();
	
	/**
	 * Create a new camera object
	 */
	public Camera() {
	}
	
	public void update(double delta) {
		// Update the controller
		controller.update(delta);
	}
}
