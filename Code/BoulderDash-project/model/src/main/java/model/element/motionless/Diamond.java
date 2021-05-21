package model.element.motionless;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Diamond extends Motionless {
	public Diamond(String imageUrl) {
		super(imageUrl);
	}
	
	@Override
	public void loadImages(String imageUrl) throws IOException {
		BufferedImage normalVersion = ImageIO.read(new File(imageUrl));
		
		this.setSprite("normal", normalVersion);
	}
}
