package model.element.motionless;

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
public abstract class Motionless extends Element {
	
	protected Permeability permeability;
	
	public Motionless(String imageUrl) {
		super(imageUrl);
	}
	
	public Motionless() {
		super();
	}
	
	public Permeability getPermeability() {
		return permeability;
	}
}
