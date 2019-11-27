// Last edit: 05/01/2018 - TvB
package com.cekeh.glfw;

import static org.lwjgl.glfw.GLFW.*;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWErrorCallbackI;
import org.lwjgl.glfw.GLFWKeyCallbackI;
import org.lwjgl.glfw.GLFWWindowSizeCallbackI;

import com.cekeh.main.Client;

/**
 * Cekeh's Window class made with GLFW
 * Created 04/13/2018
 * @author Thomas vanBommel (TvB)
 */
public class Window {
	
	// Default window title
	public static final String DEFAULT_WINDOW_TITLE = "CSMClient 1.4";
	
	// Default window size
	public static final int DEFAULT_WINDOW_WIDTH = 750;
	public static final int DEFAULT_WINDOW_HEIGHT = 750;// (DEFAULT_WINDOW_WIDTH / 16) * 9
	
	// GLFW handle/reference ID
	private final long window_handle;
	
	// The width and height of the frame buffer
	private int frame_buffer_width = DEFAULT_WINDOW_WIDTH;
	private int frame_buffer_height = DEFAULT_WINDOW_HEIGHT;
	
	// Key event for our window
	private KeyEvent key_event = new KeyEvent();
	
	private MouseEvent mouse_event = new MouseEvent();
	
	/**
	 * Create a new window with default width, height, and title
	 * @throws Exception GLFW error
	 */
	public Window() throws Exception {
		// Create a default window
		this(
			DEFAULT_WINDOW_WIDTH,
			DEFAULT_WINDOW_HEIGHT,
			DEFAULT_WINDOW_TITLE
		);
	}
	
	/**
	 * Create a new window with specified width, height, and title
	 * @param width The specified width of the window in pixels
	 * @param height The specified height of the window in pixels
	 * @param title The specified title of the window
	 * @throws GLFWException GLFW error
	 */
	public Window(int width, int height, String title) throws Exception {
		// Set the frame buffer width and height
		frame_buffer_width = width;
		frame_buffer_height = height;
		
		// Initialize GLFW
		initialize();
		
		// Create the GLFW window
		window_handle = createWindow(width, height, title);
	}
	
	/**
	 * Initialize GLFW
	 * @throws GLFWException Unable to initialize GLFW
	 */
	private void initialize() throws GLFWException {
		// Error callback
		glfwSetErrorCallback(error);
		
		// Ensure GLFW is initialized
		if(!glfwInit()) throw new GLFWException("Unable to initialize GLFW");
	}
	
	GLFWErrorCallbackI error = new GLFWErrorCallbackI() {
		@Override
		public void invoke(int error, long description) {
			System.out.println("ERROR: " + error + " - " + description);
		}
	};
	
	/**
	 * Create a new GLFW window with specified width, height, and title
	 * @param width The specified width of the window in pixels
	 * @param height The specified height of the window in pixels
	 * @param title The specified title of the window
	 * @return The handle/reference ID for the new GLFW window
	 * @throws GLFWException Unable to create a new GLFW window
	 */
	private long createWindow(int width, int height, String title) throws GLFWException {
		// Create a new GLFW window
		long handle = glfwCreateWindow(width, height, title, 0, 0);
		
		// Check to see if GLFW create us a window to play with
		if(handle == 0) throw new GLFWException("Unable to create a new GLFW window");
		
		// TODO: Window settings
		glfwSetWindowSizeCallback(handle, sizeCallback());
		glfwSetKeyCallback(handle, key_event);
		glfwSetCursorPosCallback(handle, mouse_event);
		
		// Set window context to accept rendering from this (main) thread
		glfwMakeContextCurrent(handle);
		
		// Return the window handle/reference ID
		return handle;
	}
	
	/**
	 * Poll the window for any updates, will also poll events (minimize, maximize, close, move, etc...)
	 */
	public void pollEvents() {
		// TODO: fix
		mouse_event.update();
		
		// Poll for window events (minimize, maximize, close, move, etc...)
		glfwPollEvents();
	}
	
	/**
	 * Poll GLFW if the window should close
	 * @return True if the window should close, False if the window should stay open
	 */
	public boolean windowShouldClose() {
		// GLFW will tell us before closing the window
		return glfwWindowShouldClose(window_handle);
	}
	
	/**
	 * Callback for when our GLFW window changes size
	 * @return The GLFWWindowSizeCallbackI object required for GLFW
	 */
	private GLFWWindowSizeCallbackI sizeCallback() {
		// Create a new GLFWWindowSizeCallback
		GLFWWindowSizeCallbackI callback = new GLFWWindowSizeCallbackI() {
			@Override
			public void invoke(long window, int width, int height) {
				// Set the new size of the frame buffer
				frame_buffer_width = width;
				frame_buffer_height = height;
				
				// Update the games view port
				Client.game.updateViewport(width, height);
			}
		};
		
		// Return the new callback
		return callback;
	}
	
	/**
	 * Swap buffers to reveal the newly generated frame
	 */
	public void swapBuffers() {
		// Swap context buffers
		glfwSwapBuffers(window_handle);
	}
	
	/**
	 * Get the width of the frame buffer
	 * @return The width of the window frame buffer
	 */
	public int getWidth() {
		// Return the width of the frame buffer
		return frame_buffer_width;
	}
	
	/**
	 * Get the height of the frame buffer
	 * @return The height of the window frame buffer
	 */
	public int getHeight() {
		// Return the height of the frame buffer
		return frame_buffer_height;
	}
	
	/**
	 * Get the aspect ratio of the frame buffer (window minus the navigation bar)
	 * @return The aspect ratio of the frame buffer
	 */
	public float getAspectRatio() {
		// Calculate the aspect ratio of the frame buffer
		return (float) frame_buffer_width / (float) frame_buffer_height;
	}
	
	/**
	 * Get the key event object for the window
	 * @return The KeyEvent object for the window
	 */
	public KeyEvent getKeyEvent() {
		// Return the key event for the window
		return key_event;
	}
	
	/**
	 * Get the mouse event object for the window
	 * @return The MouseEvent object for the window
	 */
	public MouseEvent getMouseEvent() {
		// Return the mouse event object
		return mouse_event;
	}
	
	/**
	 * Clean up any memory resources used
	 */
	public void cleanUp() {
		// Terminate GLFW as requested by their java-doc
		if(glfwInit()) glfwTerminate();
	}
}
