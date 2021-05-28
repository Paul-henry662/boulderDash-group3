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
		this.setX(this.getX()-1);
	}

	@Override
	public void moveRight() {
		this.setX(this.getX()+1);
		
	}

	@Override
	public void moveUp() {
		this.setX(this.getY()-1);
		
	}

	@Override
	public void moveDown() {
		this.setX(this.getY()+1);
	}
	
	public void animate() {
		this.setCurrentSprite(this.getSpriteByKey("flyPhaseOne"));
		this.delay(500);
		this.setCurrentSprite(this.getSpriteByKey("flyPhaseFour"));
		this.delay(500);
	}
	
	public void move() {
		this.moveRight();
		this.delay(500);
		this.moveDown();
		this.delay(500);
		this.moveLeft();
		this.delay(500);
		this.moveUp();
		this.delay(500);
	}
	
}
