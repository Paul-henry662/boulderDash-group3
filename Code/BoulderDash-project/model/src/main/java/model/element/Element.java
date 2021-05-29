package model.element;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import contract.IElement;
import contract.Permeability;
import entity.Entity;

/**
 * The Class Element.
 *
 * @author Paul-henry NGANKAM
 * 			Georges Arthur Balog
 * 			Prince Jordan Tankwa
 * 			Gregori Tema
 */
public abstract class Element implements IElement{
	
	/** Image sprites array for an element. */
	
	private HashMap<String, BufferedImage> sprites;
	private BufferedImage currentSprite;
	protected Permeability permeability;
	
	public Permeability getPermeability() {
		return permeability;
	}

	private void setPermeability(Permeability permeability) {
		this.permeability = permeability;
	}

	public BufferedImage getCurrentSprite() {
		return currentSprite;
	}

	public void setCurrentSprite(BufferedImage currentSprite) {
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
	 * 		The key is 
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
