package model.element.mobile;

import contract.IEnemy;
import contract.Permeability;
import model.element.motionless.Motionless;

/**
 * The Class Enemy.
 *
 * @author Paul-henry NGANKAM
 * 			Georges Arthur Balog
 * 			Prince Jordan Tankwa
 * 			Gregori Tema
 */

public abstract class Enemy extends Mobile implements IEnemy, Runnable{
	public Enemy(String imageUrl, int x, int y) {
		super(imageUrl, x, y);
		this.permeability = Permeability.DEADLY;
	}
	
	public Enemy() {
		this.permeability = Permeability.DEADLY;
	}
	
	public void animate() {
	}
	
	public void run() {
		this.animate();
	}
	
	public void move() {
		
	}
	
	protected void delay(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
