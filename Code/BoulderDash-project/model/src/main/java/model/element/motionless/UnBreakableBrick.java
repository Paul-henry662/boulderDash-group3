package model.element.motionless;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import contract.Permeability;

public class UnBreakableBrick extends Brick {
	public UnBreakableBrick(String imageUrl) {
		super(imageUrl);
		this.permeability = Permeability.BLOCKING;
	}
	
	public UnBreakableBrick() {
		super();
	}
	
	@Override
	public void loadImages(String imageUrl) throws IOException {
		BufferedImage baseImage = ImageIO.read(new File(imageUrl));
		
		BufferedImage normal = baseImage.getSubimage(0, 0, 16, 16);
		BufferedImage blue = baseImage.getSubimage(96, 0, 16, 16);
		
		this.setSpriteByKey("normal", normal);
		this.setSpriteByKey("blue", blue);
		this.setCurrentSprite(this.getSpriteByKey("normal"));
	}
	
}
