package model.element.mobile;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * The Class Butterfly.
 *
 * @authors Paul-henry NGANKAM
 * 			Georges Arthur Balog
 * 			Prince Jordan Tankwa
 * 			Gregori Tema
 */
public class Butterfly extends Enemy {
	public Butterfly(String imageUrl, int x, int y) {
		super(imageUrl, x, y);
	}
	
	public Butterfly() {
		super();
	}
	
	@Override
	public void loadImages(String imageUrl) throws IOException {
		BufferedImage baseImage = ImageIO.read(new File(imageUrl));
		
		BufferedImage flyPhaseOne = baseImage.getSubimage(160, 0, 16, 16);
		BufferedImage flyPhaseTwo = baseImage.getSubimage(160, 16, 16, 16);
		BufferedImage flyPhaseThree = baseImage.getSubimage(160, 32, 16, 16);
		BufferedImage flyPhaseFour = baseImage.getSubimage(160, 48, 16, 16);
		
		this.setSpriteByKey("flyPhaseOne", flyPhaseOne);
		this.setSpriteByKey("flyPhaseTwo", flyPhaseTwo);
		this.setSpriteByKey("flyPhaseThree", flyPhaseThree);
		this.setSpriteByKey("flyPhaseFour", flyPhaseFour);
		
		this.setCurrentSprite(this.getSpriteByKey("flyPhaseOne"));
	}

	@Override
	public void moveLeft() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveRight() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveUp() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveDown() {
		// TODO Auto-generated method stub
		
	}
	
	public void animate() {
		this.setCurrentSprite(this.getSpriteByKey("flyPhaseOne"));
		this.delay(500);
		this.setCurrentSprite(this.getSpriteByKey("flyPhaseFour"));
		this.delay(500);
	}

	
}
