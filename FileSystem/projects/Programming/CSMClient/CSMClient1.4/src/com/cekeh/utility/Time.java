// Last edit: 04/14/2018 - TvB
package com.cekeh.utility;

/**
 * Cekeh's Time object
 * Helps in keeping a steady FPS
 * Created 04/14/2018
 * @author Thomas vanBommel (TvB)
 */
public class Time {

	// Time constants
	public static final double NANOSECONDS_PER_SECOND = 1000000000;
	public static final double MILISECONDS_PER_SECOND = 1000000;
	
	// Target FPS, what we will use to calculate the sleep time
	private int target_fps = 60;
	
	// We will use this to store the time of the previous frame, to aid in our calculation for delta time
	private long before = System.nanoTime();
	
	// Time elapsed sense the previous frame divided by 1 second
	private double delta_time = 1d;
	
	// Current FPS, calculated every second
	private double current_fps = 0d;
	
	// Stuff for calculating current FPS
	private long second_timer = 0l;
	private int updates_per_second = 0;
	
	// Debug mode, prints the current FPS every second
	private boolean debug = false;
	
	/**
	 * Create a new Time object with the default target_fps of 60
	 */
	public Time() {}
	
	/**
	 * Create a new Time object with a specified target_fps
	 * @param target_fps
	 */
	public Time(int target_fps) {
		// Set the target_fps that we use for our calculations
		this.target_fps = target_fps;
	}
	
	/**
	 * Update the time object
	 * This should be used at the beginning of the game loop, and sleep() placed at the end for best results
	 */
	public void update() {
		// Add 1 update to the update counter
		updates_per_second++;
		
		// Get the current time in nanoseconds 1/1000000000th of a second
		long now = System.nanoTime();
		
		// Calculate delta time
		delta_time = (now - before) / NANOSECONDS_PER_SECOND;
		
		// Add time passed to the second_timer
		second_timer += (now - before);
		
		// Set before (previous frames time) to now (this frames time)
		before = now;
		
		// If second_timer >= 1 second; (Every second)
		if(second_timer > NANOSECONDS_PER_SECOND) {
			// Set the current FPS
			current_fps = (double) updates_per_second * ((double) second_timer / NANOSECONDS_PER_SECOND);
		
			// Reset timers/counters
			second_timer = 0l;
			updates_per_second = 0;
			
			// Print out the current FPS every second if debug is true
			if(debug) System.out.println(String.format("[FPS: %.2f]", current_fps));
		}
	}
	
	/**
	 * Sleep the current thread to maintain the target_fps
	 * update() should be called before this, at the beginning of the main-loop
	 * This should be place at the end of the main loop for best results
	 * @throws InterruptedException Another thread has interrupted this thread, unable to sleep
	 */
	public void sleep() throws InterruptedException {
		// Calculate the time to sleep to keep target_fps steady
		long time = (long) ((before - System.nanoTime() + (NANOSECONDS_PER_SECOND / target_fps)) / MILISECONDS_PER_SECOND);
	
		// Sleep the current thread to maintain the FPS
		if(time > 0) Thread.sleep(time);
	}
	
	/**
	 * Get the delta time between frames
	 * @return The (double) delta time between frames
	 */
	public double deltaTime() {
		// Return the delta time between frames
		return delta_time;
	}
}
