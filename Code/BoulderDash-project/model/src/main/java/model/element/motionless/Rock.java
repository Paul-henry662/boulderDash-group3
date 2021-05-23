package model.element.motionless;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * The Class Rock
 * @authors PAD-PCA-NGOUNOU
 *
 */
public class Rock extends Motionless{
	
	public Rock(String imageUrl) {
		super(imageUrl);
	}
	
	public Rock() {
		super();
	}
	
	@Override
	public void loadImages(String imageUrl) throws IOException {
		BufferedImage baseImage = ImageIO.read(new File(imageUrl));
		BufferedImage normal = baseImage.getSubimage(48, 0, 16, 16);
		
		this.setSpriteByKey("normal", normal);
		this.setCurrentSprite(this.getSpriteByKey("normal"));
	}
	
	
}
