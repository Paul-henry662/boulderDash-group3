package model.element;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

public abstract class Element {
	
	/** Image sprites array for an element. */
	private HashMap<String, BufferedImage> sprites;
	
	/**Instantiates a new Element.
	 * 
	 * 
	 * @param imageUrl
	 * 		the base image url for element's sprites.
	 */
	public Element(String imageUrl) {
		this.sprites = new HashMap<String, BufferedImage>();
	}
	
	/**Get an Element's image sprite by key
	 * 
	 * @param key
	 * @return
	 */
	public BufferedImage getSprite(String key) {
		return this.sprites.get(key);
	}

	/**Set an Element's image sprite by key
	 * 
	 * @param sprite
	 * 		the new sprite.
	 */
	protected void setSprite(String key, BufferedImage sprite) {
		this.sprites.put(key, sprite);
	}
	
	/**Load images for Element's sprites
	 * 
	 * @param imageUrl
	 * 			the url of the base image.
	 * @throws IOException 
	 */
	public void loadImages(String imageUrl) throws IOException {
	}
}
