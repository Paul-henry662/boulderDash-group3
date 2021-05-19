package model.element;

import java.awt.image.BufferedImage;
import java.util.HashMap;

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
	}
	
	/**Get an Element's image sprite by key
	 * 
	 * @param key
	 * @return
	 */
	public BufferedImage getSprite(String key) {
		return null;
	}

	/**Set an Element's image sprite by key
	 * 
	 * @param sprite
	 * 		the new sprite.
	 */
	private void setSprite(String key, BufferedImage sprite) {
	}
	
	/**Load images for Element's sprites
	 * 
	 * @param imageUrl
	 * 			the url of the base image.
	 */
	public void loadImages(String imageUrl) {
		
	}
}
