package model.element.mobile;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Butterfly extends Enemy {
	public Butterfly(String imageUrl, int x, int y) {
		super(imageUrl, x, y);
	}
	
	@Override
	public void loadImages(String imageUrl) throws IOException {
		BufferedImage baseImage = ImageIO.read(new File(imageUrl));
		
		BufferedImage flyPhaseOne = baseImage.getSubimage(176, 0, 16, 16);
		BufferedImage flyPhaseTwo = baseImage.getSubimage(176, 16, 16, 16);
		BufferedImage flyPhaseThree = baseImage.getSubimage(176, 32, 16, 16);
		BufferedImage flyPhaseFour = baseImage.getSubimage(176, 48, 16, 16);
		
		this.setSprite("flyPhaseOne", flyPhaseOne);
		this.setSprite("flyPhaseTwo", flyPhaseTwo);
		this.setSprite("flyPhaseThree", flyPhaseThree);
		this.setSprite("flyPhaseFour", flyPhaseFour);
	}
}
