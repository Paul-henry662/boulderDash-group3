package contract;

import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * The Interface IElement.
 *
 * @authors Paul-henry NGANKAM
 * 			Georges Arthur Balog
 * 			Prince Jordan Tankwa
 * 			Gregori Tema
 */

public interface IElement {
	
	/** Get the current sprite of an element. */
	public BufferedImage getCurrentSprite();
	
	/** Set the current sprite of an element. */
	public void setCurrentSprite(BufferedImage currentSprite);

	/**Get an Element's image sprite by key
	 * 
	 * @param key
	 * @return the sprite associated with the key
	 */
	public BufferedImage getSpriteByKey(String key);

	
	/**Load images for Element's sprites
	 * 
	 * @param imageUrl
	 * 			the url of the base image.
	 * @throws IOException 
	 */
	public void loadImages(String imageUrl) throws IOException;
}
