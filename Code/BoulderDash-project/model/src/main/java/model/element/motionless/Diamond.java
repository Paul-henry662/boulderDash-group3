package model.element.motionless;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Diamond extends Motionless {
	public Diamond(String imageUrl) {
		super(imageUrl);
	}
	
	public Diamond() {
		super();
	}
	
	@Override
	public void loadImages(String imageUrl) throws IOException {
		BufferedImage normalVersion = ImageIO.read(new File(imageUrl));
		
		this.setSpriteByKey("normal", normalVersion);
		this.setCurrentSprite(this.getSpriteByKey("normal"));
	}
}
