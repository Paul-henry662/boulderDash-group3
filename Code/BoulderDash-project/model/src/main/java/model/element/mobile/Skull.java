package model.element.mobile;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * The Class Skull.
 *
 * @author Paul-henry NGANKAM
 * 			Georges Arthur Balog
 * 			Prince Jordan Tankwa
 * 			Gregori Tema
 */

public class Skull extends Enemy {
	public Skull(String imageUrl, int x, int y) {
		super(imageUrl, x, y);
	}
	
	public Skull() {
		super();
	}
	
	@Override
	public void loadImages(String imageUrl) throws IOException {
		BufferedImage baseImage = ImageIO.read(new File(imageUrl));
		
		BufferedImage PhaseOne = baseImage.getSubimage(64, 48, 16, 16);
		BufferedImage PhaseTwo = baseImage.getSubimage(64, 48, 16, 16);
		BufferedImage PhaseThree = baseImage.getSubimage(64, 48, 16, 16);
		BufferedImage PhaseFour = baseImage.getSubimage(64, 16, 16, 16);

		
		this.setSpriteByKey("PhaseOne", PhaseOne);
		this.setSpriteByKey("PhaseTwo", PhaseTwo);
		this.setSpriteByKey("PhaseThree", PhaseThree);
		this.setSpriteByKey("PhaseFour", PhaseFour);
		
		this.setCurrentSprite(this.getSpriteByKey("PhaseOne"));
	}

	@Override
	public void moveLeft() {
		this.setX(this.getX()-1);
	}

	@Override
	public void moveRight() {
		this.setX(this.getX()+1);
		
	}

	@Override
	public void moveUp() {
		this.setY(this.getY()-1);
		
	}

	@Override
	public void moveDown() {
		this.setY(this.getY()+1);
	}
	
}
