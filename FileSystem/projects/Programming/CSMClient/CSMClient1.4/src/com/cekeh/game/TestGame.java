// Last edit: 05/17/2018 - TvB
package com.cekeh.game;

import com.cekeh.models.Grid;
import com.cekeh.models.Model;
import com.cekeh.models.Quad;
import com.cekeh.opengl.Game;
import com.cekeh.opengl.OpenGLException;

/**
 * Cekeh's Test game
 * Created 04/14/2018
 * @author Thomas vanBommel (TvB)
 */
public class TestGame extends Game {

	// Models to render for testing
	Model[] models = {
			new Quad(),
			new Grid()
	};
	
	/**
	 * Create a new test game
	 * @throws Exception Unable to find files
	 */
	public TestGame() throws Exception {}
	
	/**
	 * Initialize the test game
	 * @throws OpenGLException Unable to link the shader's to the shader program 
	 * @throws OpenGLException Unable to validate the shader program
	 */
	@Override
	public void initialize() throws Exception {		
		// Initialize our game
		super.initialize();
		
		// Initialize our models
//		for(Model model: models)
//			model.initialize();
		
		models[1].initialize();
		models[0].initialize();
	}

	/**
	 * Update the game before rendering
	 * @param delta DeltaTime between each frame
	 */
	@Override
	public void update(double delta) {
		// Update our game
		super.update(delta);
		
		// Update our models
		for(Model model: models)
			model.update();
	}

	/**
	 * Render the game to the screen, so the player knows what's going on
	 */
	@Override
	public void render() {
		// Render our models
		for(Model model: models)
			model.render();
	}

	/**
	 * Clean any memory resources used
	 */
	@Override
	public void cleanUp() {
		// Clean up our models
		for(Model model: models)
			model.cleanUp();
	}
}
