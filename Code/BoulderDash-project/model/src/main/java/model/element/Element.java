package model.element;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import contract.IElement;

/**
 * The Class Element.
 *
 * @authors Paul-henry NGANKAM
 * 			Georges Arthur Balog
 * 			Prince Jordan Tankwa
 * 			Gregori Tema
 */
public abstract class Element implements IElement{
	
	/** Image sprites array for an element. */
	private HashMap<String, BufferedImage> sprites;
	private BufferedImage currentSprite;
	
	public BufferedImage getCurrentSprite() {
		return currentSprite;
	}

	protected void setCurrentSprite(BufferedImage currentSprite) {
		this.currentSprite = currentSprite;
	}

	/**Instantiates a new Element.
	 * 
	 * 
	 * @param imageUrl
	 * 		the base image url for element's sprites.
	 */
	public Element(String imageUrl) {
		this.sprites = new HashMap<String, BufferedImage>();
		try {
			this.loadImages(imageUrl);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public Element() {
		this.sprites = new HashMap<String, BufferedImage>();
	}
	
	/**Get an Element's image sprite by key
	 * 
	 * @param key
	 * @return
	 */
	public BufferedImage getSpriteByKey(String key) {
		return this.sprites.get(key);
	}

	/**Set an Element's image sprite by key
	 * 
	 * @param sprite
	 * 		the new sprite.
	 */
	protected void setSpriteByKey(String key, BufferedImage sprite) {
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
