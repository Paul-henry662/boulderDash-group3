package model.element.mobile;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * The Class Rockford.
 *
 * @author Paul-henry NGANKAM
 * 			Georges Arthur Balog
 * 			Prince Jordan Tankwa
 * 			Gregori Tema
 */
public class Rockford extends Mobile {
	
	public boolean isAlive;
	/** Instantiates a new Rockford
	 * 
	 * @param imageUrl
	 * 		Rockford's image sprite url.
	 */
	public Rockford(String imageUrl, int x, int y) {
		super(imageUrl, x, y);
	}
	
	/** Instantiates a new Rockford.*/
	public Rockford() {
		super();
		this.isAlive = true;
	}

	@Override
	public void loadImages(String imageUrl) throws IOException {
		BufferedImage baseImage = ImageIO.read(new File(imageUrl));
		
		BufferedImage stepRightPhaseOne = baseImage.getSubimage(0, 48, 16, 16);
		BufferedImage stepRightPhaseTwo = baseImage.getSubimage(16, 48, 16, 16);
		BufferedImage stepRightPhaseThree = baseImage.getSubimage(32, 48, 16, 16);
		
		BufferedImage stepLeftPhaseOne = baseImage.getSubimage(0, 16, 16, 16);
		BufferedImage stepLeftPhaseTwo = baseImage.getSubimage(16, 16, 16, 16);
		BufferedImage stepLeftPhaseThree = baseImage.getSubimage(32, 16, 16, 16);
		
		BufferedImage stepUp = baseImage.getSubimage(32, 80, 16, 16);
		BufferedImage stepDown = baseImage.getSubimage(0, 80, 16, 16);

		BufferedImage dead = baseImage.getSubimage(64, 80, 16, 16);
		
		this.setSpriteByKey("stepRightPhaseOne", stepRightPhaseOne);
		this.setSpriteByKey("stepRightPhaseTwo", stepRightPhaseTwo);
		this.setSpriteByKey("stepRightPhaseThree", stepRightPhaseThree);
		this.setSpriteByKey("stepLeftPhaseOne", stepLeftPhaseOne);
		this.setSpriteByKey("stepLeftPhaseTwo", stepLeftPhaseTwo);
		this.setSpriteByKey("stepLeftPhaseThree", stepLeftPhaseThree);
		this.setSpriteByKey("stepUp", stepUp);
		this.setSpriteByKey("stepDown", stepDown);
		this.setSpriteByKey("dead", dead);
		this.setCurrentSprite(this.getSpriteByKey("stepRightPhaseOne"));
	}

	public void moveLeft() {
		this.setX(this.getX()-1);
		this.setCurrentSprite(this.getSpriteByKey("stepLeftPhaseOne"));
	}
	
	public void moveRight() {
		this.setX(this.getX()+1);
		this.setCurrentSprite(this.getSpriteByKey("stepRightPhaseOne"));
	}
	
	public void moveUp() {
		this.setY(this.getY()-1);
		this.setCurrentSprite(this.getSpriteByKey("stepUp"));
	}
	
	public void moveDown() {
		this.setY(this.getY()+1);
		this.setCurrentSprite(this.getSpriteByKey("stepDown"));
	}
}
