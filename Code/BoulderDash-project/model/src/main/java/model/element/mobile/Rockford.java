package model.element.mobile;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Rockford extends Mobile {
	/** Instantiates a new Rockford
	 * 
	 * @param imageUrl
	 * 		Rockford's image sprite url.
	 */
	public Rockford(String imageUrl, int x, int y) {
		super(imageUrl, x, y);
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
		
		this.setSprite("stepRightPhaseOne", stepRightPhaseOne);
		this.setSprite("stepRightPhaseTwo", stepRightPhaseTwo);
		this.setSprite("stepRightPhaseThree", stepRightPhaseThree);
		this.setSprite("stepLeftPhaseOne", stepLeftPhaseOne);
		this.setSprite("stepLeftPhaseTwo", stepLeftPhaseTwo);
		this.setSprite("stepLeftPhaseThree", stepLeftPhaseThree);
	}
}
