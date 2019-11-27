// Last edit: 05/04/2018 - TvB
package com.cekeh.utility;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;

import javax.imageio.ImageIO;

/**
 * Cekeh's Utility resource loader
 * Created 04/16/2018
 * @author Thomas vanBommel (TvB)
 */
public class ResourceLoader {

	/**
	 * Load plain text from a file location
	 * @param path The location where the file can be found starting with "FIRST_FOLDER_NAME/"
	 * @return The contents of the file in a String
	 * @throws IOException I/O exception of some sort (most likely an incorrect file path)
	 */
	public static String loadPlainText(String path) throws IOException {
		// String to store the content of the file
		String content = "";
		
		// Input stream of the file
		InputStream stream = ResourceLoader.class.getClassLoader().getResourceAsStream(path);
		
		// Reader that will read the file
		InputStreamReader reader = new InputStreamReader(stream);
		
		// Character to store the stream data
		int character;
		
		// Read the contents of the file byte by byte
		while((character = reader.read()) != -1) {
			content += String.valueOf((char) character);
		}
		
		// Close the reader
		reader.close();
		
		// Return the content of the file
		return content;
	}
	
	/**
	 * Load an image from a file location
	 * @param path The location where the file can be found starting with "FIRST_FOLDER_NAME/"
	 * @return The image requested as a buffered image
	 * @throws IllegalArgumentException Invalid path
	 * @throws IOException IO error has occurred (most likely an invalid path)
	 */
	public static BufferedImage loadImage(String path) throws IllegalArgumentException, IOException {
		// Input stream of the file
		InputStream stream = ResourceLoader.class.getClassLoader().getResourceAsStream(path);
		
		// Return the buffered image from ImageIO
		return ImageIO.read(stream);
	}
}
