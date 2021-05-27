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
	
	public void setCurrentSprite(BufferedImage currentSprite);
	
	public BufferedImage getSpriteByKey(String key);
}
