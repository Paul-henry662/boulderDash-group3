package model.element.mobile;

import contract.IMobile;
import model.element.Element;

/**
 * The Class Mobile.
 *
 * @author Paul-henry NGANKAM
 * 			Georges Arthur Balog
 * 			Prince Jordan Tankwa
 * 			Gregori Tema
 */

public abstract class Mobile extends Element implements IMobile{
	
	/** The x position of a Mobile element*/
	private int x;
	
	/** The y position of a Mobile element*/
	private int y;
	
	/** Instantiates a new Mobile element
	 * 
	 * @param imageUrl
	 * 		element's image sprite url.
	 */
	public Mobile(String imageUrl, int x, int y) {
		super(imageUrl);
		this.setX(x);
		this.setY(y);
	}
	
	public Mobile() {
		super();
	}
	
	/** Get the x position of a Mobile element*/
	public int getX() {
		return x;
	}

	/** Set the x position of a Mobile element
	 * 
	 * @param x
	 * 		the new x position.
	 */
	protected void setX(int x) {
		this.x = x;
	}
	
	/** Get the y position of a Mobile element*/
	public int getY() {
		return y;
	}
	
	/** Set the y position of a Mobile element
	 * 
	 * @param y
	 * 		the new y position.
	 */
	protected void setY(int y) {
		this.y = y;
	}
	
	/**Move a Mobile element on the left*/
	public abstract void moveLeft();
	
	/**Move a Mobile element on the right*/
	public abstract void moveRight();
	
	/**Move a Mobile element upward*/
	public abstract void moveUp();
	
	/**Move a Mobile element downward*/
	public abstract void moveDown();
}
