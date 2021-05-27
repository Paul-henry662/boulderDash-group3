package model.element.motionless;

import contract.IMotionless;
import contract.Permeability;
import model.element.Element;

/**
 * The Class Motionless.
 *
 * @authors Paul-henry NGANKAM
 * 			Georges Arthur Balog
 * 			Prince Jordan Tankwa
 * 			Gregori Tema
 */
public abstract class Motionless extends Element implements IMotionless{
		
	public Motionless(String imageUrl) {
		super(imageUrl);
	}
	
	public Motionless() {
		super();
	}
	
}
