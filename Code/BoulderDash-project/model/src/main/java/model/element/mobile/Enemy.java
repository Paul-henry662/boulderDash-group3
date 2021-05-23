package model.element.mobile;

/**
 * The Class Enemy.
 *
 * @authors Paul-henry NGANKAM
 * 			Georges Arthur Balog
 * 			Prince Jordan Tankwa
 * 			Gregori Tema
 */

public abstract class Enemy extends Mobile {
	public Enemy(String imageUrl, int x, int y) {
		super(imageUrl, x, y);
	}
	
	public Enemy() {
		
	}
}
