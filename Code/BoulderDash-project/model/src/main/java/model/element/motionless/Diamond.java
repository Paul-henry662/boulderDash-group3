package model.element.motionless;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import contract.Permeability;

public class Diamond extends Motionless {
	public Diamond(String imageUrl) {
		super(imageUrl);
		this.permeability = Permeability.PICKABLE;
	}
	
	public Diamond() {
		super();
	}
	
	@Override
	public void loadImages(String imageUrl) throws IOException {
		BufferedImage baseImage = ImageIO.read(new File(imageUrl));
		BufferedImage normal = baseImage.getSubimage(64, 0, 16, 16);
		
		this.setSpriteByKey("normal", normal);
		this.setCurrentSprite(this.getSpriteByKey("normal"));
	}
}
