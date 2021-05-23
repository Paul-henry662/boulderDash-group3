package model.element.motionless;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class UnBreakableBrick extends Brick {
	public UnBreakableBrick(String imageUrl) {
		super(imageUrl);
	}
	
	public UnBreakableBrick() {
		super();
	}
	
	@Override
	public void loadImages(String imageUrl) throws IOException {
		BufferedImage baseImage = ImageIO.read(new File(imageUrl));
		
		BufferedImage normal = baseImage.getSubimage(0, 0, 16, 16);
		
		this.setSpriteByKey("normal", normal);
		this.setCurrentSprite(this.getSpriteByKey("normal"));
	}
	
}