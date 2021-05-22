package contract;

import java.awt.image.BufferedImage;
import java.io.IOException;

public interface IElement {
	
	public BufferedImage getCurrentSprite();

	public void setCurrentSprite(BufferedImage currentSprite);

	
	/**Get an Element's image sprite by key
	 * 
	 * @param key
	 * @return
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
