package model.element.mobile;

import model.element.motionless.Motionless;

/**
 * The Class Enemy.
 *
 * @authors Paul-henry NGANKAM
 * 			Georges Arthur Balog
 * 			Prince Jordan Tankwa
 * 			Gregori Tema
 */

public abstract class Enemy extends Motionless {
	public Enemy(String imageUrl) {
		super(imageUrl);
	}
	
	public Enemy() {
		
	}
}
